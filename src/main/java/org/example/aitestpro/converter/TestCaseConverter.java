package org.example.aitestpro.converter;

import org.example.aitestpro.dto.TestCaseDTO;
import org.example.aitestpro.entity.TestCase;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface TestCaseConverter {
    @Mappings({
            @Mapping(target = "id",source = "id"),
            @Mapping(target = "caseTitle",source = "caseTitle"),
            @Mapping(target = "remark",source = "remark"),
            @Mapping(target = "method",source = "method"),
            @Mapping(target = "step",source = "step"),
            @Mapping(target = "caseData",source = "caseData"),
            @Mapping(target = "path",source = "path"),
            @Mapping(target = "type",source = "type"),
    })
    public TestCase toTestCase(TestCaseDTO testCaseDTO);

    @Mappings({
            @Mapping(target = "id",source = "id"),
            @Mapping(target = "caseTitle",source = "caseTitle"),
            @Mapping(target = "remark",source = "remark"),
            @Mapping(target = "method",source = "method"),
            @Mapping(target = "step",source = "step"),
            @Mapping(target = "caseData",source = "caseData"),
            @Mapping(target = "path",source = "path"),
            @Mapping(target = "type",source = "type"),
    })
    public TestCaseDTO toTestCaseDTO(TestCase testCase);
}
