package co.com.projectcitas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.projectcitas.daos.CuartosDao;
import co.com.projectcitas.entitys.Cuartos;

@Service
public class CuartosService {
	
	@Autowired
	private CuartosDao dao;
	
	public List<Cuartos> listar(){
		return (List<Cuartos>) dao.findAll();
	}
}
