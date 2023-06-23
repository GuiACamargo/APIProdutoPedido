package com.atitus.APIProdutoPedido.controllers;

import com.atitus.APIProdutoPedido.entities.GenericEntity;
import com.atitus.APIProdutoPedido.services.GenericService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

public abstract class GenericController<TEntidade extends GenericEntity> {

    abstract GenericService<TEntidade> getService();

    ResponseEntity<Object> salvar(TEntidade entidade) {
        try {
            getService().save(entidade);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.OK).body(entidade);
    }

    @PostMapping
    public ResponseEntity<Object> postEntidade(@RequestBody TEntidade entidade) {
        return salvar(entidade);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> putEntidade(@PathVariable long id, @RequestBody TEntidade entidade) {
        entidade.setId(id);
        return salvar(entidade);
    }

    @GetMapping()
    public ResponseEntity<Object> getEntidades(@PageableDefault(page = 0, size = 5, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) throws Exception {
        Page<TEntidade> entidades = getService().findAll(pageable);
        return ResponseEntity.status(HttpStatus.OK).body(entidades);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getEntidadesById(@PathVariable long id) throws Exception {
        Optional<TEntidade> entidade = getService().findById(id);
        if (entidade.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("TEntidade não encontrado com o Id " + id);
        else {
            return ResponseEntity.status(HttpStatus.OK).body(entidade);
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteEntidade(@PathVariable long id) {
        getService().deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Entidade com Id " + id + " deletada com sucesso!");
    }

}