package com.cafe.manager.util;

import com.cafe.business.core.service.user.UserService;
import com.cafe.business.core.service.user.common.UserRole;
import com.cafe.business.core.service.user.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * Created by araksgyulumyan
 * Date - 7/23/18
 * Time - 2:50 PM
 */

@Component
@Configuration
public class ApplicationStartupRunner implements CommandLineRunner {

    @Autowired
    private UserService userService;

    @Override
    public void run(String... args) throws Exception {
        //Create manager
        createManager();
    }

    private void createManager() {
        if (!userService.checkIfManagerExists()) {
            userService.createUser("manager", "pwd", UserRole.MANAGER, new UserDto("manager", "manager"));
        }
    }
}
