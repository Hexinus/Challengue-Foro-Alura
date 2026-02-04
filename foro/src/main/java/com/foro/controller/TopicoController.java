package com.foro.controller;  // direccion del archivo

//importar pacquetes
import com.foro.domain.Topico;
import com.foro.dto.DatosDetalleTopico;
import com.foro.dto.DatosRegistroTopico;
import com.foro.repository.TopicoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

//marcar clase como controlador rst
@RestController
//marcar prefijo "topicos" para las requiciciones POST, DELETE, GET etc.
@RequestMapping("/topicos")
public class TopicoController {

    private final TopicoRepository repository;

    public TopicoController(TopicoRepository repository) {
        this.repository = repository;
    }

    // crear topico aka POST
    @PostMapping //rsponde al post
    @Transactional //transacción de BD
    public ResponseEntity<DatosDetalleTopico> crear(
            //leer JSON del body el @valid se asegurar que no este en blanco aka "blank".
            @RequestBody @Valid DatosRegistroTopico datos) {

        var topico = new Topico(
                datos.titulo(),
                datos.mensaje(),
                datos.autor()
        );

        repository.save(topico);

        URI uri = URI.create("/topicos/" + topico.getId());
        return ResponseEntity.created(uri)
                .body(new DatosDetalleTopico(topico));
    }

    // Leer las listas
    @GetMapping
    public List<DatosDetalleTopico> listar() {
        return repository.findAll()
                .stream()
                .map(DatosDetalleTopico::new)
                .toList();
    }

    // leer entadra
    @GetMapping("/{id}")
    public ResponseEntity<DatosDetalleTopico> detalle(@PathVariable Long id) {
        var topico = repository.getReferenceById(id);
        return ResponseEntity.ok(new DatosDetalleTopico(topico));
    }

    // actualizar información
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<DatosDetalleTopico> actualizar(
            @PathVariable Long id,
            @RequestBody @Valid DatosRegistroTopico datos) {

        var topico = repository.getReferenceById(id);
        topico.setTitulo(datos.titulo());
        topico.setMensaje(datos.mensaje());
        topico.setAutor(datos.autor());

        return ResponseEntity.ok(new DatosDetalleTopico(topico));
    }

    // borrar
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
