package com.example.dipronto.diprontoDemo.service.impl;

import com.example.dipronto.diprontoDemo.entity.Categoria;
import com.example.dipronto.diprontoDemo.exception.CustomException;
import com.example.dipronto.diprontoDemo.repository.DaoCategoria;
import com.example.dipronto.diprontoDemo.service.CategoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoriaServiceImpl implements CategoriaService {

    private final DaoCategoria daoCategoria;


    @Transactional
    @Override
    public Categoria addCat(Categoria categoria) {
        final var cat = daoCategoria.findByNombre(categoria.getNombre());
        if (cat == null) {
            return daoCategoria.save(categoria);
        } else {
            throw new CustomException("La categoria Existe", HttpStatus.CONFLICT);
        }

    }

    @Transactional
    @Override
    public Iterable<Categoria> findAllCat() {
        var categoriaList = daoCategoria.findAll();
        if (categoriaList.iterator().hasNext()) {
            return categoriaList;
        } else {
            throw new CustomException("Lista esta vacia", HttpStatus.NO_CONTENT);
        }
    }

    @Transactional
    @Override
    public Optional<Categoria> findByIdCat(Long id) {
        return Optional.of(daoCategoria.findById(id).orElseThrow(() -> new CustomException("El Id no existe", HttpStatus.BAD_REQUEST)));

    }

    @Transactional(readOnly = true)
    @Override
    public void deleteCat(Long id) {
        var optionalCategoria = findByIdCat(id);
        Categoria cat = optionalCategoria.get();
        daoCategoria.delete(cat);
    }

    @Transactional
    @Override
    public Categoria updateCat(Categoria categoria) {
        var cat = findByIdCat(categoria.getId());
        Categoria categoriaFinal = cat.get();
        categoriaFinal.setNombre(categoria.getNombre());
        return daoCategoria.save(categoriaFinal);
    }
}
