package jwd.service;

import java.util.List;

import jwd.model.Banka;

public interface BankaService {

	Banka findOne(Long id);
	List<Banka> findAll();
	Banka save(Banka banka);
	
}
