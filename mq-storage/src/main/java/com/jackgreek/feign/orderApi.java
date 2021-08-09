package com.jackgreek.feign;

import com.jackgreek.entity.Orders;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author: jackgeeks
 * @ProjectName: springcloud-mq
 * @Package: com.jackgreek.feign
 * @ClassName: orderApi
 * @Description: @todo
 * @CreateDate: 2021/8/8 18:37
 * @Version: 1.0
 */
@FeignClient(value = "tcc-order")
public interface orderApi {
    /**
     * 获得订单
     * @param userId
     * @return
     */
    @GetMapping("/orders/queryorder")
    Orders GetByOrders(@RequestParam("userId") Long userId);
}
