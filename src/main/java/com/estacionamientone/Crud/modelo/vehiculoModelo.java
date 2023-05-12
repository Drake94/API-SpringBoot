package com.estacionamientone.Crud.modelo;

import jakarta.persistence.*;
@Entity
@Table(name = "vehiculo")
public class vehiculoModelo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Vehiculo")
    private Integer id_Vehiculo;
    
    private String patente;   
    private String marca;
    private String Tipo_Vehiculo;
    private String Propietario;
    private String estado;
    private String hora_Entrada;
    private String hora_Salida;
    private String valor_Pagado;
    

    public int getId_Vehiculo() {
        return id_Vehiculo;
    }
    public void setId_Vehiculo(int id_Vehiculo) {
        this.id_Vehiculo = id_Vehiculo;
    }
    public String getPatente() {
        return patente;
    }
    public void setPatente(String patente) {
        this.patente = patente;
    }
    public String getTipo_Vehiculo() {
        return Tipo_Vehiculo;
    }
    public void setTipo_Vehiculo(String Tipo_Vehiculo) {
        this.Tipo_Vehiculo = Tipo_Vehiculo;
    }
    public String getPropietario() {
        return Propietario;
    }
    public void setPropietario(String Propietario) {
        this.Propietario = Propietario;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public String getHora_Entrada() {
        return hora_Entrada;
    }
    public void setHora_Entrada(String hora_Entrada) {
        this.hora_Entrada = hora_Entrada;
    }
    public String getHora_Salida() {
        return hora_Salida;
    }
    public void setHora_Salida(String hora_Salida) {
        this.hora_Salida = hora_Salida;
    }
    public String getValor_Pagado() {
        return valor_Pagado;
    }
    public void setValor_Pagado(String valor_Pagado) {
        this.valor_Pagado = valor_Pagado;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
    


            
            
}
