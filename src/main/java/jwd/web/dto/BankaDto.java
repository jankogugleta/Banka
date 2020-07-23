package jwd.web.dto;

public class BankaDto {

	private Long id;
	private String naziv;
	private double sredstvaBanke;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public double getSredstvaBanke() {
		return sredstvaBanke;
	}
	public void setSredstvaBanke(double sredstvaBanke) {
		this.sredstvaBanke = sredstvaBanke;
	}
	
}
