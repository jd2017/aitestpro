package org.example.aitestpro.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
//import io.swagger.annotations.ApiModel;

//@ApiModel(value = "测试用例实体类",description = "请求参数的测试用例实体类")
public class TestCaseDTO {

    private Integer id;
    private String caseTitle;
    private String remark;
    private String method;
    private String step;
    private String caseData;
    private String path;
    private Integer type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCaseTitle() {
        return caseTitle;
    }

    public void setCaseTitle(String caseTitle) {
        this.caseTitle = caseTitle;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getStep() {
        return step;
    }

    public void setStep(String step) {
        this.step = step;
    }

    public String getCaseData() {
        return caseData;
    }

    public void setCaseData(String caseData) {
        this.caseData = caseData;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "TestCaseDTO{" +
                "id=" + id +
                ", caseTitle='" + caseTitle + '\'' +
                ", remark='" + remark + '\'' +
                ", method='" + method + '\'' +
                ", step='" + step + '\'' +
                ", caseData='" + caseData + '\'' +
                ", path='" + path + '\'' +
                ", type=" + type +
                '}';
    }
}
