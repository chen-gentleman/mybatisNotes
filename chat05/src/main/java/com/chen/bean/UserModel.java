package com.chen.bean;

import lombok.*;

/**
 * @Author @Chenxc
 * @Date 2022/5/7 14:27
 */
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class UserModel {
    private Integer id;
    private String name;
}
