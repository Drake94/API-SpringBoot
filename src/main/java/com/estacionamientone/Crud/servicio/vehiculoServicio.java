package com.estacionamientone.Crud.servicio;

import com.estacionamientone.Crud.modelo.vehiculoModelo;
import com.estacionamientone.Crud.modelo.vehiculoRequest;
import com.estacionamientone.Crud.repositorio.vehiculoRepositorio;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class vehiculoServicio {
    @Autowired
    vehiculoRepositorio vehiculorepositorio;
    
    public ArrayList<vehiculoModelo> obtenerModelos(){
        return (ArrayList<vehiculoModelo>)vehiculorepositorio.findAll();
    
    }
    
    public vehiculoModelo guardarVehiculo(vehiculoModelo modelo){
        return vehiculorepositorio.save(modelo);
    }
    public Long guarVehiculo(vehiculoRequest vehiculorequest){
        return null;
    }
    
    
    public Optional<vehiculoModelo> obtenerPorId(Integer id_Vehiculo){
        return vehiculorepositorio.findById(id_Vehiculo);
    }
    
    public ArrayList<vehiculoModelo> obtenerPorMarca(String Marca){
        return vehiculorepositorio.findByMarca(Marca); 
    }
    
    public ArrayList<vehiculoModelo> obtenerPorPatente(String Patente){
        return vehiculorepositorio.findByPatente(Patente); 
    }
    
    public boolean eliminarVehiculo(Integer id_Vehiculo){
        try{
            vehiculorepositorio.deleteById(id_Vehiculo);
            return true;
        }catch(Exception err){
            return false;
        }
    }
    
}
