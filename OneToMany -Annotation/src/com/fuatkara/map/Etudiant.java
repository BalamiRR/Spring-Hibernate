package com.fuatkara.map;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "etudiant", catalog = "postgres")
public class Etudiant implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Etudiant_ID", unique = true, nullable = false)
	private Integer etudiantId;
	
	@Column(name = "Etudiant_Nom", nullable = false, length = 50)
	private String etudiantNom;
	
	@Column(name = "Etudiant_NomdeFamille", nullable = false, length = 50)
	private String etudiantNomdeFamille;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "etudiant")
	private Set<Faculte> faculte = new HashSet<Faculte>(0);

	
	public Etudiant() {
		super();
	}

	public Integer getEtudiantId() {
		return etudiantId;
	}
	
	public void setEtudiantId(Integer etudiantId) {
		this.etudiantId = etudiantId;
	}
	
	public String getEtudiantNom() {
		return etudiantNom;
	}
	
	public void setEtudiantNom(String etudiantNom) {
		this.etudiantNom = etudiantNom;
	}
	
	public String getEtudiantNomdeFamille() {
		return etudiantNomdeFamille;
	}
	
	public void setEtudiantNomdeFamille(String etudiantNomdeFamille) {
		this.etudiantNomdeFamille = etudiantNomdeFamille;
	}
	
	public Set<Faculte> getFaculte() {
		return faculte;
	}

	public void setFaculte(Set<Faculte> faculte) {
		this.faculte = faculte;
	}
	
	public Etudiant(String etudiantNom, String etudiantNomdeFamille) {
		super();
		this.etudiantNom = etudiantNom;
		this.etudiantNomdeFamille = etudiantNomdeFamille;
	}
	
	public Etudiant(String etudiantNom, String etudiantNomdeFamille, Set<Faculte> faculte) {
		super();
		this.etudiantNom = etudiantNom;
		this.etudiantNomdeFamille = etudiantNomdeFamille;
		this.faculte = faculte;
	}

	@Override
	public String toString() {
		return "Etudiant [etudiantId=" + etudiantId + ", etudiantNom=" + etudiantNom + ", etudiantNomdeFamille="
				+ etudiantNomdeFamille + "]";
	}
}
