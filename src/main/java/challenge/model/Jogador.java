package challenge.model;

import java.math.BigDecimal;

public class Jogador {
	
	private String full_name;
	private String club;
	private String age;
	private String birth_date;
	private String nationality;
	private String eur_wage;
	private String eur_release_clause;
	
	private BigDecimal recisao;
	
	public BigDecimal getRecisao(String recisaoString) {
		return new BigDecimal(recisaoString);
	}
	
	public Jogador(){
		
	}
	
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getClub() {
		return club;
	}
	public void setClub(String club) {
		this.club = club;
	}
	public String getFull_name() {
		return full_name;
	}
	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}
	public String getEur_release_clause() {
		return eur_release_clause.isEmpty() ? "0" : eur_release_clause ;
	}
	public void setEur_release_clause(String eur_release_clause) {
		this.eur_release_clause = eur_release_clause;
	}
	public String getBirth_date() {
		return birth_date;
	}
	public void setBirth_date(String birth_date) {
		this.birth_date = birth_date;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getEur_wage() {
		return eur_wage;
	}
	public void setEur_wage(String eur_wage) {
		this.eur_wage = eur_wage;
	}



}
