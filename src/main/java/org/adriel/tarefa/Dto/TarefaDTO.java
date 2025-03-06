package org.adriel.tarefa.Dto;



import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import org.adriel.tarefa.Entities.Tarefa;
import org.springframework.data.annotation.Id;


public class TarefaDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private Boolean status;


    public TarefaDTO() {
    }

    public TarefaDTO(Long id, String title, Boolean status) {
        this.id = id;
        this.title = title;
        this.status = status;
    }

    public TarefaDTO(Tarefa entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.status = entity.getStatus();
    }




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
