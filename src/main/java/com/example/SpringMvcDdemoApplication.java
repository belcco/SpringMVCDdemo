package com.example;

import java.time.LocalDate;
import java.time.Month;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import com.example.entities.Estudiante;
import com.example.entities.Facultad;
import com.example.entities.Telefono;
import com.example.entities.Estudiante.Genero;
import com.example.services.EstudianteService;
import com.example.services.FacultadService;
import com.example.services.TelefonoService;

@SpringBootApplication
public class SpringMvcDdemoApplication implements CommandLineRunner{

	// @autowired es para inyectar una dependencia.

	@Autowired
	private FacultadService facultadService;

	@Autowired
	private EstudianteService estudianteService;

	@Autowired
	private TelefonoService telefonoService;



	public static void main(String[] args) {
		SpringApplication.run(SpringMvcDdemoApplication.class, args);
	}

	// Método para agragar un estudiante
	@Override
	public void run(String... args) throws Exception {

		/**
		 * Agregar registros de muestra, para Facultad, Estudiante y Teléfono.
		 */

		 facultadService.save(Facultad.builder().id(1)
		 .nombre("Informatica").build());

		 facultadService.save(Facultad.builder().id(2)
		 .nombre("Biologia").build());

		estudianteService.save(
			Estudiante.builder()
		.nombre("Belén").id(1)
		.primerApellido("Chocano")
		.segundoApellido("Collado")
		.fechaNacimiento(LocalDate.of(1997, Month.JANUARY, 9))
		.fechaAlta(LocalDate.of(2023, Month.JANUARY, 23))
		.genero(Genero.MUJER)
		.beca(6500.00)
		.facultad(facultadService.findById(1))
		.build());

		telefonoService.save(Telefono.builder()
		.Id(1)
		.numero("618845914")
		.estudiante(estudianteService.findById(1))
		.build());

		telefonoService.save(Telefono.builder()
		.Id(2)
		.numero("968502465")
		.estudiante(estudianteService.findById(1))
		.build());
	

	}

}

