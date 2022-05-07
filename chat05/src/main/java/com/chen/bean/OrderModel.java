package com.chen.bean;

import lombok.*;

import java.util.List;

/**
 * @Author @Chenxc
 * @Date 2022/5/7 14:26
 */
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class OrderModel {
    private Integer id;
    private Integer userId;
    private Long createTime;
    private Long upTime;
    private UserModel userModel;
    //订单详情列表
    private List<OrderDetailModel> orderDetailModelList;
}
