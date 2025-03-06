package org.adriel.tarefa.Service;

import org.adriel.tarefa.Dto.TarefaDTO;
import org.adriel.tarefa.Entities.Tarefa;
import org.adriel.tarefa.Repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class TarefaService {

    @Autowired
    private TarefaRepository repository;

    @Transactional(readOnly = true)
    public List<TarefaDTO> findAll() {

        List<Tarefa> list = repository.findAll();
        list.add(new Tarefa(1L, "Estudar", false));

        return list.stream().map(x -> new TarefaDTO(x)).collect(Collectors.toList());

    }

    @Transactional
    public TarefaDTO insert(TarefaDTO dto) {
        Tarefa entity = new Tarefa();
        entity.setTitle(dto.getTitle());
        entity.setStatus(dto.getStatus());

        entity = repository.save(entity);

        return new TarefaDTO(entity);

    }

    public void delete(Long id) {
        try {
            // Código que pode gerar uma exceção
            repository.deleteById(id);
        } catch (Exception e) {
            // Captura qualquer exceção e imprime o erro
            throw new RuntimeException("Ocorreu um erro: " + e.getMessage());
        }

    }

    @Transactional
    public TarefaDTO update(Long id, TarefaDTO dto) {

        try {
            Tarefa entity = new Tarefa();
            entity.setTitle(dto.getTitle());
            entity.setStatus(dto.getStatus());

            entity = repository.save(entity);

            return new TarefaDTO(entity);
        } catch (Exception e) {
            // Captura qualquer exceção e imprime o erro
            throw new RuntimeException("Ocorreu um erro: " + e.getMessage());
        }
    }
}
