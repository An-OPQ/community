package edu.hniu.community.service.impl;

import edu.hniu.community.dao.FileUploadDao;
import edu.hniu.community.service.FileUploadService;
import edu.hniu.community.vo.FileUploadVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FileUploadServiceImpl implements FileUploadService {

    @Autowired
    FileUploadDao fileUploadDao;

    @Override
    public boolean updateIcon(FileUploadVo fileUploadVo) {
        return fileUploadDao.updateIcon(fileUploadVo) > 0;
    }
}
