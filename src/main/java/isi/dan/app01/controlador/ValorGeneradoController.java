package isi.dan.app01.controlador;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import isi.dan.app01.dto.ValorGeneradoDTO;
import isi.dan.app01.modelo.ValorGenerado;
import isi.dan.app01.servicios.ValorGeneradoService;

@RestController
@RequestMapping("/api/random")
public class ValorGeneradoController {
    
    Logger log = LoggerFactory.getLogger(ValorGenerado.class);

    @Autowired
    ValorGeneradoService servicio;

    @GetMapping("/{maximo}")
    public ValorGenerado generar(@PathVariable(name="maximo") Integer max){
        if(max == null) max = 100;
        if(max<=0) return null;
        return servicio.generar(max);
    }

    @GetMapping("/limitado")
    @Operation(description="retornar un aleatorio enre miniumo y maximo")
    @ApiResponses(value = {
        @ApiResponse(responseCode="400",description = "datos mal"),
        @ApiResponse(responseCode="401",description = "Noo tiene permismo"),
    })
    public ResponseEntity<?> generar(@RequestParam(required = false, defaultValue = "40") Integer min,@RequestParam Integer max){
        if(max == null) max = 100;
        if(min == null) min = 0;
        if(max<=0) return ResponseEntity.badRequest().body("El valor tiene uqe ser mayor quer cero");
        return ResponseEntity.ok().body(servicio.generar(min,max));
    }

    @PostMapping(consumes = "application/json")
    public ResponseEntity<ValorGenerado> guardar(@RequestBody ValorGeneradoDTO valorGeneradoReq){
        log.info("Recibo {}", valorGeneradoReq);
        ValorGenerado v = this.servicio.generar(valorGeneradoReq.getMinimo(), valorGeneradoReq.getMaximo(), valorGeneradoReq.getUsuario());
        return ResponseEntity.ok().body(v);
    }

    @PostMapping(consumes = "application/xml" )
    public String guardar2(ValorGeneradoDTO valorGenerado){
        return "XML";
    }

    @GetMapping()
    public ResponseEntity<List<ValorGenerado>> porUser(@RequestParam(name="user") String user){
        return ResponseEntity.ok().body(servicio.buscarPorNombre(user));
    }
}
