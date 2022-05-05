package com.chen;

import lombok.*;

/**
 * @author @Chenxc
 * @date 2022年05月05日 23:22
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
