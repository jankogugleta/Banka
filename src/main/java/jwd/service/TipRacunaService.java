package jwd.service;

import java.util.List;

import jwd.model.TipRacuna;

public interface TipRacunaService {

	TipRacuna findOne(Long id);
	List<TipRacuna> findAll();
	TipRacuna save(TipRacuna tipRacuna);
	List<TipRacuna> findByBankaId(Long id);
}
