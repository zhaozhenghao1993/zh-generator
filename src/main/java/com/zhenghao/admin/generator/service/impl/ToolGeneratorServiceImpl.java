package com.zhenghao.admin.generator.service.impl;

import com.github.pagehelper.PageHelper;
import com.zhenghao.admin.generator.core.GeneratorHandler;
import com.zhenghao.admin.generator.dao.ToolGeneratorMapper;
import com.zhenghao.admin.generator.entity.*;
import com.zhenghao.admin.generator.service.ToolGeneratorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipOutputStream;

/**
 * 🙃
 * 🙃
 * 🙃
 *
 * @author:zhaozhenghao
 * @Email :736720794@qq.com
 * @date :2019/04/17 22:08
 * ToolGeneratorServiceImpl.java
 */
@Service
public class ToolGeneratorServiceImpl implements ToolGeneratorService {

    private static final Logger logger = LoggerFactory.getLogger(ToolGeneratorServiceImpl.class);

    @Autowired
    private ToolGeneratorMapper toolGeneratorMapper;

    @Override
    public Page<TableEntity> listTable(Map<String, Object> params) {
        Query query = new Query(params);
        Page<TableEntity> page = new Page<>(query);
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        page.setData(toolGeneratorMapper.listTable(query));
        return page;
    }

    @Override
    public byte[] generator(GeneratorParamEntity params) {
        TableEntity tableEntity = toolGeneratorMapper.getTableByName(params.getTableName());
        List<ColumnEntity> columns = toolGeneratorMapper.listColumn(params.getTableName());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try (ZipOutputStream zip = new ZipOutputStream(out)) {
            GeneratorHandler.generatorCode(tableEntity, columns, params, zip);
        } catch (IOException e) {
            // throw new BaseException("生成代码失败，表名：" + params.getTableName(), e);
            logger.error("生成代码失败，表名：" + params.getTableName(), e);
        }
        return out.toByteArray();
    }
}
