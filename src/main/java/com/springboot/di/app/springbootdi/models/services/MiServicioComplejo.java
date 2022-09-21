package com.springboot.di.app.springbootdi.models.services;

// import org.springframework.context.annotation.Primary;
// import org.springframework.stereotype.Component;
// import org.springframework.stereotype.Service;

// Cualquiera de los dos
//@Component // Es un singleton que se distribuye a nuestra aplicacion
// @Service("miServicioComplejo") // Service es una semantica => representa un servicio (Logica de negocio)
// @Primary // Para que sea la primera que tome de la IServicio si hay otra implementacion
public class MiServicioComplejo implements IServicio {

  @Override
  public String operacion() {
    return "ejecutando algún proceso importante complejo...";
  }
}
