package com.pamapay.auth.exception;

import java.util.UUID;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(UUID userId){
        super("user not found.");
    }
}
