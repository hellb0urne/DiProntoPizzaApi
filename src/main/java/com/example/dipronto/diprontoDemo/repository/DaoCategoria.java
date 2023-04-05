package com.example.dipronto.diprontoDemo.repository;

import com.example.dipronto.diprontoDemo.entity.Categoria;
import org.springframework.data.repository.CrudRepository;

public interface DaoCategoria extends CrudRepository<Categoria, Long> {

    Categoria findByNombre(String nombre);
    
}
