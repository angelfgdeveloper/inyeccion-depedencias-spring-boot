package com.springboot.di.app.springbootdi;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.springboot.di.app.springbootdi.models.domain.ItemFactura;
import com.springboot.di.app.springbootdi.models.domain.Producto;
import com.springboot.di.app.springbootdi.models.services.IServicio;
import com.springboot.di.app.springbootdi.models.services.MiServicio;
import com.springboot.di.app.springbootdi.models.services.MiServicioComplejo;

// Siempre colocar a la par del packages para que encuentre el configuration
@Configuration
public class AppConfig {

  // @Primarys
  @Bean("miServicioSimple") // Para registrar nuestra implementación
  public IServicio registrarMiServicio() {
    return new MiServicio();
  }
  
  @Bean("miServicioComplejo") // Para registrar nuestra implementación
  public IServicio registrarMiServicioComplejo() {
    return new MiServicioComplejo();
  }

  @Bean("itemListaFactura")
  public List<ItemFactura> registrarItems() {
    Producto producto1 = new Producto("Camara sony", 100);
    Producto producto2 = new Producto("Bicicleta Bianchi aro 26", 200);

    ItemFactura linea1 = new ItemFactura(producto1, 2);
    ItemFactura linea2 = new ItemFactura(producto2, 4);

    return Arrays.asList(linea1, linea2); // Arreglo
  }
  

  @Primary
  @Bean("itemFacturaOficina")
  public List<ItemFactura> registrarItemsOficina() {
    Producto producto1 = new Producto("Monitor LG - LCD 24", 250);
    Producto producto2 = new Producto("Notebook Asus", 500);
    Producto producto3 = new Producto("Impresora HP Multifuncional", 800);
    Producto producto4 = new Producto("Escritorio Oficina", 300);

    ItemFactura linea1 = new ItemFactura(producto1, 2);
    ItemFactura linea2 = new ItemFactura(producto2, 1);
    ItemFactura linea3 = new ItemFactura(producto3, 1);
    ItemFactura linea4 = new ItemFactura(producto4, 1);

    return Arrays.asList(linea1, linea2, linea3, linea4); // Arreglo
  }
  
}
