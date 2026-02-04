package com.foro.domain;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "topicos")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String mensaje;
    private String autor;

    private LocalDateTime fechaCreacion = LocalDateTime.now();

    private Boolean activo = true;

    public Topico() {}

    public Topico(String titulo, String mensaje, String autor) {
        this.titulo = titulo;
        this.mensaje = mensaje;
        this.autor = autor;
    }

    // armar getters
    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public String getAutor() {
        return autor;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    // setters para las updates
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
}
