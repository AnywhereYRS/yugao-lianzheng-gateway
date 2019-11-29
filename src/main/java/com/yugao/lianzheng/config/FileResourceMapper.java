package com.yugao.lianzheng.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 文件资源映射
 * qxl
 */
@Configuration
public class FileResourceMapper implements WebMvcConfigurer {

    @Value("${uploadFile.staticAccessPath}")
    private String staticAccessPath;
    @Value("${uploadFile.path}")
    private String uploadFilePath;

    /**
     * uploadFolder+File.pathSeparator+"**"
     * 设置文件文件映射路径，将本地文件存在D:/uploadFiles/目录下，使用http://localhost:xxxx/file/a.jpg
     * 来获取a.jgp图片
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(staticAccessPath).addResourceLocations("file:"+uploadFilePath);
    }
}
