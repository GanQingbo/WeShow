package com.gqb.other.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.gqb.other.service.SmsService;
import com.gqb.other.utils.OssProperties;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author GanQingbo
 * @Classname SmsServiceImpl
 * @Description
 * @date 2021/4/13 16:34
 */
@Service
public class SmsServiceImpl implements SmsService {
    @Override
    public boolean sendSms(String phoneNumber, Map<String,Object> code) {
        String keyId = "LTAI4GF8SrHS8BhM8H5eASUW";
        String keySecret = "WMYx7Hc7iy8XlBpHyAVcUJ0CchPljc";
        DefaultProfile profile=DefaultProfile.getProfile("cn-hangzhou",keyId,keySecret);
        IAcsClient client = new DefaultAcsClient(profile);
        //构建请求
        CommonRequest request=new CommonRequest();
        //使用post提交
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        //自定义参数，手机号，模板
        request.putQueryParameter("PhoneNumbers",phoneNumber);
        request.putQueryParameter("SignName", "ABC商城");
        request.putQueryParameter("TemplateCode","SMS_203181891");
        //短信验证码
        request.putQueryParameter("TemplateParam", JSONObject.toJSONString(code));

        try{
            CommonResponse response=client.getCommonResponse(request);
            System.out.println(response.getData());
            //是否成功
            return response.getHttpResponse().isSuccess();
        }catch (ServerException e){
            e.printStackTrace();
        }catch (ClientException e){
            e.printStackTrace();
        }
        return false;
    }
}
