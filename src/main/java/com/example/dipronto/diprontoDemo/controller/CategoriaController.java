package com.example.dipronto.diprontoDemo.controller;

import com.example.dipronto.diprontoDemo.entity.Categoria;
import com.example.dipronto.diprontoDemo.service.CategoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class CategoriaController {

    private final CategoriaService categoriaService;


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/agregarCategoria")
    Categoria addCategoria(@RequestBody Categoria categoria) {
        return this.categoriaService.addCat(categoria);

    }


    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/buscarCategoria")
    Iterable<Categoria> findAllCat() {
        return this.categoriaService.findAllCat();
    }


    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/buscarPorId/{id}")
    public Optional<Categoria> findByIdCat(@PathVariable Long id) {
        return this.categoriaService.findByIdCat(id);
    }


    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/borrarCategoria/{id}")
    void deleteCat(@PathVariable("id") Long id) {
        categoriaService.deleteCat(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping("/actualizaCategoria")
    public Categoria updateCat(@RequestBody Categoria cat) {
        return this.categoriaService.updateCat(cat);
    }


}
