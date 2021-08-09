package com.jackgreek.controller;


import com.jackgreek.entity.Orders;
import com.jackgreek.service.IOrdersService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.math.BigDecimal;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Mht
 * @since 2021-07-20
 */

@RestController
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    public IOrdersService iOrdersService;
    /**
     * 创建订单
     * @param order
     * @return
     */
    @PostMapping("create")
    public String create(@RequestBody Orders order){
        iOrdersService.create(order);
        return "Create order success";
    }

    /**
     * 修改订单修改已付款状态
     * @param userId
     * @return
     */
    @PutMapping("update")
    public  String update(@RequestParam("userId") Long userId){
        iOrdersService.updatestart(userId);
        return "订单状态修改为已付款状态";
    }
    /**
     * 获得订单
     * @param userId
     * @return
     */
    @GetMapping("queryorder")
    public Orders GetByOrders(@RequestParam("userId") Long userId){
        return  iOrdersService.GetByOrders(userId);
    }
}
