package edu.hniu.community.dao;

import edu.hniu.community.vo.FileUploadVo;
import org.springframework.stereotype.Component;

//@Component
public interface FileUploadDao {

    int updateIcon(FileUploadVo fileUploadVo);
}
