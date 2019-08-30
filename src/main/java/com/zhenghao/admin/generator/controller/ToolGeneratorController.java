package com.zhenghao.admin.generator.controller;

import com.zhenghao.admin.generator.config.GeneratorConfig;
import com.zhenghao.admin.generator.service.ToolGeneratorService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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

    @Autowired
    private GeneratorConfig generatorConfig;

    /**
     * 生成代码
     *
     * @param response
     * @throws IOException
     */
    @GetMapping("/code")
    public void generator(HttpServletResponse response) throws IOException {
        byte[] code = toolGeneratorService.generator(generatorConfig);
        String attachment = "attachment; filename=" + generatorConfig.getTableName() + ".zip";
        response.reset();
        response.setHeader("Content-Disposition", attachment);
        response.addHeader("Content-Length", "" + code.length);
        response.setContentType("application/octet-stream; charset=UTF-8");
        IOUtils.write(code, response.getOutputStream());
    }
}
