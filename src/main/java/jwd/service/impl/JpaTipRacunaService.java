package jwd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jwd.model.Banka;
import jwd.model.TipRacuna;
import jwd.repository.TipRacunaRepository;
import jwd.service.TipRacunaService;

@Service
public class JpaTipRacunaService implements TipRacunaService{


	@Autowired
	private TipRacunaRepository tr;
	
	@Override
	public TipRacuna findOne(Long id) {
		// TODO Auto-generated method stub
		return tr.findOne(id);
	}

	@Override
	public List<TipRacuna> findAll() {
		// TODO Auto-generated method stub
		return tr.findAll();
	}

	@Override
	public TipRacuna save(TipRacuna tipRacuna) {
		// TODO Auto-generated method stub
		return tr.save(tipRacuna);
	}

	@Override
	public List<TipRacuna> findByBankaId(Long id) {
		// TODO Auto-generated method stub
		return tr.findByBankaId(id);
	}

}
