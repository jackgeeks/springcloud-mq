package com.jackgreek.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jackgreek.entity.Orders;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Mht
 * @since 2021-07-20
 */
public interface OrdersMapper extends BaseMapper<Orders> {
    /**
     * 创建订单
     * @param order
     * @return
     */
    void create(Orders order);

}


