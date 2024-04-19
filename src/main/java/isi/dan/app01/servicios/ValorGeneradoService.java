package isi.dan.app01.servicios;

import java.time.Instant;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import isi.dan.app01.modelo.ValorGenerado;

@Service
public class ValorGeneradoService {
    
    @Autowired
    NamedParameterJdbcTemplate jdbc;

    public ValorGenerado generar(Integer max){
        Random r = new Random();
        ValorGenerado v = new ValorGenerado();
        v.setFechaGeneracion(Instant.now());
        v.setValor(r.nextInt(max));
        return v;
    }

    public ValorGenerado generar(Integer min,Integer max){
        Random r = new Random();
        ValorGenerado v = new ValorGenerado();
        v.setFechaGeneracion(Instant.now());
        v.setValor(min+ r.nextInt(max-min));
        return v;
    }
}
