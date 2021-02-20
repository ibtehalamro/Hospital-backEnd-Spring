package com.hospital.repository;

import com.hospital.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {

    User findByUsername (String username);
    User getById(Long id);

}
