package co.com.projectcitas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.projectcitas.entitys.Doctores;
import co.com.projectcitas.services.DoctoresService;

@RestController
@RequestMapping("/doctores/")
@CrossOrigin("http://localhost:8082")
public class DoctoresController {
	
	@Autowired
	private DoctoresService service;
	
	@GetMapping("listar")
	public ResponseEntity<List<Doctores>> listar(){
		return new ResponseEntity<>(service.listar(), HttpStatus.OK);
	}
}
