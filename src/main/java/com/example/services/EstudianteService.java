package com.example.services;

import java.util.List;

import com.example.entities.Estudiante;

public interface EstudianteService {

    public List<Estudiante> findAll();
    public Estudiante findById(int idEstudiante);
    public void save(Estudiante estudiante);
    public void deleteById(int idEstudiante);


    /**
     * No es necesario un método update, porque el save inserta o actualiza, en dependencia de que el 
     * idEstudiante exista o no, es decir, si no existe lo crea, y si existe lo actualiza.
     * 
     */
    
    
}
