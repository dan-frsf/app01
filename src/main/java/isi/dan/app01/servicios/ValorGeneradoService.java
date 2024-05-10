package isi.dan.app01.servicios;

import java.time.Instant;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import isi.dan.app01.modelo.ValorGenerado;
import isi.dan.app01.repositorio.ValorGeneradoJDBCRepo;

@Service
public class ValorGeneradoService {
    

    @Autowired
    ValorGeneradoJDBCRepo repo;

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


    public ValorGenerado generar(Integer min,Integer max, String user){
        ValorGenerado v = this.generar(min, max);
        v.setMinimo(min);
        v.setMaximo(max);
        v.setUsuario(user);
        repo.guardar(v);
        return v;
    }

    public List<ValorGenerado> buscarPorNombre(String usrName){
        return repo.buscarPorUsuuario(usrName);
    }
}
