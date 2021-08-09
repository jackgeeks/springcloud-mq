package com.jackgreek.listener;

import com.jackgreek.entity.Orders;
import com.jackgreek.feign.orderApi;
import com.jackgreek.service.IStorageService;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @Author: jackgeeks
 * @ProjectName: springcloud-mq
 * @Package: com.jackgreek.listener
 * @ClassName: StorageReleaseListener
 * @Description: @todo
 * @CreateDate: 2021/8/8 17:54
 * @Version: 1.0
 */

@Slf4j
@Service
public class StorageReleaseListener {
    @Autowired
    private orderApi orderApi;
    @Autowired
    private IStorageService storageService;




    @RabbitListener(queues = "order.release.storage.queue")
    public void handleStockLockedRelease(Orders to, Channel channel, Message message) throws IOException {
        log.info("******order.release.account.queue---》收到回滚库存的信息******");
        try {
            Orders orders = orderApi.GetByOrders(to.getId().longValue());
           if("0".equals(orders.getStatus())){
               storageService.rollbackStorage(orders.getProductId(),orders.getCount());
           }
            channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
