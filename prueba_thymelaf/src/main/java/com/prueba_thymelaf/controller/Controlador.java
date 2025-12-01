package com.prueba_thymelaf.controller;

import com.prueba_thymelaf.Entidad.Producto;
import com.prueba_thymelaf.Servicio.Servicio;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Controller
public class Controlador {

    private Servicio servicio;

    public Controlador(Servicio servicio) {
        this.servicio = servicio;
    }


    @GetMapping ("/saluda")
    public String greeting(
            @RequestParam(required = false,defaultValue = "JuanK") String name, Model model
    ) {
        model.addAttribute("name", name);
        return "saludo";
    }

    @GetMapping("/productos")
    public String listarProductos(Model model) {
//        List<Producto> listaProductos = new ArrayList<Producto>();
//               Producto p1 = new Producto("Bizcocho", 2.99, "comida");
//               Producto p2 = new Producto("Pizza", 10.99, "comida");
//               Producto p3 = new Producto("Tortilla", 7.99, "comida");
//               listaProductos.add(p1);
//               listaProductos.add(p2);
//               listaProductos.add(p3);
       //model.addAttribute("listaProductos", listaProductos);
        model.addAttribute("listaProductos", servicio.obtenerProductos());
        return "lista";
    }

    @GetMapping("/productos/{id}")
    public String obtenerProducto(@PathVariable int id, Model model) {
        model.addAttribute("producto", servicio.obtenerProductoPorId(id));
        return "vistaProducto";
    }

}
