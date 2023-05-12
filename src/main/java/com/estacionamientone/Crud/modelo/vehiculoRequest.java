package com.estacionamientone.Crud.modelo;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;
//import javax.validation.constraints.NotEmpty

/**
 *
 * @author draco
 */
@Data
public class vehiculoRequest {
    
    @NotEmpty
    @Size(max=6)
    private String patente;
    @NotEmpty
    private String marca;
    @NotEmpty
    private String Tipo_Vehiculo;
    @NotEmpty
    private String Propietario;
    @NotEmpty
    private String estado;
    @NotEmpty
    private String hora_Entrada;
    
    private String hora_Salida;
    private String valor_Pagado; 
    
}
