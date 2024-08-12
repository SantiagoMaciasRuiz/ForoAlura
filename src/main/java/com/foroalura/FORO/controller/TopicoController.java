package com.foroalura.FORO.controller;

import com.foroalura.FORO.model.Curso.Curso;
import com.foroalura.FORO.model.Curso.CursoRepository;
import com.foroalura.FORO.model.Topico.Topico;
import com.foroalura.FORO.model.Topico.TopicoDTO;
import com.foroalura.FORO.model.Topico.TopicoRepository;
import com.foroalura.FORO.model.Usuario.Usuario;
import com.foroalura.FORO.model.Usuario.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/topicos")
public class TopicoController {
    private final TopicoRepository topicoRepository;

    private final UsuarioRepository usuarioRepository;

    private final CursoRepository cursoRepository;

    public TopicoController(TopicoRepository topicoRepository,UsuarioRepository usuarioRepository,CursoRepository cursoRepository) {
        this.topicoRepository = topicoRepository;
        this.usuarioRepository = usuarioRepository;
        this.cursoRepository = cursoRepository;
    }
    @PostMapping
    public ResponseEntity<?> registrarTopico(@RequestBody @Valid TopicoDTO topicoDTO) {
        if (topicoRepository.existsByTituloAndMensaje(topicoDTO.getTitulo(), topicoDTO.getMensaje())) {
            return ResponseEntity.badRequest().body("El tópico ya existe con el mismo título y mensaje.");
        }

        Usuario autor = usuarioRepository.findById(topicoDTO.getIdAutor())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Curso curso = cursoRepository.findById(topicoDTO.getIdCurso())
                .orElseThrow(() -> new RuntimeException("Curso no encontrado"));

        Topico topico = new Topico();
        topico.setTitulo(topicoDTO.getTitulo());
        topico.setMensaje(topicoDTO.getMensaje());
        topico.setAutor(autor);
        topico.setCurso(curso);

        topicoRepository.save(topico);

        return ResponseEntity.ok("Tópico registrado con éxito");
    }
}

