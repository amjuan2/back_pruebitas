package co.com.projectcitas.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import co.com.projectcitas.entitys.Pacientes;
import co.com.projectcitas.services.PacientesService;

@RestController
@RequestMapping("/pacientes/")
@CrossOrigin("http://localhost:8082")
public class PacientesController {
	
	@Autowired
	private PacientesService service;
	
	@GetMapping("listar")
	public ResponseEntity<List<Pacientes>> listar(){
		return new ResponseEntity<>(service.listar(), HttpStatus.OK);
	}
	
	@GetMapping("consultarpaciente/{ci}")
	public ResponseEntity<Pacientes> consultarPaciente(@PathVariable String ci) {
		Pacientes c = service.consultarPaciente(ci);
		if (c == null) {
			return new ResponseEntity<>(c, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(c, HttpStatus.OK);
	}
	
	@PostMapping("insertarpaciente/{ci}")
	public ResponseEntity<?> insertPaciente(@PathVariable String ci) throws JsonMappingException, IOException , JsonParseException{
		Pacientes cre=new ObjectMapper().readValue(ci, Pacientes.class);
		if (service.insertarPaciente(cre)) {
			return new ResponseEntity<>(HttpStatus.UNAVAILABLE_FOR_LEGAL_REASONS);
		} else {
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
}
