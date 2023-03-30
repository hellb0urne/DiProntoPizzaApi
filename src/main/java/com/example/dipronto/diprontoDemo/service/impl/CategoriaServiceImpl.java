package com.example.dipronto.diprontoDemo.service.impl;

import com.example.dipronto.diprontoDemo.entity.Categoria;
import com.example.dipronto.diprontoDemo.repository.DaoCategoria;
import com.example.dipronto.diprontoDemo.service.CategoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoriaServiceImpl implements CategoriaService {

    private final DaoCategoria daoCategoria;


    @Override
    public Categoria addCategoria(Categoria categoria) {
        return this.daoCategoria.save(categoria);
    }

    @Override
    public void deleteCategoria(Long id) {
        Optional<Categoria> categoria = findById(id);
        if (!categoria.isEmpty()){
            daoCategoria.delete(categoria.get());
        }
    }

    @Override
    public Optional<Categoria> findById(Long id) {
        return this.daoCategoria.findById(id);
    }

    @Override
    public List<Categoria> findAll() {
        return (List<Categoria>) this.daoCategoria.findAll();
    }
}
