package com.api_java.ms_task.view.controller;

import com.api_java.ms_task.dto.LembretesDTO;
import com.api_java.ms_task.model.Lembretes;
import com.api_java.ms_task.service.LembretesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lembretes")
public class LembretesController {

    @Autowired
    private LembretesService service;

    //@PreAuthorize("hasRole('USER')")
    @PostMapping
    public ResponseEntity<Lembretes> criarLembrete(@RequestBody LembretesDTO dto) {
        return ResponseEntity.ok(service.criarLembrete(dto));
    }

    //@PreAuthorize("hasRole('USER')")
    @GetMapping
    public ResponseEntity<List<Lembretes>> listarLembretes() {
        return ResponseEntity.ok(service.listarLembretes());
    }

    //@PreAuthorize("hasRole('USER')")
    @GetMapping("/{id}")
    public ResponseEntity<Lembretes> buscarPorId(@PathVariable Integer id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    //@PreAuthorize("hasRole('USER')")
    @PutMapping("/{id}")
    public ResponseEntity<String> atualizarLembrete(@PathVariable Integer id, @RequestBody LembretesDTO dto) {
        boolean atualizado = service.atualizarLembrete(id, dto);
        return atualizado ? ResponseEntity.ok("Lembrete atualizado com sucesso!") : ResponseEntity.notFound().build();
    }

    //@PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarLembrete(@PathVariable Integer id) {
        boolean deletado = service.deletarLembrete(id);
        return deletado ? ResponseEntity.ok("Lembrete deletado com sucesso!") : ResponseEntity.notFound().build();
    }
}