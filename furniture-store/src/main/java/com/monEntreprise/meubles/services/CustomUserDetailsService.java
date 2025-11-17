package com.monEntreprise.meubles.services;

import com.monEntreprise.meubles.entities.CustomUserDetails;
import com.monEntreprise.meubles.entities.User;
import com.monEntreprise.meubles.repositories.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user= userRepository.findByEmail(email);

        if(user == null){
            throw new UsernameNotFoundException("User not found with email:" + email);
        }

        Collection<GrantedAuthority> authorities = new ArrayList<>();
        if (user.getRole() != null){
            authorities.add(new SimpleGrantedAuthority("ROLE_" + user.getRole().getName()));
        }

        return new CustomUserDetails(
                user.getEmail(),
                user.getPassword(),
                authorities
        );
    }
}
