package com.pamapay.wallet.api;

import com.pamapay.security.CustomUserDetails;
import com.pamapay.wallet.application.dto.CreateWalletResponse;
import com.pamapay.wallet.application.dto.DepositWalletRequest;
import com.pamapay.wallet.application.dto.WalletResponse;
import com.pamapay.wallet.application.usecase.CreateWalletUseCase;
import com.pamapay.wallet.application.usecase.DepositWalletUseCase;
import com.pamapay.wallet.application.usecase.GetWalletUseCase;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/wallet")
public class WalletController {
   private final CreateWalletUseCase createWalletUseCase;
   private final GetWalletUseCase getWalletUseCase;
   private final DepositWalletUseCase depositWalletUseCase;
   public WalletController(CreateWalletUseCase createWalletUseCase, GetWalletUseCase getWalletUseCase, DepositWalletUseCase depositWalletUseCase){
       this.createWalletUseCase=createWalletUseCase;
       this.getWalletUseCase=getWalletUseCase;
       this.depositWalletUseCase=depositWalletUseCase;
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
   @PostMapping("/deposits")
    public ResponseEntity<WalletResponse> deposit(
           @AuthenticationPrincipal CustomUserDetails userDetails,
            @Valid @RequestBody DepositWalletRequest request
           ) {
            WalletResponse response = depositWalletUseCase.deposit(userDetails.getId(),request.amount()) ;
            return ResponseEntity.ok(response);
   }
}
