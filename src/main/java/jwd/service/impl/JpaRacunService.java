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
	
	@Autowired
	private JpaBankaService bs;
	
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
	public boolean nalog(Integer uplatioc, Integer primaoc, Double iznos) {
		boolean uspeh = false;
		Racun racunUplatioca = null;
		Racun racunPrimaoca = null;
		
		if(rr.findByBrojRacuna(uplatioc) != null) {
			racunUplatioca  = rr.findByBrojRacuna(uplatioc);
		}
		if(rr.findByBrojRacuna(primaoc) != null) {
			racunPrimaoca  = rr.findByBrojRacuna(primaoc);
		}
		if (racunPrimaoca== null || racunUplatioca== null) {
			return uspeh;
		}
		System.out.println("-----");
		System.out.println(racunUplatioca.getStanje());
		System.out.println(racunPrimaoca.getStanje());
		System.out.println("-----");
		
		Double kamata = racunUplatioca.getTipRacuna().getProvizija()/100 * iznos;
		double ukupnaCena = iznos + kamata;
		
		if (racunUplatioca.getStanje() > ukupnaCena) {
			double novoStanje;
			racunUplatioca.setStanje(racunUplatioca.getStanje() - ukupnaCena);
			save(racunUplatioca);
			
			racunPrimaoca.setStanje(racunPrimaoca.getStanje() + iznos);
			save(racunPrimaoca);
			
			Banka bankaUplatioca = bs.findOne(racunUplatioca.getBanka().getId());
			bankaUplatioca.setSredstvaBanke(bankaUplatioca.getSredstvaBanke() + kamata);
			bs.save(bankaUplatioca);
			
			uspeh = true;
			return uspeh;
		}
		
		return uspeh;
	}

}
