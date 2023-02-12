package com.interesse.demo.repositorios;

import com.interesse.demo.entidades.Coordenadas;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CoordenadasRepositorio extends JpaRepository<Coordenadas, Integer> {

    Optional<Coordenadas> findByNome(String nome);
    //Optional<Coordenadas> findByParams(Float coordenadaX, Float coordenadaY, Float destino);
}
