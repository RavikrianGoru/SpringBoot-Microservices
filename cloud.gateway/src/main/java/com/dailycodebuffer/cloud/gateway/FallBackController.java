package com.dailycodebuffer.cloud.gateway;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackController {

    @RequestMapping("/userServiceFallBack")
    public String userServiceFallBackMethod()
    {
        return "User service is taking longer time than expected."+
                "Please try again later";
    }

    @RequestMapping("/departmentServiceFallBack")
    public String departmentServiceFallBackMethod()
    {
        return "Department service is taking longer time than expected."+
                "Please try again later";
    }

}
