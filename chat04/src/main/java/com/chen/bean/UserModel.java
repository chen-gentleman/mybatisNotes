package com.chen.bean;

import lombok.*;

/**
 * @author @Chenxc
 * @date 2022年05月06日 22:54
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class UserModel {
    private Long id;
    private String name;
    private Integer age;
    private Double salary;
    private Integer sex;
}
