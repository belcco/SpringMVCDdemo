package com.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.EstudianteDao;
import com.example.entities.Estudiante;

// Igual que @Repository es para que busque los beans, @Service es para que implemente los beans.
@Service
public class EstudianteServiceImpl implements EstudianteService {

    // Autowired hace que cuando haga falta usar la implementacion del servicio de estudiantes, 
    // se crea de manera automática un objeto del mismo tipo.
    // Spring inyecta un estudianteDao, lo que permite en el método findAll encontrar todos los estudiantes(*).

    @Autowired
    private EstudianteDao estudianteDao;


    @Override
    public List<Estudiante> findAll() {
        // TODO Auto-generated method stub
        
        //(*)
        return estudianteDao.findAll();
    }

    @Override
    public Estudiante findById(int idEstudiante) {
        // El método te devuelve un opcional de estudiante y para que te de el estudiante
        // tienes que añadir el get.
        return estudianteDao.findById(idEstudiante).get();
    }

    @Override
    public void save(Estudiante estudiante) {
        // TODO Auto-generated method stub
        estudianteDao.save(estudiante);

    }

    @Override
    public void deleteById(int idEstudiante) {
        // TODO Auto-generated method stub
        estudianteDao.deleteById(idEstudiante);
    }

    
    
}
