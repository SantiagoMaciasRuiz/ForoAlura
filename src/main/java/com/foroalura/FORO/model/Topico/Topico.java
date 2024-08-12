package com.foroalura.FORO.model.Topico;

import com.foroalura.FORO.model.Curso.Curso;
import com.foroalura.FORO.model.Respuestas.Respuesta;
import com.foroalura.FORO.model.Usuario.Usuario;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long Id;

    @NotBlank
    private String titulo;

    @NotBlank
    private String mensaje;

    private LocalDateTime fechaCreacion = LocalDateTime.now();

    @Enumerated(EnumType.STRING)
    private StatusTopico status = StatusTopico.NO_RESPONDIDO;

    @NotNull
    @ManyToOne
    private Usuario autor;
    @NotNull
    @ManyToOne
    private Curso curso;

    @OneToMany(mappedBy = "topico")
    private List<Respuesta> respuestas;
}
