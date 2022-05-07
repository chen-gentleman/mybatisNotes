package com.chen.mapper;

import com.chen.bean.OrderModel;

/**
 * @Author @Chenxc
 * @Date 2022/5/7 14:28
 */
public interface OrderMapper {
    OrderModel getById1(Integer id);
    OrderModel getById2(Integer id);
}
