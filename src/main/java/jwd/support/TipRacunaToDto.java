package jwd.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import jwd.model.TipRacuna;
import jwd.web.dto.TipRacunaDto;

@Component
public class TipRacunaToDto implements Converter<TipRacuna, TipRacunaDto>{

	@Override
	public TipRacunaDto convert(TipRacuna source) {
		TipRacunaDto ret = new TipRacunaDto();
		
		BeanUtils.copyProperties(source, ret);
		ret.setBankaId(source.getBanka().getId());
		ret.setBankaNaziv(source.getBanka().getNaziv());
		return ret;
	}
	
	public List<TipRacunaDto> convert(List<TipRacuna> source) {
		List<TipRacunaDto> ret = new ArrayList<TipRacunaDto>();
		for (TipRacuna tipRacuna : source) {
			ret.add(convert(tipRacuna));
		}
		return ret;
	}

}
