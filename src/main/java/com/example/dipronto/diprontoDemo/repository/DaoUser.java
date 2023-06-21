package com.example.dipronto.diprontoDemo.repository;

import com.example.dipronto.diprontoDemo.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface DaoUser extends CrudRepository<User, Long> {

    User findByNombre(String nombre);

}
