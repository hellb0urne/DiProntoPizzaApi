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
    public Categoria addCat(Categoria categoria) {
        return this.daoCategoria.save(categoria);
    }

    @Override
    public void deleteCat(Long id) {
        Optional<Categoria> categoria = findByIdCat(id);
        if (!categoria.isEmpty()) {
            daoCategoria.delete(categoria.get());
        }
    }

    @Override
    public Categoria updateCat(Categoria categoria) {
        Optional<Categoria> cat = findByIdCat(categoria.getId());
        Categoria updateCat = cat.get();
        if (updateCat.getId() > 0) {
            updateCat.setId(categoria.getId());
            updateCat.setNombre(categoria.getNombre());
            daoCategoria.save(updateCat);

        }
        return updateCat;
    }

    @Override
    public Optional<Categoria> findByIdCat(Long id) {
        return this.daoCategoria.findById(id);
    }

    @Override
    public List<Categoria> findAllCat() {
        return (List<Categoria>) this.daoCategoria.findAll();
    }

    @Override
    public Categoria findByNombre(String nombre) {
       Categoria cat = this.daoCategoria.findByNombre(nombre);
       if (cat.getId() != 0){
           return cat;
       }else{
          throw new NullPointerException();
       }

    }
}
