package com.techcret.security.repository;

import com.techcret.security.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findByEmailAddress(String emailAddress);

    Optional<User> findByPhoneNumberOrEmailAddress(String phoneNumber, String emailAddress);

    Optional<User> findByPhoneNumber(String phoneNumber);

    Boolean existsByEmailAddress(String emailAddress);

    Boolean existsByPhoneNumber(String phoneNumber);

    Optional<User> findByUniqueId(String uniqueId);

}
