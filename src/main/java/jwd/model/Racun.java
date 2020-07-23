package jwd.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Racun {
	@Id
	@GeneratedValue
	@Column
	private Long id;
	@Column(nullable = false)
	private String imePrezime;
	@Column
	private String jmbg;
	@Column(unique = true)
	private int brojRacuna;
	@Column
	private double stanje;
	@ManyToOne
	private TipRacuna tipRacuna;
	@ManyToOne
	private Banka banka;
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
	public TipRacuna getTipRacuna() {
		return tipRacuna;
	}
	public void setTipRacuna(TipRacuna tipRacuna) {
		this.tipRacuna = tipRacuna;
		if (!tipRacuna.getRacuni().contains(this)) {
			tipRacuna.getRacuni().add(this);
		}
	}
	public Banka getBanka() {
		return banka;
	}
	public void setBanka(Banka banka) {
		this.banka = banka;
		if (!banka.getRacuni().contains(this)) {
			banka.getRacuni().add(this);
		}
	}
	public Racun() {
		super();
	}
	public Racun(String imePrezime, String jmbg, int brojRacuna, double stanje, TipRacuna tipRacuna, Banka banka) {
		super();
		this.imePrezime = imePrezime;
		this.jmbg = jmbg;
		this.brojRacuna = brojRacuna;
		this.stanje = stanje;
		this.tipRacuna = tipRacuna;
		this.banka = banka;
	}
	
	
}
