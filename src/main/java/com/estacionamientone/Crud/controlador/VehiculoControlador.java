package com.estacionamientone.Crud.controlador;

import com.estacionamientone.Crud.modelo.vehiculoModelo;
import com.estacionamientone.Crud.servicio.vehiculoServicio;
import java.net.http.HttpHeaders;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vehiculo")
public class VehiculoControlador {
    @Autowired
    vehiculoServicio vehiculoservicio;
    
    @GetMapping()
    public ArrayList<vehiculoModelo> ObtenerModelos(){
        return vehiculoservicio.obtenerModelos();
    }
    @PostMapping()
    public vehiculoModelo guardarModelo(@RequestBody vehiculoModelo modelo){

        return this.vehiculoservicio.guardarVehiculo(modelo);
    }
    
    @GetMapping(path = "/{id_Vehiculo}")
    public Optional<vehiculoModelo> obtenerVehiculoPorId(@PathVariable("id_Vehiculo") Integer id_Vehiculo){
        return this.vehiculoservicio.obtenerPorId(id_Vehiculo);
    }
    
    @GetMapping("/query")
    public ArrayList<vehiculoModelo> obtenerVehiculoPorMarca(@RequestParam("marca") String marca){
        return this.vehiculoservicio.obtenerPorMarca(marca);
    }
    
    @GetMapping("/querry")
    public ArrayList<vehiculoModelo> obtenerVehiculoPorPatente(@RequestParam("patente") String patente){
        return this.vehiculoservicio.obtenerPorPatente(patente);
    }
    
    @DeleteMapping( path = "/{id_Vehiculo}")
    public String eliminarPorId(@PathVariable("id_Vehiculo") Integer id_Vehiculo){
        boolean ok = this.vehiculoservicio.eliminarVehiculo(id_Vehiculo);
        if(ok){
        return "Se Elimino el vehículo :D!"+ id_Vehiculo;    
        }else{
            return "No se pudo eliminar" + id_Vehiculo;
        }
    }
    
}
