package com.techcret.security.service;

import com.techcret.security.model.Role;
import com.techcret.security.model.User;
import com.techcret.security.repository.RoleRepository;
import com.techcret.security.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class BootstrapService implements InitializingBean {

    private final Logger LOG = LoggerFactory.getLogger(BootstrapService.class);

    @Autowired
    public RoleRepository roleRepository;

    @Autowired
    public UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    @Transactional()
    public void afterPropertiesSet() throws Exception {
        LOG.info("Bootstrapping data...");

        createRole();

        createUser();

        LOG.info("...Bootstrapping completed");
    }

    public void createRole() {
        List<String> roleList = Arrays.asList("ROLE_ADMIN", "ROLE_USER");
        for (String roleName : roleList) {
            if (roleRepository.countByName(roleName) == 0) {
                roleRepository.save(new Role(roleName));
            }
        }
    }

    public void createUser() {
        if (!userRepository.existsByEmailAddress("user@email.com")) {
            User user = new User();
            user.setEmailAddress("user@email.com");
            user.setPassword(passwordEncoder.encode("user1234"));
            user.setPhoneNumber("1234567890");
            Set<Role> roleSet = user.getRoleSet();
            if (roleSet == null)
                roleSet = new HashSet<>();
            roleSet.add(roleRepository.findByName("ROLE_USER").get());
            user.setRoleSet(roleSet);
            userRepository.save(user);
        }
        if (!userRepository.existsByEmailAddress("admin@email.com")) {
            User user = new User();
            user.setEmailAddress("admin@email.com");
            user.setPassword(passwordEncoder.encode("admin1234"));
            user.setPhoneNumber("1234567890");
            Set<Role> roleSet = user.getRoleSet();
            if (roleSet == null)
                roleSet = new HashSet<>();
            roleSet.add(roleRepository.findByName("ROLE_ADMIN").get());
            user.setRoleSet(roleSet);
            userRepository.save(user);
        }
    }

}
