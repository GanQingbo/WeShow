package com.gqb.other.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author GanQingbo
 * @Classname OssService
 * @Description
 * @date 2021/3/5 16:45
 */
public interface OssService {
    String uploadFilePoster(MultipartFile file);
}
