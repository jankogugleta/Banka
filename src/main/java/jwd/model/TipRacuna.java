package jwd.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class TipRacuna {
	@Id
	@GeneratedValue
	@Column
	private Long id;
	@Column(unique = true, nullable = false)
	private String naziv;
	@Column
	private double provizija;
	@ManyToOne
	private Banka banka;
	@OneToMany(mappedBy = "tipRacuna")
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
	public double getProvizija() {
		return provizija;
	}
	public void setProvizija(double provizija) {
		this.provizija = provizija;
	}
	public Banka getBanka() {
		return banka;
	}
	public void setBanka(Banka banka) {
		this.banka = banka;
		if (!banka.getTipovi().contains(this)) {
			banka.getTipovi().add(this);
			
		}
	}
	public List<Racun> getRacuni() {
		return racuni;
	}
	public void setRacuni(List<Racun> racuni) {
		this.racuni = racuni;
	}
	public void addRacun(Racun racun) {
		this.racuni.add(racun);
		if (!racun.getTipRacuna().equals(this)) {
			racun.setTipRacuna(this);
		}
	}
	public TipRacuna() {
		super();
	}
	public TipRacuna(String naziv, double provizija, Banka banka) {
		super();
		this.naziv = naziv;
		this.provizija = provizija;
		this.banka = banka;
	}
	
}
