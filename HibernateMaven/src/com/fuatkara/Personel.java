package com.fuatkara;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "databasepersonel")
public class Personel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int personelId;
	
	@Column(name ="personelName")
	private String personelName;
	
	@Column(name = "personelSurname")
	private String personelSurname;
	
	@Column(name = "eposta")
	private String personelEmail;

	public Personel() {
		super();
	}

	public Personel(int personelId, String personelName, String personelSurname, String personelEmail) {
		super();
		this.personelId = personelId;
		this.personelName = personelName;
		this.personelSurname = personelSurname;
		this.personelEmail = personelEmail;
	}

	public int getPersonelId() {
		return personelId;
	}
	public void setPersonelId(int personelId) {
		this.personelId = personelId;
	}
	
	public String getPersonelName() {
		return personelName;
	}
	public void setPersonelName(String personelName) {
		this.personelName = personelName;
	}
	
	public String getPersonelSurname() {
		return personelSurname;
	}
	public void setPersonelSurname(String personelSurname) {
		this.personelSurname = personelSurname;
	}
	
	public String getPersonelEmail() {
		return personelEmail;
	}
	public void setPersonelEmail(String personelEmail) {
		this.personelEmail = personelEmail;
	}
	
	@Override
	public String toString() {
		return "Personel [personelId=" + personelId + ", personelName=" + personelName + ", personelSurname="
				+ personelSurname + ", personelEmail=" + personelEmail + "]";
	}

}
