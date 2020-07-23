package jwd;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jwd.model.Banka;
import jwd.model.Racun;
import jwd.model.TipRacuna;
import jwd.service.BankaService;
import jwd.service.RacunService;
import jwd.service.TipRacunaService;


@Component
public class TestData {

	@Autowired
	private TipRacunaService ts;
	
	@Autowired
	private RacunService rs;
	
	@Autowired
	private BankaService bs;
	
	@PostConstruct
	public void init() {
		
		
		Banka q = new Banka("Komercijalna", 3000);
		Banka w = new Banka("Agro", 256);
		
		TipRacuna a = new TipRacuna("tip1", 12, q);
		TipRacuna s = new TipRacuna("tip2", 15, w);
		TipRacuna d = new TipRacuna("tip3", 20, w);
		
		Racun z = new Racun("Janko", "12546", 111, 300, a, q);
		Racun x = new Racun("Marko", "365", 222, 500, s, w);
		Racun c = new Racun("Zika", "7995", 333, 600, d, w);
		
		bs.save(q);
		bs.save(w);
		
		ts.save(a);
		ts.save(s);
		ts.save(d);
		
		rs.save(z);
		rs.save(x);
		rs.save(c);
	}
}
