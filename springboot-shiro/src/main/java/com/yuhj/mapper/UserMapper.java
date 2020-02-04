package com.yuhj.mapper;

import com.yuhj.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * @program: springboot-security
 * @description: mapper
 * @author: Yuhongjie
 * @create: 2020-01-31 12:54
 * @Version: 1.0
 */
@Component
@Mapper
public interface UserMapper {
    public User queryUserByName(String name);
}