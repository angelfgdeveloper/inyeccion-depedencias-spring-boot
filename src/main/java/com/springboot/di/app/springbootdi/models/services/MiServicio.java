package com.springboot.di.app.springbootdi.models.services;

// import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

// Cualquiera de los dos
//@Component // Es un singleton que se distribuye a nuestra aplicacion
@Service("miServicioSimple") // Service es una semantica => representa un servicio (Logica de negocio)
public class MiServicio implements IServicio {
  // Un servicio es la obtencion de los datos o acceso de datos
  // con Dao, consultas, etc.

  // public String operacion() {
  // return "ejecutando algún proceso importante...";
  // }

  // Protocolo que requiere la interface (Sobrescribe)
  @Override
  public String operacion() {
    return "ejecutando algún proceso importante...";
  }
}
