package jwd.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import jwd.model.Banka;
import jwd.model.TipRacuna;
import jwd.service.BankaService;
import jwd.service.TipRacunaService;
import jwd.support.BankaToDto;
import jwd.support.TipRacunaToDto;
import jwd.web.dto.BankaDto;
import jwd.web.dto.TipRacunaDto;

@RestController
@RequestMapping(value = "/api/banke")
public class ApiBankaController {

	@Autowired
	private BankaToDto toDto;
	@Autowired
	private BankaService bs;
	@Autowired
	private TipRacunaService ts;
	@Autowired
	private TipRacunaToDto tipToDto;
	
	
	//*****GETALL List*****
	
	@RequestMapping(method=RequestMethod.GET)
			ResponseEntity<List<BankaDto>> getAll(){
				
				List<Banka> list = bs.findAll();
				
				return new ResponseEntity<>(
						toDto.convert(list), HttpStatus.OK);
			}
	
	//*****ById******
	@RequestMapping(value= "/{id}/tipovi", method=RequestMethod.GET)
				ResponseEntity<List<TipRacunaDto>> getById(
						@PathVariable Long id){
					
					List<TipRacuna> list = ts.findByBankaId(id);
					
					
					
					return new ResponseEntity<>(
							tipToDto.convert(list), 
							HttpStatus.OK);
			}
	
}
