package com.zhenghao.admin.generator.service.impl;

import com.zhenghao.admin.generator.config.GeneratorConfig;
import com.zhenghao.admin.generator.core.GeneratorHandler;
import com.zhenghao.admin.generator.dao.ToolGeneratorMapper;
import com.zhenghao.admin.generator.entity.ColumnEntity;
import com.zhenghao.admin.generator.entity.TableEntity;
import com.zhenghao.admin.generator.service.ToolGeneratorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
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
    public byte[] generator(GeneratorConfig generatorConfig) {
        TableEntity tableEntity = toolGeneratorMapper.getTableByName(generatorConfig.getTableName());
        List<ColumnEntity> columns = toolGeneratorMapper.listColumn(generatorConfig.getTableName());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try (ZipOutputStream zip = new ZipOutputStream(out)) {
            GeneratorHandler.generatorCode(tableEntity, columns, generatorConfig, zip);
        } catch (IOException e) {
            logger.error("生成代码失败，表名：" + generatorConfig.getTableName(), e);
        }
        return out.toByteArray();
    }
}
