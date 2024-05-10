package isi.dan.app01.repositorio;

import java.sql.Timestamp;
import java.sql.Types;
import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import isi.dan.app01.modelo.ValorGenerado;

@Repository
public class ValorGeneradoJDBCRepo {

    final String sqlInsert = """
            INSERT INTO public.dan_nro_generado(
                generado, fecha, usuario, minimo, maximo)
                VALUES (:P_GEN, :P_FEC, :P_USR, :P_MIN, :P_MAX);
                """;

    @Autowired
    NamedParameterJdbcTemplate jdbc;

    public void guardar(ValorGenerado valor) {
        String ts = DateTimeFormatter.ISO_INSTANT.format(valor.getFechaGeneracion());
        Timestamp timestampValue = Timestamp.from(valor.getFechaGeneracion());

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("P_GEN",valor.getValor());
        params.addValue("P_FEC",timestampValue,Types.TIMESTAMP);
        params.addValue("P_USR",valor.getUsuario());
        params.addValue("P_MIN",valor.getMinimo());
        params.addValue("P_MAX",valor.getMaximo());
        jdbc.update(sqlInsert, params);
    }

    public List<ValorGenerado> buscarPorUsuuario(String usr){
        String SQL = """
            SELECT generado, fecha, usuario, minimo, maximo
            FROM dan_nro_generado
            WHERE usuario = :p_usr
            """;

            MapSqlParameterSource params = new MapSqlParameterSource();
            params.addValue("p_usr",usr);

            RowMapper<ValorGenerado> rm = (rs,rowNumber) -> {
                ValorGenerado fila = new ValorGenerado();
                fila.setValor(rs.getInt("generado"));
                fila.setUsuario(rs.getString("usuario"));
                fila.setMinimo(rs.getInt("minimo"));
                fila.setMaximo(rs.getInt("maximo"));
                fila.setFechaGeneracion(Instant.ofEpochMilli(rs.getTimestamp("fecha").getTime()));
                return fila;         
            };

            return jdbc.query(SQL, params, rm);
    

        
    }
}
