package com.wm.workoutmonitoring.repositories;

import com.wm.workoutmonitoring.models.Account;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface AccountRepository extends CrudRepository<Account, String> {
    List<Account> findAll();

    Optional<Account> findByEmail(String email);

    @Override
    void deleteById(String id);
}
