package org.example.aitestpro.service.impl;

import org.example.aitestpro.converter.TestCaseConverter;
import org.example.aitestpro.dao.TestCaseMapper;
import org.example.aitestpro.dto.TestCaseDTO;
import org.example.aitestpro.entity.TestCase;
import org.example.aitestpro.service.CaseService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
public class CaseServiceImpl implements CaseService {
    @Resource
    TestCaseMapper testCaseMapper;
    @Resource
    TestCaseConverter testCaseConverter;

    @Override
    public Optional<List<TestCaseDTO>> listCase() {
        List<TestCaseDTO> testCaseDTOList = new ArrayList<>();
        List<TestCase> testCaseList = testCaseMapper.selectAll();
        testCaseList.forEach(testCase -> {
            testCaseDTOList.add(testCaseConverter.toTestCaseDTO(testCase));
        });
        return Optional.of(testCaseDTOList);
    }

    @Override
    public Integer addCase2(TestCaseDTO testCaseDTO) {
        TestCase testCase = testCaseConverter.toTestCase(testCaseDTO);
        LocalDateTime now = LocalDateTime.now();
        testCase.setCreateTime(now);
        testCase.setUpdateTime(now);

        return testCaseMapper.insert(testCase);
    }
    @Override
    public Integer addCase(List<TestCaseDTO> testCaseDTOList) {
        List<TestCase> testCaseList = new ArrayList<>();
        testCaseDTOList.forEach(testCaseDTO -> {
            TestCase testCase = testCaseConverter.toTestCase(testCaseDTO);
            System.out.println("转化后的testCase-------"+testCase);

            LocalDateTime now = LocalDateTime.now();
            testCase.setCreateTime(now);
            testCase.setUpdateTime(now);
            String format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(now);
            if(1 == testCase.getType()){
                testCase.setRemark("自动导入用例，时间为：" + format);
            }
            testCaseList.add(testCase);
        });
        return testCaseMapper.insertList(testCaseList);
    }

    @Override
    public Integer updateCase(TestCaseDTO testCaseDTO) {
        TestCase testCase = testCaseConverter.toTestCase(testCaseDTO);

        Example example = new Example(TestCase.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("id", testCase.getId());

        List<TestCase> testCaseList = testCaseMapper.selectByExample(example);
        TestCase testCase1 = testCaseList.get(0);
        if(testCase1.getId().equals(testCase.getId())) {
            testCase1.setCaseTitle(testCase.getCaseTitle());
            testCase1.setCaseData(testCase.getCaseData());
            testCase1.setStep(testCase.getStep());
            testCase1.setMethod(testCase.getMethod());
            testCase1.setPath(testCase.getPath());
            testCase1.setRemark(testCase.getRemark());
            LocalDateTime now = LocalDateTime.now();
            testCase1.setUpdateTime(now);
            return testCaseMapper.updateByPrimaryKeySelective(testCase1);
        }
        return 0;
    }
    @Override
    public Integer deleteCase(TestCaseDTO testCaseDTO) {
        TestCase testCase = testCaseConverter.toTestCase(testCaseDTO);
        TestCase testCase1 = testCaseMapper.selectByPrimaryKey(testCase.getId());

        if(null != testCase1) {
            Integer num = testCaseMapper.deleteByPrimaryKey(testCase1.getId());
            return num;
        }
        return 0;
    }

}
