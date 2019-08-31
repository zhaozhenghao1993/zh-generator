package com.zhenghao.admin.generator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 🙃
 * 🙃
 * 🙃
 *
 * @author:zhaozhenghao
 * @Email :736720794@qq.com
 * @date :2019/08/31 20:43
 * PageController.java
 */
@Controller
public class PageController {

    @GetMapping("/")
    public String index() {
        return "/index.html";
    }

    @GetMapping("/tool")
    public String tool() {
        return "/index.html";
    }

    @GetMapping("/tool/generator")
    public String toolGenerator() {
        return "/index.html";
    }
}
