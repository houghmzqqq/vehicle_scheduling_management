package com.example.vehicle_scheduling_management.mapper;

import com.example.vehicle_scheduling_management.pojo.UserInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserInfoMapper {

    /**
     * @Author: yjf
     * @Description: 通过id查找用户
     * @Param: id
     * @Return: UserInfo
     * @Date: 16:23 2018/4/18
     */
    UserInfo queryById(Integer id);

    UserInfo validateUser(@Param("username") String username,@Param("password") String password);

    /**
     * @Author: yjf
     * @Description: 查找所有用户
     * @Param: null
     * @Return: null
     * @Date: 16:23 2018/4/18
     */
    List<UserInfo> queryAll();

    /**
     * @Author: yjf
     * @Description: 新增用户
     * @Param: userInfo
     * @Return: null
     * @Date: 16:24 2018/4/18
     */
    void add(UserInfo userInfo);

    /**
     * @Author: yjf
     * @Description: 删除用户
     * @Param: id
     * @Return: null
     * @Date: 16:24 2018/4/18
     */
    void delete(int id);

    /**
     * @Author: yjf
     * @Description: 更新用户
     * @Param: userInfo
     * @Return: null
     * @Date: 16:24 2018/4/18
     */
    void update(UserInfo userInfo);

}
