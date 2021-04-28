package com.azure.autorest.mapper;

import com.azure.autorest.extension.base.model.codemodel.ChoiceSchema;
import com.azure.autorest.extension.base.model.codemodel.ChoiceValue;
import com.azure.autorest.extension.base.plugin.JavaSettings;
import com.azure.autorest.model.clientmodel.ClassType;
import com.azure.autorest.model.clientmodel.ClientEnumValue;
import com.azure.autorest.model.clientmodel.EnumType;
import com.azure.autorest.model.clientmodel.IType;
import com.azure.autorest.util.CodeNamer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Pattern;

public class ChoiceMapper implements IMapper<ChoiceSchema, IType> {
    private static ChoiceMapper instance = new ChoiceMapper();
    Map<ChoiceSchema, IType> parsed = new HashMap<>();

    private ChoiceMapper() {
    }

    public static ChoiceMapper getInstance() {
        return instance;
    }

    @Override
    public IType map(ChoiceSchema enumType) {
        if (enumType == null) {
            return null;
        }

        JavaSettings settings = JavaSettings.getInstance();

        if (parsed.containsKey(enumType)) {
            return parsed.get(enumType);
        }
        IType _itype;
        String enumTypeName = enumType.getLanguage().getJava().getName();

        if (enumTypeName == null || enumTypeName.isEmpty() || enumTypeName.equals("enum")) {
            _itype = ClassType.String;
        } else {
            String enumSubpackage = settings.getModelsSubpackage();
            if (settings.isCustomType(enumTypeName)) {
                enumSubpackage = settings.getCustomTypesSubpackage();
            }
            String enumPackage = settings.getPackage(enumSubpackage);

            List<ClientEnumValue> enumValues = new ArrayList<>();
            for (ChoiceValue enumValue : enumType.getChoices()) {
                final String memberName = getEnumMemberName(enumValue, settings);
                long counter = enumValues.stream().filter(v -> v.getName().equals(memberName)).count();
                if (counter > 0) {
                    enumValues.add(new ClientEnumValue(memberName + "_" + counter, enumValue.getValue()));
                } else {
                    enumValues.add(new ClientEnumValue(memberName, enumValue.getValue()));
                }
            }

            _itype = new EnumType.Builder()
                    .packageName(enumPackage)
                    .name(enumTypeName)
                    .expandable(true)
                    .values(enumValues)
                    .elementType(Mappers.getSchemaMapper().map(enumType.getChoiceType()))
                    .build();
            parsed.put(enumType, _itype);
        }

        return _itype;
    }

    private String getEnumMemberName(ChoiceValue enumValue, JavaSettings settings) {
        String memberName;
        String enumName = enumValue.getValue();
        if (enumValue.getLanguage() != null && enumValue.getLanguage().getJava() != null
                && enumValue.getLanguage().getJava().getName() != null) {
            enumName = enumValue.getLanguage().getJava().getName();
        } else if (enumValue.getLanguage() != null && enumValue.getLanguage().getDefault() != null
                && enumValue.getLanguage().getDefault().getName() != null) {
            enumName = enumValue.getLanguage().getDefault().getName();
        }
        if (!settings.isFluent()) {
            memberName = CodeNamer.getEnumMemberName(enumName);
        } else {
            // there exists cases that namer in modelerfour doing a really poor job on enum values, hence for Fluent still do this on raw enum values
            String candidateMemberNameFromM4 = CodeNamer.getEnumMemberName(enumName);
            String candidateMemberNameFromValue = CodeNamer.getEnumMemberName(enumValue.getValue());
            if (Objects.equals(
                    candidateMemberNameFromM4.replaceAll(Pattern.quote("_"), ""),
                    candidateMemberNameFromValue.replaceAll(Pattern.quote("_"), ""))) {
                memberName = candidateMemberNameFromValue;
            } else {
                // use name from M4, since it appears that the name is customized by 'x-ms-enum.values.name'
                memberName = candidateMemberNameFromM4;
            }
        }
        return memberName;
    }
}
