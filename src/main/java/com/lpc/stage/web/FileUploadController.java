package com.lpc.stage.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.MultipartConfigElement;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by Stefan on 2018/5/2.
 */
@RestController
@RequestMapping("/df/file")
@Slf4j
public class FileUploadController {

    @Value("${resource.location}")
    private String resourceLocation;

    @Value("${resource.tmpLocation}")
    private String tmpLocation;

    @Bean
    MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setLocation(tmpLocation);
        return factory.createMultipartConfig();
    }


    @PostMapping(value = "/upload")
    public Map<String, String> imgUpdate(@RequestParam(value = "file") MultipartFile file) {
        if (file.isEmpty()) {
//            return new ResponseBean(Const.CODE_FAIL,null,"文件不能为空");
        }
        // 获取文件名
        String fileName = file.getOriginalFilename();

        log.info("上传的文件名为：" + fileName);
        // 获取文件的后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        log.info("上传的后缀名为：" + suffixName);
        // 文件上传后的路径
        String filePath = resourceLocation;
        // 解决中文问题，liunx下中文路径，图片显示问题
        fileName = UUID.randomUUID() + suffixName;
        File dest = new File(filePath + fileName);
        // 检测是否存在目录
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        Map<String, String> map = new HashMap<String, String>();
        try {
            file.transferTo(dest);
            map.put("fileName", fileName);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;

    }

}
