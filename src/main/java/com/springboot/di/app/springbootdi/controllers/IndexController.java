package com.springboot.di.app.springbootdi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.springboot.di.app.springbootdi.models.services.IServicio;

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
  @Autowired // Utilizar clases abstractas
  private IServicio servicio; // Inyectamos atraves de la interfaz

  @GetMapping({ "/", "", "/index" })
  public String index(Model model) {
    model.addAttribute("objeto", servicio.operacion());

    return "index";
  }
  
}
