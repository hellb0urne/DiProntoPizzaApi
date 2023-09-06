package com.example.dipronto.diprontoDemo.repository;

import com.example.dipronto.diprontoDemo.entity.Producto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DaoProducto extends CrudRepository<Producto, Long> {

}
