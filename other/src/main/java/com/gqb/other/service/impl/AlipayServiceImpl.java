package com.gqb.other.service.impl;

import com.alipay.easysdk.factory.Factory;
import com.alipay.easysdk.kernel.util.ResponseChecker;
import com.alipay.easysdk.payment.common.models.AlipayTradeRefundResponse;
import com.alipay.easysdk.payment.facetoface.models.AlipayTradePrecreateResponse;
import com.alipay.easysdk.payment.wap.models.AlipayTradeWapPayResponse;
import com.gqb.other.config.AlipayConfig;
import com.gqb.other.entity.Order;
import com.gqb.other.service.AlipayService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author GanQingbo
 * @Classname pay
 * @Description
 * @date 2021/4/16 0:35
 */
@Service
public class AlipayServiceImpl implements AlipayService {

    @Override
    public String alipay(Order order) {
        Factory.setOptions(AlipayConfig.getOptions());
        try{
            System.out.println("amout:"+order.getOrderAmount());
            AlipayTradeWapPayResponse response= Factory.Payment.Wap().pay(order.getOrderSn(),
                    order.getId().toString(),
                    order.getOrderAmount().toString(),
                    "",
                    AlipayConfig.return_url);
            if (ResponseChecker.success(response)) {
                System.out.println("调用支付成功");
                return response.body;
            } else {
                System.err.println("调用支付失败");
            }
        }catch (Exception e){
            System.err.println("调用遭遇异常，原因：" + e.getMessage());
            throw new RuntimeException(e.getMessage(), e);
        }
        return null;
    }

    //支付宝退款
    @Override
    public String alipayRefund(Order order) {
        try {
            AlipayTradeRefundResponse response = Factory.Payment.Common()
                    .refund(order.getOrderSn(), order.getOrderAmount().toString());
            if (ResponseChecker.success(response)) {
                System.out.println("调用退款成功");
                //TODO
                return response.httpBody;
            } else {
                System.out.println("调用退款失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
