package com.api_java.ms_task.view.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api_java.ms_task.service.TarefaService;
import com.api_java.ms_task.shared.TarefaDTO;
import com.api_java.ms_task.view.model.TarefaRequest;
import com.api_java.ms_task.view.model.TarefaResponse;

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
    public ResponseEntity<List<TarefaResponse>> obterTodos() {
        List<TarefaDTO> tarefa = tarefaService.obterTodos();

        ModelMapper mapper = new ModelMapper();

        List<TarefaResponse> resposta = tarefa.stream()
        .map(tarefaDto -> mapper.map(tarefaDto, TarefaResponse.class))
        .collect(Collectors.toList());
                
        return new ResponseEntity<>(resposta, HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Optional<TarefaResponse>> obterPorId(@PathVariable Integer id) {
        
        Optional<TarefaDTO> dto = tarefaService.obterPorId(id);

        TarefaResponse tarefa = new ModelMapper().map(dto.get(), TarefaResponse.class);

        return new ResponseEntity<>(Optional.of(tarefa), HttpStatus.OK);

    }
    
    @PostMapping
    public ResponseEntity<TarefaResponse> adicionar(@RequestBody TarefaRequest tarefaReq) {
        ModelMapper mapper = new ModelMapper();

        TarefaDTO tarefaDto = mapper.map(tarefaReq, TarefaDTO.class);

        tarefaDto = tarefaService.adicionar(tarefaDto);

        return new ResponseEntity<>(mapper.map(tarefaDto, TarefaResponse.class), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Integer id) {
        
        tarefaService.deletar(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TarefaResponse> atualizar(@PathVariable Integer id, @RequestBody TarefaRequest tarefaReq) {
        
        ModelMapper mapper = new ModelMapper();

        TarefaDTO tarefaDto = mapper.map(tarefaReq, TarefaDTO.class);

        tarefaDto = tarefaService.atualizar(id, tarefaDto);

        return new ResponseEntity<>(mapper.map(tarefaDto, TarefaResponse.class),HttpStatus.OK);
    }
}
