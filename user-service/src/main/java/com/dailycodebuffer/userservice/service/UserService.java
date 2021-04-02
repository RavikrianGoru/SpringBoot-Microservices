package com.dailycodebuffer.userservice.service;

import com.dailycodebuffer.userservice.entity.User;
import com.dailycodebuffer.userservice.repository.UserRepository;
import com.dailycodebuffer.value.objects.Department;
import com.dailycodebuffer.value.objects.UserDepartmentResponseTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public User saveUser(User user) {
        log.info("Inside saveUser method of UserService");
        return userRepository.save(user);
    }

    public UserDepartmentResponseTemplate getUserWithDepartment(Long userId) {
        log.info("Inside saveUser getUserWithDepartment of UserService");
        UserDepartmentResponseTemplate userDepartmentResponseTemplate = new UserDepartmentResponseTemplate();
        User user = userRepository.findByUserId(userId);
        //Department department=restTemplate.getForObject("http://localhost:9001/departments/" + user.getDepartmentId(),Department.class);
        Department department=restTemplate.getForObject("http://eureka-client-department-service/departments/" + user.getDepartmentId(),Department.class);
        userDepartmentResponseTemplate.setUser(user);
        userDepartmentResponseTemplate.setDepartment(department);
        return userDepartmentResponseTemplate;
    }
}
