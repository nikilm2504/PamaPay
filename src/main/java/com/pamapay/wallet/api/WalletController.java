package com.pamapay.wallet.api;

import com.pamapay.security.CustomUserDetails;
import com.pamapay.wallet.application.dto.CreateWalletResponse;
import com.pamapay.wallet.application.dto.WalletResponse;
import com.pamapay.wallet.application.usecase.CreateWalletUseCase;
import com.pamapay.wallet.application.usecase.GetWalletUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/wallet")
public class WalletController {
   private final CreateWalletUseCase createWalletUseCase;
   private final GetWalletUseCase getWalletUseCase;
   public WalletController(CreateWalletUseCase createWalletUseCase,GetWalletUseCase getWalletUseCase){
       this.createWalletUseCase=createWalletUseCase;
       this.getWalletUseCase=getWalletUseCase;
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
   @GetMapping
    public ResponseEntity<WalletResponse> getWallet(@AuthenticationPrincipal CustomUserDetails userDetails){
       WalletResponse response=getWalletUseCase.getWallet(userDetails.getId());
       return ResponseEntity.ok(response);
   }
}
