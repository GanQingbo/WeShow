package com.gqb.other.config;

import com.alipay.easysdk.kernel.Config;
import org.springframework.stereotype.Component;

/**
 * @author GanQingbo
 * @Classname AlipayConfig
 * @Description
 * @date 2021/4/16 0:14
 */
@Component
public class AlipayConfig {
    // 商户appid
    public static String APPID = "2021000117638973";
    // 私钥 pkcs8格式的
    public static String RSA_PRIVATE_KEY = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCNgLv+2DV/G90e2yXT1dFwy2J4GxdTRMD2JLhC6uQb/BY84y4yu8EyzgdN+4sETPLH0acqOvjwqZHlwI2H7kATv4mkFS/qHHu545ASgNOztPMgQjLRCXP4rmCKos/LJQj+5oXXtRSrISVjgpt534dH7ZlpSmOSgBnoz4ngsXs6uK0aW29ufGr2fYRzwe6lWmfaMhceHULbRWEez+gYeAAXIRW2p+8qaRU4PZyrR8EaKrnJtIWdtXE+vlqnton0RPcE2T+g/J+iKL9ZDzrIZv9KBrIv2wmLwHBtd1I2vVtKlsnL06NPfhdtf1rHj6jH+Gps8x/DcYu0vAtghozPo8cbAgMBAAECggEAVDb1q+pJjGis5RxQGw76I0MoS4r0Ct60aMnZ0BmzwOP66Cnc6NzNUstDlanLRrf1Fe80qfGHDtQcvLwof2nQQPCRnlHtvktNZ4iDyj9Zv25F9EDxtW8G0k4VruzO9nwIKoxPw91Fe8OyWNL2bUYXYTuLPhrDwAD1apV53XxDduJgMvE5XOaCgnLfBrrBHy7mJLmKfvQkjYtK0oldUNxEtURxgG8HwguS90jSrtkEXawTvxT5X52QX5OQFvterHDW0PJ2x29EwJ4xxBzng0DKGf8ErpkvEWQNwtzbSnXR6gitSGDyTNzzAjEmuJ/aXo6L+VB1p6+YZe+WyVJ/oD944QKBgQD2EqBJrQRG3Sd0jHeF91v9u7FIIDtIQO3cneDSpw52EeiG7DSSPfvaF4NQE9zx0Gjf9/nKydaJ4G7q5G5YORrj0nKRrXXgMOAf3PDlwYtfv6s9WX9uBiJnBPQrkry+0NprOlBdXm6p8OJCoSjYXpY6PbuuuCHGVmHVdDv73a/n5wKBgQCTNiNmJGTmofpLsu3W2pKOOHGjl1GCCOW0j+xu3/TOCKBYx/qzG4EFBsOh8cjUVmHiW3OhuaZ1V00Mt5OOzUGhI5XpZ0q0T8p1TmSrFd9/9xfBuU8ZjJSQkcrPOGGQUi5DNIHqq/3dYsCwOeQn7PzHneY+31QTdpxkOoTX3VlwrQKBgEhLFJhQom8HTi4pjnvnPjl/SQg9n+0MVlV4dLKurcr2W/A3uQI1/6YFPmjqTQEmD4mtWs+/GK6NJ0kPL3Pv4vyHuW0fHwBsm4wA5y04/W916iMuBggW+Uh25h1fEOCmj2TtTur/cVewE2kr28olj9EwjdE4+4M/oaKKcYz/hkyFAoGAAtre7uEvz8U+bG9o62zLwNRZZ9nMa+AuTEUqSbAwODq0mWQveX/EDcvmyWI+CdgvB8vMP0uxbb8msGNzCiby6eQdySwGp96QR5wgmazP69Rn8orcfNtcGj2pmEE4qyrc2NLQ3jM9tihvIjvNL/UJpflq+LcuEz6Oo+b6opEZZfUCgYBpR2g71V+3nqadmriRqMUHVsMfefknHkBFKLX/lEiLIo6OEDKIjg9Fa7+zHS931R+FRNjmaAWcBTkimHnUsWi7RdDgDB6UmLhs5l8Q80zRShI+SGj4VX0gnlsicDoSarTwDjIW2hCOZFDcwZHoZ9skpEZqv8ZZqnvURwGEpCyRJA==\n";
    // 服务器异步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://localhost:8080/Person";
    // 页面跳转同步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问 商户可以自定义同步跳转地址
    public static String return_url = "http://localhost:8080/Person";
    // 请求网关地址
    public static String URL = "https://openapi.alipay.com/gateway.do";
    // 编码
    public static String CHARSET = "UTF-8";
    // 返回格式
    public static String FORMAT = "json";
    // 支付宝公钥
    public static String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAgBryr7tUWMJ0HwJLKKqOEFoOh/F6N3Bp+ZGK+z9GqL76cLq9jyhFdgHSj/UmtyBaE0cggilV53syvTH/A6xJD0fa04V1t0zGnkt8Oqhka7xTIMC8TXWoP7ooNNeTWMWzd1FOT7+5u4m9dJAVpzvPVv8sfHrb4+0zn6g5Agbrmmu+DApN1xfcEbF8yRU3A4/2diI7rFwYTh2iW0qWKdEGnMbUptRQpadMvpiNqanYww3oHTxuO9LSCQGtvq2TBkme4Qny9zXzQVBy2pf5GQLNJV7EA+hIWma66K9r0X1faLUP1gjDMALoMf4fIT+UjckJsyRxT8eRooTTyMhfTCP9uQIDAQAB";
    // 日志记录目录
    public static String log_path = "/log";
    // RSA2
    public static String SIGNTYPE = "RSA2";

    public static Config getOptions() {
        Config config = new Config();
        config.protocol = "https";
        config.gatewayHost = "openapi.alipaydev.com";
        config.signType = "RSA2";

        config.appId = APPID;

        // 为避免私钥随源码泄露，推荐从文件中读取私钥字符串而不是写入源码中
        config.merchantPrivateKey = RSA_PRIVATE_KEY;

        //注：证书文件路径支持设置为文件系统中的路径或CLASS_PATH中的路径，优先从文件系统中加载，加载失败后会继续尝试从CLASS_PATH中加载
        //config.merchantCertPath = "<-- 请填写您的应用公钥证书文件路径，例如：/foo/appCertPublicKey_2019051064521003.crt -->";
        //config.alipayCertPath = "<-- 请填写您的支付宝公钥证书文件路径，例如：/foo/alipayCertPublicKey_RSA2.crt -->";
        //config.alipayRootCertPath = "<-- 请填写您的支付宝根证书文件路径，例如：/foo/alipayRootCert.crt -->";

        //注：如果采用非证书模式，则无需赋值上面的三个证书路径，改为赋值如下的支付宝公钥字符串即可
         config.alipayPublicKey = ALIPAY_PUBLIC_KEY;

        //可设置异步通知接收服务地址（可选）
        config.notifyUrl = notify_url;

        //可设置AES密钥，调用AES加解密相关接口时需要（可选）
        config.encryptKey = "<-- 请填写您的AES密钥，例如：aa4BtZ4tspm2wnXLb1ThQA== -->";

        return config;
    }
}
