package org.adriel.tarefa.Resources;

import org.adriel.tarefa.Dto.TarefaDTO;
import org.adriel.tarefa.Service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;


@Controller
@RequestMapping(value = "/tarefas")
public class TarefaResource {

    @Autowired
    private TarefaService service;

    @GetMapping
    public ResponseEntity<List<TarefaDTO>> findAll() {
        List<TarefaDTO> list = service.findAll();

        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    public ResponseEntity<TarefaDTO> insert(@RequestBody TarefaDTO dto) {


        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id ) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<TarefaDTO> update(@PathVariable Long id, @RequestBody TarefaDTO dto) {


        dto = service.update(id, dto);
        return ResponseEntity.ok().body(dto);
    }
}
