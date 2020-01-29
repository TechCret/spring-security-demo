package com.techcret.security.repository;

import com.techcret.security.model.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RoleRepository extends CrudRepository<Role, Long> {

    Optional<Role> findByName(String name);

    Integer countByName(String name);

}
