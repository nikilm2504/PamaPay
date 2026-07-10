package com.pamapay.auth.infrastructure.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.pamapay.auth.infrastructure.entity.UserEntity;
import java.util.Optional;
import java.util.UUID;
public interface UserJpaRepository
        extends JpaRepository<UserEntity, UUID> {


    Optional<UserEntity> findByEmail(String email);


    boolean existsByEmail(String email);

}