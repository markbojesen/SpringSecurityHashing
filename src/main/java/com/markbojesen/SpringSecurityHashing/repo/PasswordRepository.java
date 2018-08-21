package com.markbojesen.SpringSecurityHashing.repo;

import com.markbojesen.SpringSecurityHashing.model.Password;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PasswordRepository extends CrudRepository<Password, Long> {
}
