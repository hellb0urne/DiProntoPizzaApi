package com.example.dipronto.diprontoDemo.service.impl;

import com.example.dipronto.diprontoDemo.entity.Categoria;
import com.example.dipronto.diprontoDemo.exception.CustomException;
import com.example.dipronto.diprontoDemo.repository.DaoCategoria;
import com.example.dipronto.diprontoDemo.service.CategoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoriaServiceImpl implements CategoriaService {

    private final DaoCategoria daoCategoria;

    @Override
    public Optional<Categoria> findByIdCat(Long id) {
        return Optional.ofNullable(daoCategoria.findById(id).orElseThrow(() -> new CustomException("El Id no existe", HttpStatus.BAD_REQUEST)));
    }

    @Override
    public Categoria addCat(Categoria categoria){
        Categoria cat = findByNombre(categoria.getNombre());
        if (cat == null) {
            this.daoCategoria.save(categoria);
            return categoria;
        } else {
            throw new CustomException("Categoria existe", HttpStatus.CONFLICT);
        }
    }
    @Override
    public Categoria findByNombre(String nombre) {
        return this.daoCategoria.findByNombre(nombre);
    }

    /*
    @Override
    public void deleteCat(Long id) {
        Optional<Categoria> categoria = findByIdCat(id);
        daoCategoria.delete(categoria.get());
    }

    @Override
    public Categoria updateCat(Categoria categoria) {
        Optional<Categoria> cat = findByIdCat(categoria.getId());
        Categoria updateCat = cat.get();
        updateCat.setNombre(categoria.getNombre());
        return updateCat;
    }

    @Override
    public List<Categoria> findAllCat() {
        return (List<Categoria>) this.daoCategoria.findAll();
    }


     */
}
