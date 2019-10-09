package co.com.projectcitas.daos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.com.projectcitas.entitys.Pacientes;

@Repository
public interface PacientesDao extends CrudRepository<Pacientes, String>{

}
