package com.pamapay.wallet.api;

import com.pamapay.security.CustomUserDetails;
import com.pamapay.wallet.application.dto.CreateWalletResponse;
import com.pamapay.wallet.application.usecase.CreateWalletUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/wallet")
public class WalletController {
   private final CreateWalletUseCase createWalletUseCase;
   public WalletController(CreateWalletUseCase createWalletUseCase){
       this.createWalletUseCase=createWalletUseCase;
   }
   @PostMapping
    public ResponseEntity<CreateWalletResponse> createWallet(
           @AuthenticationPrincipal CustomUserDetails userDetails
   ){
       CreateWalletResponse response=createWalletUseCase.createwallet(userDetails.getId());
       return ResponseEntity
               .status(HttpStatus.CREATED)
               .body(response);

   }
}
