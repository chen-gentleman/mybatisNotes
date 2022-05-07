package com.chen.mapper;

import com.chen.bean.OrderDetailModel;

import java.util.List;

/**
 * @Author @Chenxc
 * @Date 2022/5/7 14:33
 */
public interface OrderDetailMapper {
    List<OrderDetailModel> getListByOrderId1(Integer id);
}
