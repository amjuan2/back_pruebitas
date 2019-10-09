package co.com.projectcitas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.projectcitas.daos.CitasDao;
import co.com.projectcitas.entitys.Citas;

@Service
public class CitasService {
	
	@Autowired
	private CitasDao dao;
	
	public List<Citas> listar() {
		return (List<Citas>) dao.findAll();
	}

	public Citas consultarCita(String c) {
		Optional<Citas> cre = dao.findById(c);
		if (cre.isPresent()) {
			return cre.get();
		} else {
			return null;
		}
	}
	
	public boolean insertarCita(Citas c) {
		Optional<Citas> cre = dao.findById(c.getId());
		if (cre.isPresent()) {
			return false;
		} else {
			dao.save(c);
			return true;
		}
	}
	
	public boolean actualizarCita(Citas c) {
		Optional<Citas> cre = dao.findById(c.getId());		
		if (cre.isPresent()) {
			dao.save(c);
			return true;
		} else {
			return false;
		}
	}

	public List<String> consultarDispo(String fecha, String hora) {	
		return dao.find(fecha,hora);
	}
	
	public List<String> consultarDispo2(String fecha, String cuarto) {	
		return dao.findCua(fecha, cuarto);
	}

}
