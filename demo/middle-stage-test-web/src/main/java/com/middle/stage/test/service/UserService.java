package com.middle.stage.test.service;

import com.middle.stage.test.commons.CallResult;
import com.middle.stage.test.data.UserDO;


public interface UserService {
    CallResult login(UserDO userDO);
}
