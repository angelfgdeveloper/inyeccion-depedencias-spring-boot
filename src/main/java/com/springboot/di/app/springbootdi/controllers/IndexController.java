package com.springboot.di.app.springbootdi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.springboot.di.app.springbootdi.models.services.IServicio;
// import com.springboot.di.app.springbootdi.models.services.MiServicio;

@Controller
public class IndexController {

  // No llamar al objeto
  // private MiServicio servicio = new MiServicio();

  // Llamar 1. Inyeccion de dependencias, 2. Interfaces
  
  // #1
  // Principio de Inyeccion de dependencias (Hollywood) => No nos llames nosotros lo hacemos
  // @Autowired // Busca un tipo spring para no colocar el new ..
  // private MiServicio servicio; // Servicio muy acoplado

  // #2
  // @Autowired // Utilizar clases abstractas
  // @Qualifier("miServicioComplejo") // Permite seleccionar atraves del nombre
  // private IServicio servicio; // Inyectamos atraves de la interfaz

  // #3
  // @Autowired
  // public void setServicio(IServicio servicio) {
  //   this.servicio = servicio;
  // }

  // #4
  // private IServicio servicio;
  // @Autowired // Se puede omitir
  // public IndexController(IServicio servicio) {
  //   this.servicio = servicio;
  // }

  // #5
  @Autowired // Busca un tipo spring para no colocar el new ..
  @Qualifier("miServicioComplejo")
  private IServicio servicio; // Servicio muy acoplado

  @GetMapping({ "/", "", "/index" })
  public String index(Model model) {
    model.addAttribute("objeto", servicio.operacion());

    return "index";
  }


  
  
}
