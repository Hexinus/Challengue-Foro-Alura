# Challengue-Foro-Alura
API contruiida con intellij, maven y spring initializr
API Foro - Gestión de Tópicos

Este proyecto es una API REST desarrollada con Spring Boot para gestionar tópicos de un foro. Implementa las operaciones básicas CRUD (Crear, Leer, Actualizar y Eliminar).

 Funcionalidad

La API permite:

 Crear un nuevo tópico

 Listar todos los tópicos

 Consultar un tópico por ID

 Actualizar un tópico

 Eliminar un tópico

 Estructura del proyecto
com.foro
├── controller   -> Endpoints REST
├── domain       -> Entidad JPA (Topico)
├── dto          -> DTOs de entrada y salida
├── repository   -> Acceso a base de datos
 Modelo de datos

Un tópico contiene:

id

titulo

mensaje

autor

fechaCreacion

activo

 Endpoints

POST /topicos → Crear tópico

GET /topicos → Listar tópicos

GET /topicos/{id} → Ver tópico

PUT /topicos/{id} → Actualizar tópico

DELETE /topicos/{id} → Eliminar tópico

 Tecnologías

Java

Spring Boot

Spring Data JPA

Hibernate

Maven

Postman

 Objetivo

Proyecto educativo para aprender a crear una API REST con Spring Boot, usando JPA, DTOs y operaciones CRUD.
