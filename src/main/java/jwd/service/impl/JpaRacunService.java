package jwd.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import jwd.model.Banka;
import jwd.model.Racun;
import jwd.repository.RacunRepository;
import jwd.service.RacunService;

@Service
public class JpaRacunService implements RacunService{

	@Autowired
	private RacunRepository rr;
	
	@Override
	public Racun findOne(Long id) {
		// TODO Auto-generated method stub
		return rr.findOne(id);
	}

	@Override
	public Page<Racun> findAll(int page) {
		// TODO Auto-generated method stub
		return rr.findAll(new PageRequest(page, 5));
	}

	@Override
	public Racun save(Racun racun) {
		// TODO Auto-generated method stub
		return rr.save(racun);
	}

	@Override
	public void delete(Long id) {
		rr.delete(id);
		
	}

	@Override
	public Page<Racun> search(String jmbg, Long bankaId, int pageNum) {
		if (jmbg != null) {
			jmbg = "%" + jmbg + "%";
		}
		return rr.search(jmbg, bankaId, new PageRequest(pageNum, 5));
	}

	@Override
	public void nalog(Integer uplatioc, Integer primaoc, Double iznos) {
		Racun u = null;
		Racun p = null;
		
		if(rr.findByBrojRacuna(uplatioc) != null) {
			u  = rr.findByBrojRacuna(uplatioc);
		}
		if(rr.findByBrojRacuna(primaoc) != null) {
			p  = rr.findByBrojRacuna(primaoc);
		}
		
		//System.out.println(u.getId() + "    " + p.getImePrezime());
	}

}
