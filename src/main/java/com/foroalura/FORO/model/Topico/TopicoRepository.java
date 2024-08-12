package com.foroalura.FORO.model.Topico;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TopicoRepository  extends JpaRepository<Topico, Long> {
    boolean existsByTituloAndMensaje(String titulo, String mensaje);
}
