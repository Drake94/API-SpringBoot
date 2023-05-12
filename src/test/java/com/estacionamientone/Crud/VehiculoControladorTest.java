package com.estacionamientone.Crud;

import com.estacionamientone.Crud.controlador.VehiculoControlador;
import com.estacionamientone.Crud.modelo.vehiculoModelo;
import com.estacionamientone.Crud.modelo.vehiculoRequest;
import com.estacionamientone.Crud.servicio.vehiculoServicio;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.swing.text.html.HTML;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 *
 * @author draco
 */

@ExtendWith(SpringExtension.class)
@WebMvcTest(VehiculoControlador.class)
public class VehiculoControladorTest {
    
    @Autowired
    private MockMvc mockMvc;
    
    @Autowired
    private ObjectMapper objectMapper;
    
    @MockBean
    private vehiculoServicio vehiculoServicio;
    
    
    @Captor
    private ArgumentCaptor<vehiculoModelo> argumentCaptor;
    
    
    @Test
    public void CrearUnNuevoVehiculoEnLaDB() throws Exception{
    
        vehiculoModelo vehiculorequest = new vehiculoModelo();
        
        vehiculorequest.setId_Vehiculo(21);
        vehiculorequest.setPatente("CTTT60");
        vehiculorequest.setMarca("Chevrolet");
        vehiculorequest.setEstado("Disponible");
        vehiculorequest.setHora_Entrada("2023-05-11 17:00:08");
        vehiculorequest.setHora_Salida(null);
        vehiculorequest.setValor_Pagado(null);
        vehiculorequest.setPropietario("Antonio");  
        vehiculorequest.setTipo_Vehiculo("Automovil");
              
        when(vehiculoServicio.guardarVehiculo(argumentCaptor.capture())).thenReturn(vehiculorequest);   
        
        this.mockMvc.perform(post("http://localhost:8080/vehiculo")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(vehiculorequest)))
                .andExpect(status().isOk());
        
        
        assertThat(argumentCaptor.getValue().getPatente(), is("CTTT60"));
        assertThat(argumentCaptor.getValue().getMarca(), is("Chevrolet"));
        assertThat(argumentCaptor.getValue().getTipo_Vehiculo(), is("Automovil"));
        assertThat(argumentCaptor.getValue().getPropietario(), is("Antonio"));
        assertThat(argumentCaptor.getValue().getEstado(), is("Disponible"));
        assertThat(argumentCaptor.getValue().getHora_Entrada(), is("2023-05-11 17:00:08"));
        /*assertThat(argumentCaptor.getValue().getHora_Salida(), is(null));
        assertThat(argumentCaptor.getValue().getValor_Pagado(), is(null));*/
        
    }
    
    
}
