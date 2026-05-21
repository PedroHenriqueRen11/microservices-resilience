# Ecossistema de Microsserviços e Resiliência 🚀

Projeto prático focado em microsserviços integrados, resiliência, descoberta de serviços e gerenciamento de configurações centralizadas.

---

## 👤 Autor
* **Nome:** Pedro Henrique Renosto
* **Repositório:** [PedroHenriqueRen11/microservices-resilience](https://github.com/PedroHenriqueRen11/microservices-resilience)

---

## 🏗️ Arquitetura do Sistema

O ecossistema é composto por **4 microsserviços**:

1. **`config-service` (Porta `8888`):** Servidor Centralizado (`Spring Cloud Config Server`) que distribui as propriedades da pasta `/configs`.
2. **`discovery-service` (Porta `8761`):** Servidor de Descoberta (`Spring Cloud Netflix Eureka Server`) para registro automático dos serviços.
3. **`currency-service` (Porta `8100`):** Serviço de moedas que consome a API do Banco Central do Brasil via OpenFeign com resiliência (`Resilience4j`).
4. **`product-service` (Porta `8200`):** Serviço de catálogo de produtos que consome o `currency-service` para conversão de valores.

---

## 🛠️ Stack Tecnológica

* Java 17 / Spring Boot 3.x
* Spring Cloud (Config & Eureka Server)
* OpenFeign & Resilience4j (Circuit Breaker e Retry)
* Spring Data JPA & Flyway Migration
* Spring Boot Actuator

---

## 🚦 Ordem de Inicialização

Execute os serviços no terminal usando o comando abaixo na seguinte ordem:

1. **`config-service`**
2. **`discovery-service`**
3. **`currency-service`**
4. **`product-service`**

```bash
./mvnw spring-boot:run -Dmaven.test.skip=true

Links para Validação da IA
Eureka Dashboard: http://localhost:8761

Actuator Info (Currency): http://localhost:8100/actuator/info

Actuator Info (Product): http://localhost:8200/actuator/info

Config Server JSON: http://localhost:8888/currency-service/default
