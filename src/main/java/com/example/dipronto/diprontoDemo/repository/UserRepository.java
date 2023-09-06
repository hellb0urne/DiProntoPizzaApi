package com.example.dipronto.diprontoDemo.repository;

import com.example.dipronto.diprontoDemo.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findByNombre(String nombre);
}
