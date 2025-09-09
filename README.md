# API REST para Gerenciamento de Tarefas

API REST desenvolvida em Spring Boot para gerenciamento de tarefas com operações CRUD.

## Tecnologias Utilizadas

- Java 17+
- Spring Boot 3.2.0
- Spring Web (REST APIs)
- Spring Data JPA (persistência)
- mysql 8.x (banco de dados)
- Maven (gerenciamento de dependências)

## Pré-requisitos

- Java 17 ou superior
- Maven 3.6+
- mysql 8.x instalado e rodando
- Postman (para testes da API)

## Configuração do Banco de Dados

1. Crie o banco de dados mysql:
```
CREATE DATABASE api_tarefas;
```

2. Configure as credenciais no arquivo `src/main/resources/application.yml`:
```
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/api_tarefas?useSSL=false&serverTimezone=UTC
    username: root
    password: sua_senha_aqui
```

## Como Executar

1. Clone o repositório
2. Execute a aplicação:
```
mvn spring-boot:run
```

A API estará disponível em: `http://localhost:8080`

## Endpoints da API

Base URL: `http://localhost:8080`

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| POST | `/tarefas` | Criar nova tarefa |
| GET | `/tarefas` | Listar todas as tarefas |
| GET | `/tarefas/{id}` | Buscar tarefa por ID |
| PUT | `/tarefas/{id}` | Atualizar tarefa |
| DELETE | `/tarefas/{id}` | Excluir tarefa |

### Entidade Tarefa

```
{
  "id": 1,
  "nome": "Desenvolvimento da API",
  "dataEntrega": "2025-12-12",
  "responsavel": "Nome RU123456"
}
```

Campos:
- `id`: Identificador único
- `nome`: Nome da tarefa (3-120 caracteres, obrigatório)
- `dataEntrega`: Data de entrega no formato ISO (yyyy-MM-dd, obrigatório)
- `responsavel`: Responsável pela tarefa (3-120 caracteres, obrigatório)

### Criar Tarefa
```
curl -X POST http://localhost:8080/tarefas \
  -H "Content-Type: application/json" \
  -d '{
    "nome": "Desenvolvimento da API",
    "dataEntrega": "2025-12-12",
    "responsavel": "Nome RU123456"
  }'
```

### Listar Tarefas
```
curl -X GET http://localhost:8080/tarefas
```

### Buscar Tarefa por ID
```
curl -X GET http://localhost:8080/tarefas/1
```

### Atualizar Tarefa
```
curl -X PUT http://localhost:8080/tarefas/1 \
  -H "Content-Type: application/json" \
  -d '{
    "nome": "Desenvolvimento da API (v2)",
    "dataEntrega": "2025-12-15",
    "responsavel": "Seu Nome"
  }'
```

### Excluir Tarefa
```
curl -X DELETE http://localhost:8080/tarefas/1
```

## Estrutura do Projeto

```
src/main/java/br/com/anthony/apitarefas/
├── domain/
│   └── Tarefa.java                 # Entidade JPA
├── repository/
│   └── TarefaRepository.java       # Interface do repositório
├── service/
│   └── TarefaService.java          # Lógica de negócio
├── web/
│   └── TarefaController.java       # Controller REST
├── exception/
│   ├── NotFoundException.java      # Exceção customizada
│   └── ApiExceptionHandler.java    # Handler global de exceções
└── ApitarefasApplication.java      # Classe principal
```
