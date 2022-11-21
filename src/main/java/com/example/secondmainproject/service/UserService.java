package com.example.secondmainproject.service;


import com.example.secondmainproject.Dao.Entity.user.RoleEntity;
import com.example.secondmainproject.Dao.Entity.user.UserEntity;
import com.example.secondmainproject.Dao.PropertyRepository.UserRepository;
import com.example.secondmainproject.Mapper.UserMapper;
import com.example.secondmainproject.Model.AdminRegistrationDto;
import com.example.secondmainproject.Model.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;


    @Transactional
    public void save( UserDto customerRegistrationDto) {
        UserEntity customer=new UserEntity(customerRegistrationDto.getFirst_name(),
                customerRegistrationDto.getLast_name(),
                customerRegistrationDto.getEmail(),
                new BCryptPasswordEncoder().encode(customerRegistrationDto.getPassword()),
                Arrays.asList(new RoleEntity("ROLE_USER")));
        userRepository.save(customer);

    }
    @Transactional
    public void save( AdminRegistrationDto adminRegistrationDto) {
        UserEntity admin=new UserEntity(adminRegistrationDto.getFirstName(),
                adminRegistrationDto.getLastName(),
                adminRegistrationDto.getEmail(),
                new BCryptPasswordEncoder().encode(adminRegistrationDto.getPassword()),
                Arrays.asList(new RoleEntity("ROLE_ADMIN")));

        userRepository.save(admin);
    }
    //    @Transactional
//    public Optional<Customer> findUserByEmail(String email){
//        return userRepository.findUserByEmail(email);
//    }

    public Boolean userExists(String email) {
        return userRepository.findUserByEmail(email).isPresent();
    }
    public UserDto findByEmail(){
        Object principal= SecurityContextHolder. getContext(). getAuthentication(). getPrincipal();
        String username;
        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal). getUsername();
        } else {
            username = principal.toString();
        }
        if(username=="anonymousUser"){
            return new UserDto("User","User","anonymousUser");
        }else

        return  UserMapper.INSTANCE.entityToDto(userRepository.findByEmail(username)) ;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity customer= userRepository.findByEmail(email);

        if(customer==null){
            throw new UsernameNotFoundException("Username or password does not found!");

        }
        return new UserDetailService(customer);


    }
    public List<UserDto> allCustomer(){
        return userRepository.findByRole("ROLE_USER")
                .stream()
                .map(customer -> UserMapper.INSTANCE.entityToDto(customer))
                .collect(Collectors.toList());
    }
    public List<UserDto> allAdmin(){
       return userRepository.findByRole("ROLE_ADMIN")
               .stream()
               .map(customer -> UserMapper.INSTANCE.entityToDto(customer))
               .collect(Collectors.toList());
    }


    public List<String> getAllRole(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        List<String> roles = new ArrayList<String>();
        for (GrantedAuthority a : authorities) {
            roles.add(a.getAuthority());
        }
        return roles;
    }





}
