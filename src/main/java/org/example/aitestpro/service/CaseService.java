package org.example.aitestpro.service;


import org.example.aitestpro.dto.TestCaseDTO;
import java.util.List;
import java.util.Optional;

public interface CaseService {

    Optional<List<TestCaseDTO>> listCase();
    Integer addCase(List<TestCaseDTO> testCaseDTOList);
    Integer addCase2(TestCaseDTO testCaseDTO);
    Integer updateCase(TestCaseDTO testCaseDTO);
    Integer deleteCase(TestCaseDTO testCaseDTO);
}
