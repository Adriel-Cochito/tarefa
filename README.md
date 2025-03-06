# Tarefa Resource API

Este é um exemplo de recurso RESTful desenvolvido com Spring Boot. A classe `TarefaResource` gerencia as operações CRUD (Create, Read, Update, Delete) para o gerenciamento de tarefas.

## Endpoints

### 1. **GET /tarefas**
- **Descrição**: Retorna a lista de todas as tarefas.
- **Resposta**: Lista de `TarefaDTO` com as tarefas.
- **Código de Status**: `200 OK`

### 2. **POST /tarefas**
- **Descrição**: Cria uma nova tarefa.
- **Requisição**: Um objeto `TarefaDTO` no corpo da solicitação.
- **Resposta**: O objeto `TarefaDTO` criado com um link para o novo recurso.
- **Código de Status**: `201 Created`

### 3. **DELETE /tarefas/{id}**
- **Descrição**: Deleta uma tarefa pelo ID fornecido.
- **Requisição**: O `id` da tarefa a ser deletada.
- **Código de Status**: `204 No Content`

### 4. **PUT /tarefas/{id}**
- **Descrição**: Atualiza os dados de uma tarefa existente.
- **Requisição**: O `id` da tarefa e um objeto `TarefaDTO` com os novos dados.
- **Resposta**: O objeto `TarefaDTO` atualizado.
- **Código de Status**: `200 OK`

## Dependências

- **Spring Boot**: Framework para criação de aplicações Java baseadas em Spring.
- **TarefaService**: Serviço que contém a lógica de negócios para manipular tarefas.
- **TarefaDTO**: Data Transfer Object (DTO) que representa as informações de uma tarefa.

## Como executar

1. **Clone o repositório**:
    ```bash
    git clone <url_do_repositório>
    ```

2. **Instale as dependências**:
    ```bash
    mvn install
    ```

3. **Execute a aplicação**:
    ```bash
    mvn spring-boot:run
    ```

A API estará disponível em `http://localhost:8080/tarefas`.

