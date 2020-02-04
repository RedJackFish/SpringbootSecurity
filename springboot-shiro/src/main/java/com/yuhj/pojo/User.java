package com.yuhj.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: springboot-security
 * @description: user
 * @author: Yuhongjie
 * @create: 2020-01-31 12:53
 * @Version: 1.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer id;
    private String name;
    private String password;
    private String perms;
}