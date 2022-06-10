package com.middle.stage.test.service.annotation;

import com.middle.stage.test.commons.CallResult;
import com.middle.stage.test.service.impl.UserServiceImpl;
import com.middle.stage.test.data.UserDO;
import com.middle.stage.test.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@Slf4j
@SpringBootTest
class MiddleStageTestServiceByAnnotationApplicationTests {

    @Mock
    //通过注解模拟依赖的接口或类
    private UserMapper mockUserMapper;

    @InjectMocks
    //通过注解自动注入依赖关系
    private UserServiceImpl userService;

    //登录参数
    static UserDO userDO;

    //模拟查询结果
    static UserDO mockUserResult;

    static String mobile = "18740497432";

    static String password = "123456";


    @BeforeAll
    static void beforLoginTest() {
        userDO = new UserDO();
        userDO.setMobile(mobile);
        userDO.setPassword(password);

        mockUserResult = new UserDO();
        mockUserResult.setMobile(mobile);
        mockUserResult.setPassword("123456");
    }

    @Test
    @DisplayName("登录测试")
    void login() {

        //验证测试用例是否创建
        Assertions.assertNotNull(userDO, "userDO is null");

        when(mockUserMapper.selectByMobile(mobile)).thenReturn(mockUserResult);

        CallResult loginCallResult = userService.login(userDO);

        //验证是否执行
        verify(mockUserMapper).selectByMobile(mobile);

        //验证是否与我们预期的状态值相符
        Assertions.assertEquals(CallResult.RETURN_STATUS_OK, loginCallResult.getCode());
        Assertions.assertNotNull(loginCallResult.getContent());
        log.info("[测试通过]");
    }
}
