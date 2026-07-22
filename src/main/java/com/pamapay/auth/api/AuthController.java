package com.pamapay.auth.api;
import com.pamapay.auth.application.dto.RegisterUserRequest;
import com.pamapay.auth.application.dto.RegisterUserResponse;
import com.pamapay.auth.application.usecase.LoginUseCase;
import com.pamapay.auth.application.usecase.RegisterUserUseCase;
import com.pamapay.auth.application.dto.LoginRequest;
import com.pamapay.auth.application.dto.LoginResponse;
import com.pamapay.auth.application.usecase.LoginUseCase;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
    private final LoginUseCase loginUseCase;
    private final RegisterUserUseCase registerUserUseCase;

    public AuthController(RegisterUserUseCase registerUserUseCase,LoginUseCase loginUseCase) {
        this.loginUseCase = loginUseCase;
        this.registerUserUseCase = registerUserUseCase;
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public RegisterUserResponse register(
            @Valid @RequestBody RegisterUserRequest request) {

        return registerUserUseCase.register(request);
    }
    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public LoginResponse login(@Valid @RequestBody LoginRequest request){
        return loginUseCase.login(request);
    }
}