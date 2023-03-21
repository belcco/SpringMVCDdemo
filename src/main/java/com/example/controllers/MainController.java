package com.example.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.entities.Estudiante;
import com.example.services.EstudianteService;





@Controller 
// El servlet que el servidor web esta esperando una peticion que termina en /, se relaciona a través de
// @RequestMapping, que manda todas las peticiones al handlermapping (manejadores) que son los métodos
// dentro del public class maincontroller
@RequestMapping("/")
public class MainController {

    @Autowired
    private EstudianteService estudianteService;
    /**
     * El siquiente método devuelve un listado de estudiantes. 
     * 
     */

     @GetMapping("/listar")

    public ModelAndView listar() {

        List<Estudiante> estudiantes = estudianteService.findAll();

    ModelAndView mav = new ModelAndView("views/listarEstudiantes");
        mav.addObject("estudiantes", estudiantes);

        return mav;
    }
    // El controlador (MainController) responde a una peticion (request) concreta y la delaga posteriormente
    // en un método que tiene en cuenta el verbo utilizado del protocolo http utilizado para realizar la peticion. 

    // Los verbos son las acciones (get, post, put, delete, opcion..) 

    /**
     *  Muestra el formulario de alta de estudiante
     */

     @GetMapping("/frmAltaEstudiante")
     public String formularioAltaEstudiante(Model model) {
        
        model.addAttribute("estudiante", new Estudiante());
        
        return "views/formularioAltaEstudiante";
     }
    
}
