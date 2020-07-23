package jwd.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Banka {
	@Id
	@GeneratedValue
	@Column
	private Long id;
	@Column(unique = true, nullable = false)
	private String naziv;
	@Column
	private double sredstvaBanke;
	@OneToMany(mappedBy = "banka")
	private List<TipRacuna> tipovi = new ArrayList<TipRacuna>();
	@OneToMany(mappedBy = "banka")
	private List<Racun> racuni = new ArrayList<Racun>();
	
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
	public List<TipRacuna> getTipovi() {
		return tipovi;
	}
	public void setTipovi(List<TipRacuna> tipovi) {
		this.tipovi = tipovi;
	}
	public List<Racun> getRacuni() {
		return racuni;
	}
	public void setRacuni(List<Racun> racuni) {
		this.racuni = racuni;
	}
	public void addTipRacuna(TipRacuna tipRacuna) {
		this.tipovi.add(tipRacuna);
		if (!tipRacuna.getBanka().equals(this)) {
			tipRacuna.setBanka(this);
		}
	}
	public void addRacun(Racun racun) {
		this.racuni.add(racun);
		if (!racun.getBanka().equals(this)) {
			racun.setBanka(this);
		}
		
	}
	public Banka() {
		super();
	}
	public Banka(String naziv, double sredstvaBanke) {
		super();
		this.naziv = naziv;
		this.sredstvaBanke = sredstvaBanke;
	}
	
}
