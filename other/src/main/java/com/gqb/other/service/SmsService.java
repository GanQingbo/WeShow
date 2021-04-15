package com.gqb.other.service;

import java.util.Map;

/**
 * @author GanQingbo
 * @Classname SmsService
 * @Description
 * @date 2021/4/13 16:29
 */
public interface SmsService {
    boolean sendSms(String phoneNumber, Map<String,Object> code);
}
