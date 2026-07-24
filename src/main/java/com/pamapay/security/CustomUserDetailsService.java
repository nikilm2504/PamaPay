package com.pamapay.security;
import com.pamapay.auth.domain.User;
import com.pamapay.auth.infrastructure.entity.UserEntity;
import com.pamapay.auth.infrastructure.mapper.UserMapper;
import com.pamapay.auth.infrastructure.repository.UserJpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserJpaRepository userJpaRepository;

    public CustomUserDetailsService(UserJpaRepository userJpaRepository) {
        this.userJpaRepository = userJpaRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        UserEntity userEntity = userJpaRepository
                .findByEmail(username.trim().toLowerCase())
                .orElseThrow(() ->
                        new UsernameNotFoundException(
                                "User not found with email: " + username
                        ));

        User user = UserMapper.toDomain(userEntity);

        return new CustomUserDetails(user);
    }
}