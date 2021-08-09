package com.jackgreek.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jackgreek.entity.Account;
import com.jackgreek.entity.Orders;
import com.jackgreek.feign.orderApi;
import com.jackgreek.mapper.AccountMapper;
import com.jackgreek.service.IAccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Mht
 * @since 2021-07-21
 */
@Service
@Slf4j
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements IAccountService {
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private orderApi orderApi;
    @Override
    public void decrease(Long userId) {
        log.info("------->扣减账户开始account中");
        orderApi.update(userId);
        Orders orders = orderApi.GetByOrders(userId);
        this.baseMapper.decrease(orders.getUserId(),orders.getPayAmount());
        log.info("------->扣减账户结束account中");

    }
}
