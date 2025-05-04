package com.api_java.ms_task.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api_java.ms_task.model.Tarefa;
import com.api_java.ms_task.repository.TarefaRepository;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository tarefaRepository;

    public List<Tarefa> obterTodos() {
        // Chama o método do repositório para obter todas as tarefas
        // e retorna a lista.
        // Aqui você pode adicionar lógica adicional(regras de negócio), se necessário.
        return tarefaRepository.obterTodos();
    }   

    public Optional<Tarefa> obterPorId(Integer id) {
        return tarefaRepository.obterPorId(id);
    }

    public Tarefa adicionar(Tarefa tarefa) {
        return tarefaRepository.adicionar(tarefa);
    }   

    public void deletar(Integer id) {
        tarefaRepository.deletar(id);
    }
    public Tarefa atualizar(Integer id, Tarefa tarefa) {
        // Verifica se a tarefa existe antes de atualizar
        tarefa.setId(id);
        // Aqui você pode adicionar lógica adicional (regras de negócio), se necessário.    
        return tarefaRepository.atualizar(tarefa);
    }


}
