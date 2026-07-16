package com.pamapay.auth.application.service;
import com.pamapay.auth.domain.User;
import com.pamapay.auth.domain.UserRole;
import com.pamapay.auth.domain.UserStatus;
import com.pamapay.auth.infrastructure.entity.UserEntity;
import com.pamapay.common.exception.EmailAlreadyExistsException;
import java.time.Instant;
import java.util.UUID;
import com.pamapay.auth.application.dto.RegisterUserRequest;
import com.pamapay.auth.application.dto.RegisterUserResponse;
import com.pamapay.auth.application.usecase.RegisterUserUseCase;
import com.pamapay.auth.infrastructure.mapper.UserMapper;
import com.pamapay.auth.infrastructure.repository.UserJpaRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegisterUserService implements RegisterUserUseCase {

    private final UserJpaRepository userJpaRepository;
    private final PasswordEncoder passwordEncoder;
   // private final UserMapper userMapper;

    public RegisterUserService(
            UserJpaRepository userJpaRepository,
            PasswordEncoder passwordEncoder) {

        this.userJpaRepository = userJpaRepository;
        this.passwordEncoder = passwordEncoder;
        //this.userMapper = userMapper;
    }

    @Override
    public RegisterUserResponse register(RegisterUserRequest request) {

        if (userJpaRepository.existsByEmail(request.email())) {

            throw new EmailAlreadyExistsException(request.email());

        }
        String encodedPassword = passwordEncoder.encode(request.password());
        User user = User.builder()
                .id(UUID.randomUUID())
                .fullName(request.fullName().trim())
                .email(request.email().trim().toLowerCase())
                .passwordHash(encodedPassword)
                .role(UserRole.USER)
                .status(UserStatus.ACTIVE)
                .createdAt(Instant.now())
                .build();
        UserEntity userEntity = UserMapper.toEntity(user);
        userJpaRepository.save(userEntity);
        return new RegisterUserResponse(
                user.getId(),
                user.getFullName(),
                user.getEmail(),
                "User registered successfully"
        );
    }
}