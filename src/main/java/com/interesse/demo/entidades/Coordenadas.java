package com.interesse.demo.entidades;

import io.swagger.models.auth.In;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;
import java.util.Objects;

@Entity
public class Coordenadas implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "O nome não pode ser nulo")
    private String nome;

    @NotEmpty(message = "A coordenada X não pode ser nulo")
    private Float coordenadaX;

    @NotEmpty(message = "A coordenada Y não pode ser nulo")
    private Float coordenadaY;

    private Float destino = 0.0F;

    public Coordenadas(){
    }

    public Coordenadas(Integer id, String nome, Float coordenadaX, Float coordenadaY) {
        this.id = id;

        if (nome == null){
            System.out.println("Nome não pode ser nulo");
        }else {
            this.nome = nome;
        }

        if (coordenadaX == null){
            System.out.println("Não pode ser nulo");
        }else {
            this.coordenadaX = coordenadaX;
        }

        if (coordenadaX == null){
            System.out.println("Não pode ser nulo");
        }else {
            this.coordenadaY = coordenadaY;
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Float getCoordenadaX() {
        return coordenadaX;
    }

    public void setCoordenadaX(Float coordenadaX) {
        this.coordenadaX = coordenadaX;
    }

    public Float getCoordenadaY() {
        return coordenadaY;
    }

    public void setCoordenadaY(Float coordenadaY) {
        this.coordenadaY = coordenadaY;
    }

    public Float getDestino(){
        destino = coordenadaX - coordenadaY;
        if (destino < 0){
            return destino * (-1);
        }else {
            return destino;
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordenadas that = (Coordenadas) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
