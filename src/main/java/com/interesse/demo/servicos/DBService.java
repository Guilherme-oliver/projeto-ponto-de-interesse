package com.interesse.demo.servicos;

import com.interesse.demo.entidades.Coordenadas;
import com.interesse.demo.repositorios.CoordenadasRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Locale;

@Service
public class DBService {

    @Autowired
    private CoordenadasRepositorio coordenadasRepositorio;

    public void instantiateTestDatabase() throws ParseException {

        Locale.setDefault(Locale.US);

        Coordenadas coor1 = new Coordenadas(null,"Norte", 15.148F, -37.898F);
        Coordenadas coor2 = new Coordenadas(null, "Sul", -43.666F, 85.007F);
        Coordenadas coor3 = new Coordenadas(null, "Leste", 21.205F, 11.704F);
        Coordenadas coor4 = new Coordenadas(null, "Oeste", -88.888F, -77.777F);

        coordenadasRepositorio.saveAll(Arrays.asList(coor1, coor2, coor3, coor4));
    }
}
