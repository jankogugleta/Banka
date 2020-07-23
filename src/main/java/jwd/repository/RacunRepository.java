package jwd.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import jwd.model.Racun;

@Repository
public interface RacunRepository extends JpaRepository<Racun, Long>{

//	Page<Racun> search(String jmbg, Long bankaId, int pageNum);

	
	@Query("SELECT r FROM Racun r WHERE "
			+ "(:id IS NULL OR r.banka.id = :id) AND "
			+ "(:jmbg IS NULL or r.jmbg like :jmbg )"
			)
	Page<Racun> search(@Param("jmbg") String jmbg, 
						 @Param("id") Long id,
						  Pageable pageRequest);

	Racun findByBrojRacuna(int u);;

}
