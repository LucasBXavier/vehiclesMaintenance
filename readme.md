# Vehicles Maintenance API
![Java](https://img.shields.io/badge/Java-11+-red?logo=java)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-2.7-green?logo=springboot)
![Maven](https://img.shields.io/badge/Maven-3.6+-orange?logo=apachemaven)
![License: MIT](https://img.shields.io/badge/License-MIT-blue.svg)

Este projeto é uma API RESTful para gerenciamento de registros de manutenção de veículos.
Ela permite criar, consultar, atualizar e excluir manutenções associadas a veículos, seguindo boas práticas de design REST.

A API foi desenvolvida utilizando Spring Boot e possui uma arquitetura organizada, focada em manutenibilidade e testabilidade.
## Estrutura do Projeto
```
├── 📁 .mvn
│   └── 📁 wrapper
│       └── 📄 maven-wrapper.properties
├── 📁 src
│   ├── 📁 main
│   │   ├── 📁 java
│   │   │   └── 📁 io
│   │   │       └── 📁 github
│   │   │           └── 📁 lucasbxavier
│   │   │               └── 📁 vehiclesmaintenance
│   │   │                   ├── 📁 config
│   │   │                   │   └── ☕ SwaggerConfig.java
│   │   │                   ├── 📁 controller
│   │   │                   │   └── ☕ VehiclesMaintenanceController.java
│   │   │                   ├── 📁 domain
│   │   │                   │   ├── 📁 entities
│   │   │                   │   │   └── ☕ Maintenance.java
│   │   │                   │   └── 📁 enums
│   │   │                   │       ├── ☕ MaintenanceStatus.java
│   │   │                   │       └── ☕ MaintenanceType.java
│   │   │                   ├── 📁 dto
│   │   │                   │   ├── ☕ ErrorResponseDTO.java
│   │   │                   │   ├── ☕ MaintenanceRequestDTO.java
│   │   │                   │   └── ☕ MaintenanceResponseDTO.java
│   │   │                   ├── 📁 exception
│   │   │                   │   ├── ☕ BusinessRuleException.java
│   │   │                   │   └── ☕ MaintenanceNotFoundException.java
│   │   │                   ├── 📁 mapper
│   │   │                   │   └── ☕ MaintenanceMapper.java
│   │   │                   ├── 📁 repository
│   │   │                   │   └── ☕ MaintenanceRepository.java
│   │   │                   ├── 📁 service
│   │   │                   │   └── ☕ MaintenanceService.java
│   │   │                   └── ☕ VehiclesMaintenanceApplication.java
│   │   └── 📁 resources
│   │       ├── 📁 docs
│   │       │   └── 📄 jsonTeste
│   │       ├── 📁 static
│   │       ├── 📁 templates
│   │       └── 📄 application.properties
│   └── 📁 test
│       └── 📁 java
│           └── 📁 io
│               └── 📁 github
│                   └── 📁 lucasbxavier
│                       └── 📁 vehiclesmaintenance
│                           ├── 📁 config
│                           │   └── ☕ SwaggerConfigTest.java
│                           ├── 📁 controller
│                           │   └── ☕ VehiclesMaintenanceControllerTest.java
│                           ├── 📁 domain
│                           │   └── 📁 entities
│                           │       └── ☕ MaintenanceTest.java
│                           ├── 📁 dto
│                           │   └── ☕ MaintenanceResponseDTOTest.java
│                           ├── 📁 exception
│                           │   ├── ☕ BusinessRuleExceptionTest.java
│                           │   └── ☕ MaintenanceNotFoundExceptionTest.java
│                           ├── 📁 mapper
│                           │   └── ☕ MaintenanceMapperTest.java
│                           ├── 📁 service
│                           │   └── ☕ MaintenanceServiceTest.java
│                           └── ☕ VehiclesMaintenanceApplicationTests.java
├── ⚙️ .gitattributes
├── ⚙️ .gitignore
├── ⚙️ docker-compose.yml
├── 📄 mvnw
├── 📄 mvnw.cmd
├── ⚙️ pom.xml
└── 📝 readme.md
```

## Features
- Criar um novo registro de manutenção para um veículo
- Listar todas as manutenções cadastradas
- Buscar uma manutenção específica pelo ID
- Atualizar um registro de manutenção existente
- Excluir uma manutenção pelo ID
- Validação de dados de entrada
- Tratamento centralizado de erros e regras de negócio

## Tecnologias Utilizadas
- Java 21
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Swagger / OpenAPI para documentação
- JUnit 5 e Mockito para testes automatizados

## Como Executar o Projeto
### Pré-requisitos
- Java 21
- Maven
- PostgreSQL

### Instalação
1. Clone o repositório:
```bash 
git clone https://github.com/lucasbxavier/vehiclesMaintenance.git
```
2. Navigate to the project directory:
```bash 
cd vehiclesMaintenance
```
3. Configure a conexão com o banco de dados em `src/main/resources/application.properties`:
```
spring.datasource.url=jdbc:postgresql://localhost:5432/vehicles_maintenance
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```
4. Compile e rode os testes:
```bash 
mvn clean install
```
5. Execute a aplicação:
```bash 
mvn spring-boot:run
```
6. Acesse a documentação da API (Swagger UI): `http://localhost:8080/vehicles-maintenance/swagger-ui.html`.