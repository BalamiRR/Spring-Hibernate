package com.fuatkara.map;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name ="faculte", catalog = "postgres")
public class Faculte implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Faculte_Id", unique = true, nullable = false)
	private Integer FaculteId;
	
	@Column(name = "Faculte_Nom", nullable = false, length = 50)
	private String FaculteNom;
	
	@Column(name = "Faculte_Adresse", nullable = false, length = 50)
	private String FaculteAdresse;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Etudiant_ID", nullable = false)
	private Etudiant etudiant;

	
	public Faculte() {
	
	}

	public Faculte(String faculteNom, String faculteAdresse) {
		
		this.FaculteNom = faculteNom;
		this.FaculteAdresse = faculteAdresse;
	}
	
	public Faculte(String faculteNom, String faculteAdresse, Etudiant etudiant) {
		
		this.FaculteNom = faculteNom;
		this.FaculteAdresse = faculteAdresse;
		this.etudiant = etudiant;
	}

	public Integer getFaculteId() {
		return FaculteId;
	}

	public void setFaculteId(Integer faculteId) {
		this.FaculteId = faculteId;
	}

	public String getFaculteNom() {
		return FaculteNom;
	}

	public void setFaculteNom(String faculteNom) {
		this.FaculteNom = faculteNom;
	}

	public String getFaculteAdresse() {
		return FaculteAdresse;
	}

	public void setFaculteAdresse(String faculteAdresse) {
		this.FaculteAdresse = faculteAdresse;
	}

	public Etudiant getEtudiant() {
		return etudiant;
	}

	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}

	@Override
	public String toString() {
		return "Faculte [FaculteId=" + FaculteId + ", FaculteNom=" + FaculteNom + ", FaculteAdresse=" + FaculteAdresse
				+ ", etudiant=" + etudiant + "]";
	}
}