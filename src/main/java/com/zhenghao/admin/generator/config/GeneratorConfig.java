package com.zhenghao.admin.generator.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * 🙃
 * 🙃 代码生成器请求参数
 * 🙃
 *
 * @author:zhaozhenghao
 * @Email :736720794@qq.com
 * @date :2019/04/20 15:43
 * GeneratorParamEntity.java
 */
@Configuration
public class GeneratorConfig {

    /**
     * 表名
     */
    @Value("${generator.tableName}")
    private String tableName;

    /**
     * 系统模块，权限管理auth
     */
    @Value("${generator.module}")
    private String module;

    /**
     * 功能编码，用户管理user
     */
    @Value("${generator.functionCode}")
    private String functionCode;

    /**
     * 后台请求地址，用户管理sys/user
     */
    @Value("${generator.requestMapping}")
    private String requestMapping;

    /**
     * 页面路径，用户管理system/user
     */
    @Value("${generator.viewPath}")
    private String viewPath;

    /**
     * 生成类型，0：生成包结构，1：只生成源代码
     */
    @Value("${generator.type}")
    private String type;

    public GeneratorConfig() {
        super();
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getFunctionCode() {
        return functionCode;
    }

    public void setFunctionCode(String functionCode) {
        this.functionCode = functionCode;
    }

    public String getRequestMapping() {
        return requestMapping;
    }

    public void setRequestMapping(String requestMapping) {
        this.requestMapping = requestMapping;
    }

    public String getViewPath() {
        return viewPath;
    }

    public void setViewPath(String viewPath) {
        this.viewPath = viewPath;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
