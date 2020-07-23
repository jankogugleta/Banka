package jwd.web.dto;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

public class RacunDto {

	private Long id;
	private String imePrezime;
	@Length(max = 13)
	private String jmbg;
	@NotBlank
	private int brojRacuna;
	private double stanje;
	private Long tipRacunaId;
	private String tipRacunaNaziv;
	private Long bankaId;
	private String bankaNaziv;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getImePrezime() {
		return imePrezime;
	}
	public void setImePrezime(String imePrezime) {
		this.imePrezime = imePrezime;
	}
	public String getJmbg() {
		return jmbg;
	}
	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}
	public int getBrojRacuna() {
		return brojRacuna;
	}
	public void setBrojRacuna(int brojRacuna) {
		this.brojRacuna = brojRacuna;
	}
	public double getStanje() {
		return stanje;
	}
	public void setStanje(double stanje) {
		this.stanje = stanje;
	}
	public Long getTipRacunaId() {
		return tipRacunaId;
	}
	public void setTipRacunaId(Long tipRacunaId) {
		this.tipRacunaId = tipRacunaId;
	}
	public String getTipRacunaNaziv() {
		return tipRacunaNaziv;
	}
	public void setTipRacunaNaziv(String tipRacunaNaziv) {
		this.tipRacunaNaziv = tipRacunaNaziv;
	}
	public Long getBankaId() {
		return bankaId;
	}
	public void setBankaId(Long bankaId) {
		this.bankaId = bankaId;
	}
	public String getBankaNaziv() {
		return bankaNaziv;
	}
	public void setBankaNaziv(String bankaNaziv) {
		this.bankaNaziv = bankaNaziv;
	}
	
}
