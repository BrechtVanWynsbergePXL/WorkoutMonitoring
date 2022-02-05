package com.wm.workoutmonitoring.repositories;

import com.wm.workoutmonitoring.models.Account;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AccountRepository extends CrudRepository<Account, String> {
    List<Account> findAll();

    @Override
    void deleteById(String id);
}
