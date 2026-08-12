package com.pamapay.auth.exception;

public class WalletNotFoundException extends RuntimeException{
     public WalletNotFoundException(){
         super("Wallet not Found for this user.");
     }
}
