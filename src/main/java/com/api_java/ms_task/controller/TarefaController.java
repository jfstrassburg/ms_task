package com.api_java.ms_task.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api_java.ms_task.model.Tarefa;
import com.api_java.ms_task.service.TarefaService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/tarefas")
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;

    @GetMapping
    public List<Tarefa> obterTodos() {
        return tarefaService.obterTodos();
    }
    
    @GetMapping("/{id}")
    public Optional<Tarefa> obterPorId(@PathVariable Integer id) {
        return tarefaService.obterPorId(id);
    }
    
    @PostMapping
    public Tarefa adicionar(@RequestBody Tarefa tarefa) {
        return tarefaService.adicionar(tarefa);
    }

    @DeleteMapping("/{id}")
    public String deletar(@PathVariable Integer id) {
        tarefaService.deletar(id);
        return "Tarefa com id:" + id + " foi deletado com sucesso!";
    }

    @PutMapping("/{id}")
    public Tarefa atualizar(@PathVariable Integer id, @RequestBody Tarefa tarefa) {
        return tarefaService.atualizar(id, tarefa);
    }
}
