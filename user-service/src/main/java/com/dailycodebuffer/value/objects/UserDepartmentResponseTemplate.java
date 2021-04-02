package com.dailycodebuffer.value.objects;

import com.dailycodebuffer.userservice.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDepartmentResponseTemplate {

    private User user;
    private Department department;

}
