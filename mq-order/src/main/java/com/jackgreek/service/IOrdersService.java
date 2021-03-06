package com.jackgreek.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.jackgreek.entity.Orders;

import java.math.BigDecimal;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Mht
 * @since 2021-07-20
 */
public interface IOrdersService extends IService<Orders> {
    /**
     * 创建订单
     * @param order
     * @return
     */
    void create(Orders order);
    /**
     * 修改订单状态
     * @param userId
     */
    void updatestart(Long userId);


    Orders GetByOrders(Long userId);
}


