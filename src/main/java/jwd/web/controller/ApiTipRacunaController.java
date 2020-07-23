package jwd.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import jwd.model.TipRacuna;
import jwd.service.TipRacunaService;
import jwd.support.TipRacunaToDto;
import jwd.web.dto.TipRacunaDto;

@RestController
@RequestMapping(value = "/api/tipovi")
public class ApiTipRacunaController {

	@Autowired
	private TipRacunaToDto toDto;
	@Autowired
	private TipRacunaService ts;
	
	//*****GETALL List*****
	
	@RequestMapping(method=RequestMethod.GET)
			ResponseEntity<List<TipRacunaDto>> getAll(){
				
				List<TipRacuna> list = ts.findAll();
				
				return new ResponseEntity<>(
						toDto.convert(list), HttpStatus.OK);
			}
	
}
