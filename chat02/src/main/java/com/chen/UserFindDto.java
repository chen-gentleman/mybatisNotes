package com.chen;

import lombok.*;

/**
 * @Author @Chenxc
 * @Date 2022/5/6 15:05
 */
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class UserFindDto {
    private Long userId;
    private String userName;
}
