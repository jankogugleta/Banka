package jwd.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import jwd.model.Banka;
import jwd.model.Racun;
import jwd.model.TipRacuna;
import jwd.service.BankaService;
import jwd.service.RacunService;
import jwd.service.TipRacunaService;
import jwd.web.dto.RacunDto;

@Component
public class DtoToRacun implements Converter<RacunDto, Racun>{


	@Autowired
	private TipRacunaService trs;

	@Autowired
	private BankaService bs;

	@Autowired
	private RacunService rs;
	
	@Override
	public Racun convert(RacunDto source) {
		TipRacuna tip = trs.findOne(source.getTipRacunaId());
		Banka banka = bs.findOne(source.getBankaId());

		if (tip != null && banka!=null) {

			Racun racun = null;

			if (source.getId() != null) {
				racun = rs.findOne(source.getId());
			}else {
				racun = new Racun();
			}
			BeanUtils.copyProperties(source, racun);
			
			racun.setBanka(banka);
			racun.setTipRacuna(tip);
			return racun;
			
		}else {
			throw new IllegalStateException("Trying to attach to non-existant entities");
		}
	}
	 public List<Racun> convert(List<RacunDto> source){
		 List<Racun> ret = new ArrayList<Racun>();
		 for (RacunDto racunDto : source) {
			ret.add(convert(racunDto));
		}
		return ret;
	 }
	

}
