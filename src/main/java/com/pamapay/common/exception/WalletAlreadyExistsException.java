package com.pamapay.common.exception;

import java.util.UUID;

public class WalletAlreadyExistsException extends RuntimeException{
    public WalletAlreadyExistsException(UUID userId){
        super("Wallet already exists for user ");
    }
}
