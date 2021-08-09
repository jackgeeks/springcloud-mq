package com.jackgreek.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jackgreek.entity.Orders;
import com.jackgreek.feign.StorageApi;
import com.jackgreek.mapper.OrdersMapper;
import com.jackgreek.service.IOrdersService;
import com.jackgreek.utils.Orderstatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Mht
 * @since 2021-07-20
 */
@Service
@Slf4j
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders> implements IOrdersService {




    @Autowired
    private StorageApi storageApi;
    @Autowired
    private RabbitTemplate rabbitTemplate;
    /**
     * 创建订单
     * @param order
     * @return
     * 测试结果：
     * 1.添加本地事务：仅仅扣减库存
     * 2.不添加本地事务：创建订单，扣减库存
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void create(Orders order) {
        log.info("------->交易开始");
        //本地方法
        order.setStatus(Orderstatus.NOPAYMENT);
        super.save(order);

//        //远程方法 扣减库存
        storageApi.decrease(order.getProductId(),order.getCount());
        log.info("订单号："+order.getId());


        log.info("------->发送mq");
        rabbitTemplate.convertAndSend("order-event-exchange", "order.create.order", order);


    }

    @Override
    public void updatestart(Long userId) {

        Orders orders = super.getById(userId);
        orders.setStatus(Orderstatus.PAYMENT);
        super.updateById(orders);
        log.info("订单已经完成支付");

    }

    @Override
    public Orders GetByOrders(Long userId) {
        return super.getById(userId);
    }


}
