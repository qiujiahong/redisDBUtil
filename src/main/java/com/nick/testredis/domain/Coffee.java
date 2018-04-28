package com.nick.testredis.domain;/*
 * @Author      : Nick
 * @Description :
 * @Date        : Create in 22:28 2018/4/27
 **/

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Coffee {
    private String id;
    private String name;
}
