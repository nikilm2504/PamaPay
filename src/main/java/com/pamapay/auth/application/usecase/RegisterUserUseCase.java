package com.pamapay.auth.application.usecase;

import com.pamapay.auth.application.dto.RegisterUserRequest;
import com.pamapay.auth.application.dto.RegisterUserResponse;

public interface RegisterUserUseCase {

    RegisterUserResponse register(RegisterUserRequest request);//this is a method

}