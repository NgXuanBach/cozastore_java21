package com.cybersoft.cozastore_java21.service.imp;

import com.cybersoft.cozastore_java21.payload.request.SignupRequest;

public interface UserServiceImp {
    boolean addUser(SignupRequest request);
}
