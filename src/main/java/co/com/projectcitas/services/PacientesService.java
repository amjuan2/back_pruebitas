package co.com.projectcitas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.projectcitas.daos.PacientesDao;
import co.com.projectcitas.entitys.Pacientes;

@Service
public class PacientesService {
	
	@Autowired
	private PacientesDao dao;
	
	public List<Pacientes> listar(){
		return (List<Pacientes>) dao.findAll();
	}
	
	public Pacientes consultarPaciente(String c) {
		Optional<Pacientes> cre = dao.findById(c);
		if (cre.isPresent()) {
			return cre.get();
		} else {
			return null;
		}
	}
	
	public boolean insertarPaciente(Pacientes c) {
		Optional<Pacientes> cre = dao.findById(c.getId());
		if (cre.isPresent()) {
			return false;
		} else {
			dao.save(c);
			return true;
		}
	}

}
