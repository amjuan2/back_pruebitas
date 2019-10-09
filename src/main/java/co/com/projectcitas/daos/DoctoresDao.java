package co.com.projectcitas.daos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.com.projectcitas.entitys.Doctores;

@Repository
public interface DoctoresDao extends CrudRepository<Doctores, String>{

}
