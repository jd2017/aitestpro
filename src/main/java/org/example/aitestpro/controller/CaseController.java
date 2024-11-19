package org.example.aitestpro.controller;

import org.example.aitestpro.dto.TestCaseDTO;
import org.example.aitestpro.service.CaseService;
import org.example.aitestpro.util.R;
import org.example.aitestpro.util.ResultCode;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("case")
public class CaseController {

    @Resource
    CaseService caseService;

    @GetMapping("/listcase")
    public R listCase(){
        Optional<List<TestCaseDTO>> testCaseDtoList = caseService.listCase();
        if(testCaseDtoList.isEmpty()){
            return R.error().message("用例为空");
        }
        return R.ok().data(testCaseDtoList).message("获取所有用例");
    }

    @PostMapping(value = "/addcase",produces = "application/json")
    public R addCase(@RequestBody List<TestCaseDTO> testCaseDTOList){

        if(null != testCaseDTOList){
            Integer addCaseNum = caseService.addCase(testCaseDTOList);
            return R.ok().data(addCaseNum).message("添加成功测试用例");
        }
        return R.error().code(5001).message("测试用例未添加成功");
    }
    @PutMapping(value = "/updatacase",produces = "application/json")
    public R updataCase(@RequestBody TestCaseDTO testCaseDTO){

        Integer num = caseService.updateCase(testCaseDTO);
        if (num>0)
            return R.ok().code(ResultCode.SUCCESS).data("更新数据条数"+num).message("更新数据成功");
        return R.error().code(ResultCode.ERROR).data("更新数据条数"+num).message("更新不成功");
    }
    @DeleteMapping(value = "/deletecase",produces = "application/json")
    public R deleteCase(@RequestBody TestCaseDTO testCaseDTO){

        Integer num = caseService.deleteCase(testCaseDTO);
        if (num>0)
           return R.ok().code(ResultCode.SUCCESS).data("删除数据条数"+num).message("删除数据成功");
        return R.error().code(ResultCode.ERROR).data("删除数据条数"+num).message("删除不成功");
    }

}
