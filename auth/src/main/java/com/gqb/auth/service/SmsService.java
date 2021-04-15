package com.gqb.auth.service;

import com.gqb.auth.entity.vo.UserRegisterVo;

/**
 * @author GanQingbo
 * @Classname SmsService
 * @Description
 * @date 2021/4/13 20:51
 */
public interface SmsService {
    boolean checkCode(UserRegisterVo vo);
}
