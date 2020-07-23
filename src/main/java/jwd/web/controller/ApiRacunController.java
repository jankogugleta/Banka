package jwd.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jwd.model.Racun;
import jwd.service.RacunService;
import jwd.support.DtoToRacun;
import jwd.support.RacunToDto;
import jwd.web.dto.RacunDto;

@RestController
@RequestMapping(value = "/api/racuni")
public class ApiRacunController {

	@Autowired
	private RacunToDto toDto;
	@Autowired
	private DtoToRacun toRacun;
	@Autowired
	private RacunService rs;
	
	//*****GETALL*****
		@RequestMapping(method=RequestMethod.GET)
		ResponseEntity<List<RacunDto>> getAll(
				@RequestParam(required=false) String jmbg,
				@RequestParam(required=false) Long bankaId,
				@RequestParam(value="pageNum", defaultValue="0") int pageNum){
			
			Page<Racun> page = null;
			System.out.println( jmbg  + "    " + bankaId);
			
			if(jmbg != null || bankaId != null ) {
				page = rs.search(jmbg, bankaId, pageNum);
			}
			else {
			page = rs.findAll(pageNum);
			}

			HttpHeaders headers = new HttpHeaders();
			headers.add("totalPages", Integer.toString(page.getTotalPages()) );
			
			return new ResponseEntity<>(
					toDto.convert(page.getContent()),
					headers,
					HttpStatus.OK);
		}


	//*****GETONE*****
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
		ResponseEntity<RacunDto> getOne(@PathVariable Long id){
			Racun f = rs.findOne(id);
			if (f == null) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			
			return new ResponseEntity<>(toDto.convert(f),HttpStatus.OK);
			
		}

	//*****ADD*****
	
	@RequestMapping(method = RequestMethod.POST)
		ResponseEntity<RacunDto> add(@RequestBody RacunDto novi){
			
			Racun f = rs.save(toRacun.convert(novi));
			
			return new ResponseEntity<>(toDto.convert(f),HttpStatus.CREATED);
			
		}
	
	//*****Nalog za prenos*****
	@RequestMapping(value = "/nalog", method = RequestMethod.GET)
		ResponseEntity<Boolean> nalog(@RequestParam(required = false) Integer uplatioc,
									  @RequestParam(required = false) Integer primaoc,
									  @RequestParam(required = false) Double iznos) {
	
			boolean uspeh = rs.nalog(uplatioc, primaoc, iznos);
				
			if (uspeh == false) {
				return new ResponseEntity<Boolean>(HttpStatus.BAD_REQUEST);
			} else {
				return new ResponseEntity<Boolean>(HttpStatus.OK);
			}	
		}	
					
	//*****EDIT*****
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
		ResponseEntity<RacunDto> edit(@RequestBody RacunDto eddited,
										 @PathVariable Long id){
			
			if (id == null || !id.equals(eddited.getId())) {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
			
			Racun persisted = rs.save(toRacun.convert(eddited));
			
				return new ResponseEntity<>(toDto.convert(persisted), HttpStatus.OK);
		}


	//*****DELETE*****
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
		ResponseEntity<RacunDto> delete(@PathVariable Long id){
			
			rs.delete(id);
			
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			
		}

	//*****EXCEPTIONHANDLER*****

	@ExceptionHandler(DataIntegrityViolationException.class)
		public ResponseEntity<Void> handle() {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
}
