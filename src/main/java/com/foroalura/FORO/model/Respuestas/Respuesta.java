package com.foroalura.FORO.model.Respuestas;

import com.foroalura.FORO.model.Topico.Topico;
import com.foroalura.FORO.model.Usuario.Usuario;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Respuesta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String mensaje;

    private LocalDateTime fechaCreacion = LocalDateTime.now();

    @ManyToOne
    private Topico topico;

    @ManyToOne
    private Usuario autor;

    private boolean solucion = false;
}
