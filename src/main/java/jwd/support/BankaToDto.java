package jwd.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import jwd.model.Banka;
import jwd.web.dto.BankaDto;

@Component
public class BankaToDto implements Converter<Banka, BankaDto>{

	@Override
	public BankaDto convert(Banka source) {
		BankaDto ret = new BankaDto();
		
		BeanUtils.copyProperties(source, ret);
		return ret;
	}
	
	public List<BankaDto> convert(List<Banka> source){
		List<BankaDto> ret = new ArrayList<BankaDto>();
		for (Banka banka : source) {
			ret.add(convert(banka));
		}
		return ret;
	}
}
