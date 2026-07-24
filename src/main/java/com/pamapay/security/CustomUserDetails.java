package com.pamapay.security;
import com.pamapay.auth.domain.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
public class CustomUserDetails implements UserDetails{
     private final UUID id;
     private final String email;
     private final String passwordHash;
     private final String role;
     private final boolean enabled;
     public CustomUserDetails(User user){
         this.id=user.getId();
         this.email = user.getEmail();
         this.passwordHash = user.getPasswordHash();
         this.role=user.getRole().name();
         this.enabled=user.getStatus().name().equals("ACTIVE");
     }
    public UUID getId() {
        return id;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        return List.of(
                new SimpleGrantedAuthority("ROLE_" + role)
        );
    }

    @Override
    public String getPassword() {
        return passwordHash;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }


}
