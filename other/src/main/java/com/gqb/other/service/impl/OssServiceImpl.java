package com.gqb.other.service.impl;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;

import com.gqb.other.service.OssService;
import com.gqb.other.utils.OssProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.UUID;

/**
 * @author GanQingbo
 * @Classname OssServiceImpl
 * @Description
 * @date 2021/3/5 16:45
 */
@Service
public class OssServiceImpl implements OssService {
    /**
     * @param file 文件流
     * @return
     * @Description 上传海报
     */
    @Override
    public String uploadFilePoster(MultipartFile file) {
        String endpoint = OssProperties.END_POINT;
        String keyId = OssProperties.KEY_ID;
        String keySecret = OssProperties.KEY_SECRET;
        String bucketName = OssProperties.BUCKET_NAME;
        try {
            //创建oss实例
            OSS ossClient = new OSSClientBuilder().build(endpoint, keyId, keySecret);
            //获取上传文件输入流
            InputStream inputStream = file.getInputStream();
            //用UUID生成文件名，拼接路径
            String original= file.getOriginalFilename(); //原文件名
            String type=original.substring(original.lastIndexOf("."));  //文件后缀
            String filename = "poster/"+ UUID.randomUUID()+type; //拼接
            //bucket名，oss文件路径和名称，上传文件输入流
            ossClient.putObject(bucketName, filename, inputStream);
            //关闭oss
            ossClient.shutdown();
            //返回拼接的路径
            String url="https://"+bucketName+"."+endpoint+"/"+filename;
            return url;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
