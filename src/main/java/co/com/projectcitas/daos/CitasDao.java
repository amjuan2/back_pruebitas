package co.com.projectcitas.daos;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.com.projectcitas.entitys.Citas;

@Repository
public interface CitasDao extends CrudRepository<Citas, String>{
	
	@Query(value="SELECT c.hora FROM CITAS c WHERE c.fecha= :fecha AND c.doctor= :id", nativeQuery=true)
	public List<String> find(@Param("fecha") String fecha, @Param("id") String id);
	
	@Query(value="SELECT c.NOMBRE FROM CUARTOS c INNER JOIN CITAS d ON c.id= d.cuarto WHERE d.fecha= :fecha AND d.hora= :cuarto", nativeQuery=true)
	public List<String> findCua(@Param("fecha") String fecha, @Param("cuarto") String cuarto);	
	
}
