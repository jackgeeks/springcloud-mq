package com.jackgreek.utils;

/**
 * @Author: jackgeeks
 * @ProjectName: springcloud-mq
 * @Package: com.jackgreek.utils
 * @ClassName: Orderstatus
 * @Description: @todo
 * @CreateDate: 2021/8/8 17:21
 * @Version: 1.0
 */
public interface Orderstatus {
    //待付款
    String NOPAYMENT = "0";
    //已付款
    String PAYMENT = "1";
}


