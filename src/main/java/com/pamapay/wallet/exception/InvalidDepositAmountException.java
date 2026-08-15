package com.pamapay.wallet.exception;

import java.math.BigDecimal;

public class InvalidDepositAmountException extends RuntimeException {
     public InvalidDepositAmountException(BigDecimal amount){
         super("Deposit amount should be greater than Zero ");
     }
}
