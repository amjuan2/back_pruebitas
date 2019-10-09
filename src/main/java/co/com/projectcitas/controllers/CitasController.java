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

import co.com.projectcitas.entitys.Citas;
import co.com.projectcitas.services.CitasService;

@RestController
@RequestMapping("/citas/")
@CrossOrigin("http://localhost:8082")
public class CitasController {

	@Autowired
	private CitasService service;

	@GetMapping("listar")
	public ResponseEntity<List<Citas>> listar() {
		return new ResponseEntity<>(service.listar(), HttpStatus.OK);
	}

	@GetMapping("disponibilidad/{fecha}/{hora}")
	public ResponseEntity<List<String>> consultarDisponibilidad(@PathVariable String fecha, @PathVariable String hora) {
		return new ResponseEntity<>(service.consultarDispo(fecha, hora), HttpStatus.OK);
	}

	@GetMapping("disponibilidadCua/{fecha}/{hora}")
	public ResponseEntity<List<String>> consultarDisponibilidad2(@PathVariable String fecha,
			@PathVariable String hora) {
		return new ResponseEntity<>(service.consultarDispo2(fecha, hora), HttpStatus.OK);
	}

	@GetMapping("consultar/{ci}")
	public ResponseEntity<Citas> consultarCita(@PathVariable String ci) {
		Citas c = service.consultarCita(ci);
		if (c == null) {
			return new ResponseEntity<>(c, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(c, HttpStatus.OK);
	}

	@PostMapping("insertarcita/{ci}")
	public ResponseEntity<?> insertCita(@PathVariable String ci)
			throws JsonMappingException, IOException, JsonParseException {
		Citas cre = new ObjectMapper().readValue(ci, Citas.class);
		if (service.insertarCita(cre)) {
			return new ResponseEntity<>(HttpStatus.UNAVAILABLE_FOR_LEGAL_REASONS);
		} else {
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}

	@PostMapping("actualizarcita/{ci}")
	public ResponseEntity<?> updateCita(@PathVariable String ci)
			throws JsonMappingException, IOException, JsonParseException {
		Citas cre = new ObjectMapper().readValue(ci, Citas.class);
		if (service.actualizarCita(cre)) {
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
