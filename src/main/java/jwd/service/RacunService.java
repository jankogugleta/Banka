package jwd.service;

import org.springframework.data.domain.Page;

import jwd.model.Racun;

public interface RacunService {

	Racun findOne(Long id);
	Page<Racun> findAll(int page);
	Racun save(Racun racun);
	void delete(Long id);
	Page<Racun> search(String jmbg, Long bankaId, int pageNum);
	void nalog(Integer uplatioc, Integer primaoc, Double iznos);
}
