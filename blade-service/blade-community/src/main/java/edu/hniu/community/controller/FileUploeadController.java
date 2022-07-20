package edu.hniu.community.controller;

import edu.hniu.community.service.FileUploadService;
import edu.hniu.community.vo.FileUploadVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author jerry
 */
@RestController
@RequestMapping("/file")
public class FileUploeadController {

    @Autowired
    FileUploadService fileUploadService;

    @Value("${preread.uploadPath}")
    String fileUploadPath;

    @PutMapping("/upload")
    public Map<String, Object> fileUpload(MultipartFile multipartFile) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        //获取工程目录，此时获取不到。因为没有该目录
        String filePath =fileUploadPath.substring(fileUploadPath.indexOf(":")+1);
        File file = new File(filePath);
        //目录不存在，则创建目录
        if (!file.exists()) {
            file.mkdirs();
        }
        //获取原文件名
        String fileName = multipartFile.getOriginalFilename();
        //截取文件后缀名
        String fileSuffix = fileName.substring(fileName.lastIndexOf("."));
        //创建新的文件，使用随机数创建文件名
        file = new File(filePath, UUID.randomUUID() + fileSuffix);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            multipartFile.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        result.put("filename", file.getName());
        return result;
    }

    @PutMapping("/updateIcon")
    public Object updateIcon(@RequestBody FileUploadVo fileUploadVo) {
        return fileUploadService.updateIcon(fileUploadVo);
    }
}