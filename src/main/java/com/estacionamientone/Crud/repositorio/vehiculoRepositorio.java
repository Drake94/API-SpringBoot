package com.estacionamientone.Crud.repositorio;

import com.estacionamientone.Crud.modelo.vehiculoModelo;
import java.util.ArrayList;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface vehiculoRepositorio extends CrudRepository<vehiculoModelo, Integer>{
    public abstract ArrayList<vehiculoModelo> findByMarca(String Marca);
    public abstract ArrayList<vehiculoModelo> findByPatente(String Patente);
}
