<!-- PROJECT LOGO -->
<br />
<div align="center">
  <h3 align="center">Fridge Spring Study</h3>

  <p align="center">
    Projeto de estudo focado em <strong>Backend com Spring Boot</strong>
    <br />
    <em>Sistema de geladeira virtual para gerenciamento de alimentos</em>
  </p>
</div>

<!-- TABLE OF CONTENTS -->
<details>
  <summary>Índice</summary>
  <ol>
    <li>
      <a href="#sobre-o-projeto">Sobre o Projeto</a>
      <ul>
        <li><a href="#tecnologias-utilizadas">Tecnologias Utilizadas</a></li>
      </ul>
    </li>
    <li>
      <a href="#como-executar">Como Executar</a>
      <ul>
        <li><a href="#pré-requisitos">Pré-requisitos</a></li>
        <li><a href="#instalação-e-execução">Instalação e Execução</a></li>
      </ul>
    </li>
    <li><a href="#funcionalidades">Funcionalidades</a></li>
    <li><a href="#estrutura-do-projeto">Estrutura do Projeto</a></li>
    <li><a href="#endpoints-da-api">Endpoints da API</a></li>
    <li><a href="#aprendizados">Aprendizados</a></li>
    <li><a href="#fontes">Fontes</a></li>
    <li><a href="#contato">Contato</a></li>
  </ol>
</details>

<!-- ABOUT THE PROJECT -->
## Sobre o Projeto

Este é um projeto de **estudo e aprendizado** desenvolvido com Spring Boot para simular uma **geladeira virtual** onde é possível cadastrar, listar e gerenciar alimentos.

### Objetivo do Projeto
O objetivo principal foi aprender e praticar conceitos fundamentais de **desenvolvimento backend**, incluindo:

* **🎯 Spring Boot** - Criação de APIs RESTful
* **📊 JPA/Hibernate** - Persistência de dados e mapeamento objeto-relacional
* **🗃️ Banco H2** - Banco de dados em memória para desenvolvimento
* **🏗️ Arquitetura em Camadas** - Controller, Service e Repository
* **☕ Java 21** - Utilização das features mais recentes da linguagem

### Funcionalidade Principal
Sistema CRUD completo para gerenciamento de alimentos em uma geladeira virtual, permitindo:
- Cadastrar novos alimentos
- Listar todos os alimentos
- Excluir alimentos da geladeira
- Controle de data de validade e quantidade

<p align="right">(<a href="#readme-top">voltar ao topo</a>)</p>

### Tecnologias Utilizadas

**Backend:**
* [![Spring Boot][SpringBoot]][SpringBoot-url] - Framework principal (v3.5.4)
* [![Java][Java]][Java-url] - Java 21
* [![JPA][JPA]][JPA-url] - Spring Data JPA para persistência
* [![H2][H2]][H2-url] - Banco de dados em memória
* [![Maven][Maven]][Maven-url] - Gerenciamento de dependências
* [![Lombok][Lombok]][Lombok-url] - Redução de código boilerplate

<p align="right">(<a href="#readme-top">voltar ao topo</a>)</p>

<!-- GETTING STARTED -->
## Como Executar

### Pré-requisitos

Para executar este projeto localmente, você precisa ter instalado:

* **Java** (versão 21 ou superior) - **Obrigatório**
  ```sh
  java -version
  ```
* **Maven** - **Obrigatório** (ou use o wrapper incluído)
  ```sh
  mvn -version
  ```

### Instalação e Execução

1. Clone o repositório
   ```sh
   git clone https://github.com/seu-usuario/fridge-spring-s.git
   cd fridge-spring-s
   ```

2. **🎯 Executar o projeto**
   
   Usando Maven Wrapper (recomendado):
   ```sh
   ./mvnw clean install
   ./mvnw spring-boot:run
   ```
   
   Ou usando Maven instalado:
   ```sh
   mvn clean install
   mvn spring-boot:run
   ```

3. **✅ Verificar se está funcionando**
   ```sh
   curl http://localhost:8080/fridge
   ```
   
   > 🌐 A API estará disponível em http://localhost:8080

4. **🗃️ Acessar o Console H2 (Opcional)**
   ```
   URL: http://localhost:8080/h2-console
   JDBC URL: jdbc:h2:mem:testdb
   Username: admin
   Password: (deixe em branco)
   ```

<p align="right">(<a href="#readme-top">voltar ao topo</a>)</p>

<!-- FEATURES -->
## Funcionalidades

### ✅ Funcionalidades Implementadas
- [x] **Listar Alimentos** - GET `/fridge` - Retorna todos os alimentos da geladeira
- [x] **Cadastrar Alimento** - POST `/fridge` - Adiciona novo alimento
- [x] **Excluir Alimento** - DELETE `/fridge/{id}` - Remove alimento por ID
- [x] **Validação de Dados** - Campos obrigatórios e tipos corretos
- [x] **Persistência H2** - Banco de dados em memória
- [x] **Arquitetura em Camadas** - Separação entre Controller, Service e Repository

### 🔄 Modelo de Dados
```java
Food {
    id: Long (auto-incremento)
    name: String (nome do alimento)
    expirationDate: LocalDateTime (data de validade)
    quantity: int (quantidade)
}
```

<p align="right">(<a href="#readme-top">voltar ao topo</a>)</p>

## Estrutura do Projeto

```
src/
├── main/
│   ├── java/dev/santos/fridge_spring_study/
│   │   ├── FridgeSpringStudyApplication.java    # Classe principal
│   │   ├── controller/
│   │   │   └── FoodController.java              # Controller REST
│   │   ├── model/
│   │   │   └── Food.java                        # Entidade JPA
│   │   ├── repository/
│   │   │   └── FoodRepository.java              # Repository JPA
│   │   └── services/
│   │       └── FoodService.java                 # Camada de serviço
│   └── resources/
│       └── application.yml                      # Configurações
└── test/
    └── java/dev/santos/fridge_spring_study/
        └── FridgeSpringStudyApplicationTests.java
```

## Endpoints da API

| Método | Endpoint | Descrição | Body |
|--------|----------|-----------|------|
| `GET` | `/fridge` | Lista todos os alimentos | - |
| `POST` | `/fridge` | Cadastra novo alimento | `Food JSON` |
| `DELETE` | `/fridge/{id}` | Exclui alimento por ID | - |

### Exemplos de Uso

**Listar alimentos:**
```bash
curl -X GET http://localhost:8080/fridge
```

**Cadastrar alimento:**
```bash
curl -X POST http://localhost:8080/fridge \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Leite",
    "expirationDate": "2024-12-31T23:59:59",
    "quantity": 2
  }'
```

**Excluir alimento:**
```bash
curl -X DELETE http://localhost:8080/fridge/1
```

<p align="right">(<a href="#readme-top">voltar ao topo</a>)</p>

## Aprendizados

Durante o desenvolvimento deste projeto, foram explorados os seguintes conceitos:

### 🎯 Spring Boot & Spring Framework
- **Auto-configuração** - Configuração automática de componentes
- **Dependency Injection** - Inversão de controle e injeção de dependências
- **Component Scanning** - Descoberta automática de beans
- **Spring Boot Starters** - Dependências pré-configuradas

### 📊 Persistência de Dados
- **Spring Data JPA** - Abstração para acesso a dados
- **Repository Pattern** - Padrão para acesso a dados
- **Entity Mapping** - Mapeamento objeto-relacional com anotações
- **H2 Database** - Banco de dados em memória para desenvolvimento

### 🏗️ Arquitetura e Boas Práticas
- **Arquitetura em Camadas** - Separação de responsabilidades
- **REST API Design** - Criação de endpoints RESTful
- **HTTP Status Codes** - Códigos de resposta apropriados
- **Clean Code** - Código limpo e legível

### ☕ Java Moderno
- **Java 21 Features** - Uso das funcionalidades mais recentes
- **Records e Pattern Matching** - Estruturas de dados modernas
- **Maven Build Tool** - Gerenciamento de dependências e build

<p align="right">(<a href="#readme-top">voltar ao topo</a>)</p>

<!-- SOURCES -->
## Fontes

🔗 **[Springboot em 1 hora- Curso para inciantes - Fiasco](https://www.youtube.com/watch?v=g4y0yADhsJA)**

<p align="right">(<a href="#readme-top">voltar ao topo</a>)</p>

<!-- CONTACT -->
## Contato

🔗 **GitHub:** [Pedro Santos](https://github.com/pedrohsantosf)
💼 **LinkedIn:** [Pedro Santos](https://linkedin.com/in/pedrohsantosf)

🔗 **Link do Projeto:** [https://github.com/seu-usuario/fridge-spring-s](https://github.com/pedrohsantosf/fridge-spring-s)

<p align="right">(<a href="#readme-top">voltar ao topo</a>)</p>

---

<div align="center">
  <em>Projeto desenvolvido com ☕ para aprendizado de tecnologias <strong>Spring Boot</strong></em>
</div>

<!-- MARKDOWN LINKS & IMAGES -->
[SpringBoot]: https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white
[SpringBoot-url]: https://spring.io/projects/spring-boot
[Java]: https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white
[Java-url]: https://www.oracle.com/java/
[JPA]: https://img.shields.io/badge/JPA-6DB33F?style=for-the-badge&logo=spring&logoColor=white
[JPA-url]: https://spring.io/projects/spring-data-jpa
[H2]: https://img.shields.io/badge/H2-1021FF?style=for-the-badge&logo=h2&logoColor=white
[H2-url]: https://www.h2database.com/
[Maven]: https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white
[Maven-url]: https://maven.apache.org/
[Lombok]: https://img.shields.io/badge/Lombok-BC4521?style=for-the-badge&logo=lombok&logoColor=white
[Lombok-url]: https://projectlombok.org/
