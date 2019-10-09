package co.com.projectcitas.daos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.com.projectcitas.entitys.Cuartos;

@Repository
public interface CuartosDao extends CrudRepository<Cuartos, String>{

}
