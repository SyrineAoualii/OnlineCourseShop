package com.Aouali.OnlineCourseShopmicroservice3.payload.request;


import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;
 @Data
public class SignupRequest {

    private String username;
    private String email;
    private Set<String> role;
    private String password;
    private LocalDateTime createTime;

 }
