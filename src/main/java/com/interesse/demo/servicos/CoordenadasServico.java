package com.interesse.demo.servicos;

import com.interesse.demo.entidades.Coordenadas;
import com.interesse.demo.repositorios.CoordenadasRepositorio;
import com.interesse.demo.servicos.excecoes.DatabaseException;
import com.interesse.demo.servicos.excecoes.ObjectNotFoundException;
import com.interesse.demo.servicos.excecoes.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CoordenadasServico {

    @Autowired
    private CoordenadasRepositorio coordenadasRepositorio;

    public List<Coordenadas> findAll(){
        return coordenadasRepositorio.findAll();
    }

    public Coordenadas findById(Integer id){
        Optional<Coordenadas> objeto = coordenadasRepositorio.findById(id);
        return objeto.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Coordenadas.class.getName()));
    }

    public Coordenadas findByNome(String nome){
        Optional<Coordenadas> objeto = coordenadasRepositorio.findByNome(nome);
        return objeto.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Nome: " + nome + ", Tipo: " + Coordenadas.class.getName()));
    }
    /*
    public Optional<Coordenadas> findByParams(Float coordenadaX, Float coordenadaY, Float destino){
        Optional<Coordenadas> objeto = coordenadasRepositorio.findByParams(coordenadaX, coordenadaY, destino);
        return objeto;
    }
    */
    public Coordenadas insert(Coordenadas objeto) {
        objeto.setId(null);
        objeto = coordenadasRepositorio.save(objeto);
        return objeto;
    }

    public void deleteById(Integer id){
        try {
            coordenadasRepositorio.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    private void updateData(Coordenadas entity, Coordenadas objeto){
        entity.setNome(objeto.getNome());
        entity.setCoordenadaX(objeto.getCoordenadaX());
        entity.setCoordenadaY(objeto.getCoordenadaY());
    }

    public Coordenadas update(Integer id, Coordenadas objeto){
        try {
            Coordenadas entity = coordenadasRepositorio.getReferenceById(id);
            updateData(entity, objeto);
            return coordenadasRepositorio.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

}
