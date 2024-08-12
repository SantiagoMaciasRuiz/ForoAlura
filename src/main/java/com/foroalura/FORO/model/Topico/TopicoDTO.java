package com.foroalura.FORO.model.Topico;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class TopicoDTO {
    @NotBlank
    private String titulo;

    @NotBlank
    private String mensaje;

    @NotBlank
    private Long idAutor;

    @NotBlank
    private Long idCurso;
}
