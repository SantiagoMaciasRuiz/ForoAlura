package com.foroalura.FORO.model.Usuario;

import com.foroalura.FORO.model.Perfil.Perfil;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

import java.util.List;

@Entity
@Getter
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nombre;

    @NotBlank
    @Column(unique = true)
    private String correoElectronico;

    @NotBlank
    private String contrasena;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Perfil> perfiles;
}
