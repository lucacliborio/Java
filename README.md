# 🛒 Sistema de Pedidos — API REST

## Descrição do Sistema

API REST para gerenciamento de um sistema de pedidos, permitindo o cadastro de clientes, categorias, produtos e pedidos com seus respectivos itens. Desenvolvida como projeto final da disciplina de Desenvolvimento Web Java.

---

## Tecnologias Utilizadas

| Tecnologia | Versão |
|---|---|
| Java | 21 |
| Spring Boot | 4.0.4 |
| Spring Web | — |
| Spring Data JPA | — |
| Hibernate | 7.2.7 |
| MySQL | 8.0 |
| Bean Validation (Jakarta) | — |
| Maven | — |

---

## Arquitetura em Camadas

```
src/main/java/com/luca/projetofinal/
├── controller/      → Recebe as requisições HTTP
├── service/         → Regras de negócio e conversão para DTO
├── repository/      → Comunicação com o banco de dados
├── model/
│   ├── entity/      → Entidades JPA (tabelas do banco)
│   └── dto/         → Objetos de transferência de dados
└── exception/       → Tratamento global de exceções
```

---

## Entidades e Relacionamentos

- **Categoria** → tem muitos **Produtos** (OneToMany)
- **Produto** → pertence a uma **Categoria** (ManyToOne)
- **Cliente** → tem muitos **Pedidos** (OneToMany)
- **Pedido** → pertence a um **Cliente** (ManyToOne) e tem muitos **ItemPedido** (OneToMany)
- **ItemPedido** → pertence a um **Pedido** (ManyToOne) e referencia um **Produto** (ManyToOne)

---

## Como Executar o Projeto

### Pré-requisitos
- Java 21 instalado
- MySQL 8.0 instalado e rodando
- Maven instalado

### Passo a passo

**1. Criar o banco de dados no MySQL:**
```sql
CREATE DATABASE projetofinal;
```

**2. Configurar credenciais no `application.properties`:**
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/projetofinal
spring.datasource.username=root
spring.datasource.password=sua_senha
```

**3. Executar o projeto:**
```bash
./mvnw spring-boot:run
```

A aplicação estará disponível em: `http://localhost:8080`

---

## Endpoints Disponíveis

### Categoria
| Método | Endpoint | Descrição |
|---|---|---|
| GET | /categoria | Lista todas as categorias |
| GET | /categoria/{id} | Busca categoria por ID (retorna DTO) |
| POST | /categoria | Cria nova categoria |
| PUT | /categoria/{id} | Atualiza categoria |
| DELETE | /categoria/{id} | Remove categoria |

### Cliente
| Método | Endpoint | Descrição |
|---|---|---|
| GET | /cliente | Lista todos os clientes |
| GET | /cliente/{id} | Busca cliente por ID (retorna DTO sem senha) |
| POST | /cliente | Cria novo cliente |
| PUT | /cliente/{id} | Atualiza cliente |
| DELETE | /cliente/{id} | Remove cliente |

### Produto
| Método | Endpoint | Descrição |
|---|---|---|
| GET | /produto | Lista todos os produtos |
| GET | /produto/{id} | Busca produto por ID (retorna DTO com categoria) |
| POST | /produto | Cria novo produto |
| PUT | /produto/{id} | Atualiza produto |
| DELETE | /produto/{id} | Remove produto |

### Pedido
| Método | Endpoint | Descrição |
|---|---|---|
| GET | /pedido | Lista todos os pedidos |
| GET | /pedido/{id} | Busca pedido por ID (retorna DTO completo) |
| POST | /pedido | Cria novo pedido (data gerada automaticamente) |
| PUT | /pedido/{id} | Atualiza pedido |
| DELETE | /pedido/{id} | Remove pedido |

### Item Pedido
| Método | Endpoint | Descrição |
|---|---|---|
| GET | /itempedido | Lista todos os itens |
| GET | /itempedido/{id} | Busca item por ID (retorna DTO) |
| POST | /itempedido | Cria novo item |
| DELETE | /itempedido/{id} | Remove item |

---

## Exemplos de Requisições

> ⚠️ Respeitar a ordem de cadastro: **Categoria → Cliente → Produto → Pedido**

### POST /categoria
```json
{
  "nome": "Roupas",
  "descricao": "Categoria de roupas"
}
```

### POST /cliente
```json
{
  "nome": "João Silva",
  "email": "joao@email.com",
  "senha": "123456"
}
```

### POST /produto
```json
{
  "nome": "Calça Jeans",
  "preco": 89.90,
  "categoria": {
    "id": 1
  }
}
```

### POST /pedido
```json
{
  "cliente": {
    "id": 1
  },
  "itens": [
    {
      "produto": { "id": 1 },
      "quantidade": 2,
      "precoUnitario": 89.90
    }
  ]
}
```

### GET /pedido/{id} — Exemplo de resposta DTO
```json
{
  "id": 1,
  "data": "2026-05-13",
  "cliente": {
    "id": 1,
    "nome": "João Silva",
    "email": "joao@email.com"
  },
  "itens": [
    {
      "id": 1,
      "produto": {
        "id": 1,
        "nome": "Calça Jeans",
        "preco": 89.90,
        "categoria": {
          "id": 1,
          "nome": "Roupas",
          "descricao": "Categoria de roupas"
        }
      },
      "quantidade": 2,
      "precoUnitario": 89.90
    }
  ]
}
```

---

## Validações Implementadas

| Entidade | Campo | Validação |
|---|---|---|
| Categoria | nome | @NotBlank |
| Categoria | descricao | @NotBlank |
| Cliente | nome | @NotBlank |
| Cliente | email | @NotBlank + @Email |
| Cliente | senha | @NotBlank |
| Produto | nome | @NotBlank |
| Produto | preco | @NotNull + @Positive |
| Produto | categoria | @NotNull |
| Pedido | cliente | @NotNull |
| Pedido | itens | @NotEmpty |
| ItemPedido | produto | @NotNull |
| ItemPedido | quantidade | @NotNull + @Positive |
| ItemPedido | precoUnitario | @NotNull + @PositiveOrZero |

---

## Tratamento de Exceções

| Exceção | Status HTTP | Quando ocorre |
|---|---|---|
| RuntimeException | 404 Not Found | Recurso não encontrado por ID |
| MethodArgumentNotValidException | 400 Bad Request | Dados inválidos na requisição |

### Exemplo de resposta de erro
```json
{
  "status": 400,
  "mensagem": "Nome é obrigatório",
  "dataHora": "2026-05-13T10:30:00"
}
```
