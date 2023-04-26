package com.example.dipronto.diprontoDemo.controller;

import com.example.dipronto.diprontoDemo.entity.Categoria;
import com.example.dipronto.diprontoDemo.service.CategoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class CategoriaController {

    private final CategoriaService categoriaService;


    @PostMapping("/agregarCategoria")
    Categoria addCategoria(@RequestBody Categoria categoria) {
        return this.categoriaService.addCat(categoria);

    }
  /*

    @GetMapping("/buscarCategoria")
    List<Categoria> findAllCat() {
        return this.categoriaService.findAllCat();
    }


    @DeleteMapping("/borrarCategoria/{id}")
    void deleteCat(@PathVariable Long id) {
        categoriaService.deleteCat(id);
    }

    @PutMapping("/actualizaCategoria")
    public Categoria updateCat(@RequestBody Categoria categoria) {
        return this.categoriaService.updateCat(categoria);
    }
    /*
    @GetMapping("/findById/{id}")
    public Optional<Categoria> findByIdCat(@PathVariable Long id){
        return this.categoriaService.findByIdCat(id);
    }
    /*
    @GetMapping("/buscarCategoria/{nombre}")
    Categoria findByNombre(@PathVariable String nombre){
        try {
           return this.categoriaService.findByNombre(nombre);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nombre no existe", e.getCause());
        }

    }

     */

}
