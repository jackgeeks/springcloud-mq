package com.jackgreek.feign;

import com.jackgreek.entity.Orders;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

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
     * 修改订单修改已付款状态
     * @param userId
     * @return
     */
    @PutMapping("/orders/update")
    String update(@RequestParam("userId") Long userId);

    /**
     * 获得订单
     * @param userId
     * @return
     */
    @GetMapping("/orders/queryorder")
    Orders GetByOrders(@RequestParam("userId") Long userId);
}
