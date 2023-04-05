package com.example.dipronto.diprontoDemo.service;

import com.example.dipronto.diprontoDemo.entity.Producto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoService {
    Producto addPro(Producto producto);
    List<Producto> findAllPro();
    void deletePro(Long id);
    Producto updatePro(Producto producto);
    Producto findByIdPro(Long id);

}
