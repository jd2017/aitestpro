package org.example.aitestpro.entity;

import java.time.LocalDateTime;
import java.util.Date;
import javax.persistence.*;

/**
 * 表名：test_case
 * 表注释：测试用例表
*/
@Table(name = "test_case")
public class TestCase extends BaseEntityNew {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 用例名称
     */
    @Column(name = "case_title")
    private String caseTitle;

    /**
     * 备注
     */
    private String remark;

    /**
     * 方法
     */
    private String method;

    /**
     * 步骤
     */
    private String step;

    /**
     * 测试用例路径
     */
    private String path;

    /**
     * 测试用例类型
     */
    private Integer type;

    /**
     * 测试用例内容
     */
    @Column(name = "case_data")
    private String caseData;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private LocalDateTime updateTime;

    /**
     * 获取主键
     *
     * @return id - 主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置主键
     *
     * @param id 主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取用例名称
     *
     * @return caseTitle - 用例名称
     */
    public String getCaseTitle() {
        return caseTitle;
    }

    /**
     * 设置用例名称
     *
     * @param caseTitle 用例名称
     */
    public void setCaseTitle(String caseTitle) {
        this.caseTitle = caseTitle;
    }

    /**
     * 获取备注
     *
     * @return remark - 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注
     *
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 获取方法
     *
     * @return method - 方法
     */
    public String getMethod() {
        return method;
    }

    /**
     * 设置方法
     *
     * @param method 方法
     */
    public void setMethod(String method) {
        this.method = method;
    }

    /**
     * 获取步骤
     *
     * @return step - 步骤
     */
    public String getStep() {
        return step;
    }

    /**
     * 设置步骤
     *
     * @param step 步骤
     */
    public void setStep(String step) {
        this.step = step;
    }

    /**
     * 获取测试用例路径
     *
     * @return path - 测试用例路径
     */
    public String getPath() {
        return path;
    }

    /**
     * 设置测试用例路径
     *
     * @param path 测试用例路径
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * 获取测试用例类型
     *
     * @return type - 测试用例类型
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置测试用例类型
     *
     * @param type 测试用例类型
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 获取测试用例内容
     *
     * @return caseData - 测试用例内容
     */
    public String getCaseData() {
        return caseData;
    }

    /**
     * 设置测试用例内容
     *
     * @param caseData 测试用例内容
     */
    public void setCaseData(String caseData) {
        this.caseData = caseData;
    }

    /**
     * 获取创建时间
     *
     * @return createTime - 创建时间
     */
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取更新时间
     *
     * @return updateTime - 更新时间
     */
    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }
}