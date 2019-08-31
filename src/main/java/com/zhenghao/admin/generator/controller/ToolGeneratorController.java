package com.zhenghao.admin.generator.controller;

import com.zhenghao.admin.generator.entity.GeneratorParamEntity;
import com.zhenghao.admin.generator.entity.Page;
import com.zhenghao.admin.generator.entity.Result;
import com.zhenghao.admin.generator.entity.TableEntity;
import com.zhenghao.admin.generator.service.ToolGeneratorService;
import com.zhenghao.admin.generator.util.ResponseUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.Map;

/**
 * 🙃
 * 🙃 代码生成器
 * 🙃
 *
 * @author:zhaozhenghao
 * @Email :736720794@qq.com
 * @date :2019/04/17 22:07
 * ToolGeneratorController.java
 */
@Controller
@RequestMapping("/api/tool/generator")
public class ToolGeneratorController {

    @Autowired
    private ToolGeneratorService toolGeneratorService;

    /**
     * 数据库列表
     *
     * @param params
     * @return
     */
    @GetMapping("")
    @ResponseBody
    public Page<TableEntity> listTable(@RequestParam Map<String, Object> params) {
        return toolGeneratorService.listTable(params);
    }

    /**
     * 生成代码
     *
     * @param params
     * @param response
     * @throws IOException
     */
    @GetMapping("/code")
    public void generator(@Valid GeneratorParamEntity params, BindingResult results, HttpServletResponse response) throws IOException {
        if (results.hasErrors()) {
            ResponseUtils.setResultResponse(response, Result.ofFail(results.getFieldError().getDefaultMessage()));
            return;
        }
        byte[] code = toolGeneratorService.generator(params);
        String attachment = "attachment; filename=" + params.getTableName() + ".zip";
        response.reset();
        response.setHeader("Content-Disposition", attachment);
        response.addHeader("Content-Length", "" + code.length);
        response.setContentType("application/octet-stream; charset=UTF-8");
        IOUtils.write(code, response.getOutputStream());
    }
}
