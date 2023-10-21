package com.cyan.springcloud.userservice.controller.inner;

import com.cyan.springcloud.client.service.UserFeignClient;
import com.cyan.springcloud.model.entity.User;
import com.cyan.springcloud.userservice.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

/**
 *  服务内部互相调用的接口
 *
 * @author Cyan Chau
 * @create 2023-10-21
 */
@RestController
@RequestMapping("/inner")
public class UerInnerController implements UserFeignClient {

    @Resource
    private UserService userService;

    /**
     * 根据 id 获取用户
     *
     * @param userId
     * @return
     */
    @Override
    @GetMapping("/get/id")
    public User getById(@RequestParam("userId") long userId) {

        return userService.getById(userId);
    }

    /**
     * 根据 id 获取用户列表
     *
     * @param idList
     * @return
     */
    @Override
    @GetMapping("/get/ids")
    public List<User> listByIds(@RequestParam("idList") Collection<Long> idList) {

        return userService.listByIds(idList);
    }

}
