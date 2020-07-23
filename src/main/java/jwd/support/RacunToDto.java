package jwd.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import jwd.model.Racun;
import jwd.web.dto.RacunDto;

@Component
public class RacunToDto  implements Converter<Racun, RacunDto>{

	@Override
	public RacunDto convert(Racun source) {
		RacunDto ret = new RacunDto();
		
		BeanUtils.copyProperties(source, ret);
		ret.setBankaId(source.getBanka().getId());
		ret.setBankaNaziv(source.getBanka().getNaziv());
		ret.setTipRacunaId(source.getTipRacuna().getId());
		ret.setTipRacunaNaziv(source.getTipRacuna().getNaziv());
		
		return ret;
	}
	
	public List<RacunDto> convert(List<Racun> source){
		List<RacunDto> ret = new ArrayList<RacunDto>();
		for (Racun racun : source) {
			ret.add(convert(racun));
		}
		return ret;
	}

}
