package com.springboot.di.app.springbootdi.models.domain;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope // Va a durar una petición HTTP => no es un singleton // Sigue concatenando
// @SessionScope // Carrito de compras o auth, es persistente (se limpia al destruir) // Serializable
// @ApplicationScope // Es singleton, es un solo contexto
public class Factura implements Serializable {

  // Atributo static que manej por debajo
  private static final long serialVersionUID = 946004357128146951L;

  @Value("${factura.descripcion}")
  private String descripcion;

  @Autowired
  private Cliente cliente;

  @Autowired
  // @Qualifier("itemFacturaOficina")
  private List<ItemFactura> items;

  public Factura() {
  }

  public Factura(String descripcion, Cliente cliente, List<ItemFactura> items) {
    this.descripcion = descripcion;
    this.cliente = cliente;
    this.items = items;
  }

  @PostConstruct // Se ejecuta despues de que se haya inyectado la dependencia
  public void inicializar() {
    cliente.setNombre(cliente.getNombre().concat(" ").concat("Alba"));
    descripcion = descripcion.concat(" del cliente: ").concat(cliente.getNombre());
  }

  @PreDestroy // Cuando destruimos el componente
  public void destruir() {
    System.out.println("Factura destruida ".concat(descripcion));
  }

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public Cliente getCliente() {
    return cliente;
  }

  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }

  public List<ItemFactura> getItems() {
    return items;
  }

  public void setItems(List<ItemFactura> items) {
    this.items = items;
  }

}
