package com.fuatkara.map;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.fuatkara.util.HibernateUtil;

public class ApplicationMain {
	public static void main(String args[]) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		
		try{
			transaction = session.beginTransaction();
			
			Etudiant etudiant = new Etudiant();
			etudiant.setEtudiantNom("Neo");
			etudiant.setEtudiantNomdeFamille("Thomas");
			session.save(etudiant);
			
			Faculte faculte = new Faculte();
			faculte.setFaculteNom("Matrix");
			faculte.setFaculteAdresse("Green Street");
			faculte.setEtudiant(etudiant);
			
			session.save(faculte);
			session.getTransaction().commit();
			System.out.println("Saved all");
			
//			session.save(faculte);
//			transaction.commit();
//			
//			System.out.println("Saved all");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
		}
	}
}
