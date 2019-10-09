package co.com.projectcitas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.projectcitas.daos.DoctoresDao;
import co.com.projectcitas.entitys.Doctores;

@Service
public class DoctoresService {
	
	@Autowired
	private DoctoresDao dao;
	
	public List<Doctores> listar(){
		return (List<Doctores>) dao.findAll();
	}
}
