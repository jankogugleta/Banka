package jwd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jwd.model.Banka;
import jwd.repository.BankaRepository;
import jwd.service.BankaService;

@Service
public class JpaBankaService implements BankaService{


	@Autowired
	private BankaRepository br;
	
	@Override
	public Banka findOne(Long id) {
		return br.findOne(id);
	}

	@Override
	public List<Banka> findAll() {
		return br.findAll();
	}

	@Override
	public Banka save(Banka banka) {
		return br.save(banka);
	}

}
