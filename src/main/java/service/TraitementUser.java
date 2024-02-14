package service;

import java.sql.ResultSet;
import java.sql.SQLException;

import dao.Connexion;
import entity.User;

public class TraitementUser {
	ResultSet rs = null; 
	
	// 1.Ajouter un nouveau utilisateur
	public void Ajouter(User u) {
		
		// 1.Se connecter a la base de donnee
		Connexion cnx = new Connexion();
		cnx.connect();
		
		// 2.Requte sql
		String rec = "insert into User(prenom,nom,email,password) values('"+u.getPrenom()+"','"+u.getNom()+"','"+u.getEmail()+"','"+u.getPassword()+"')";
		
		// 3.Statement
		try {
			cnx.st.executeUpdate(rec);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// 2.Se connecter a partir d'un utilisateur deja ajoute
	public User TestLogin(String email,String password) {
		
		User u = null;
		
		// 1.Se connecter a la base de donnee
		Connexion cnx = new Connexion();
		cnx.connect();
		
		// 2.Requete sql
		String rec = "Select * from User where email='"+email+"' and password='"+password+"'";
		
		// 3.Statement
		try {
			rs=cnx.st.executeQuery(rec);
			while(rs.next()) {
				int id = rs.getInt("id");
				String prenom = rs.getString("prenom");
				String nom = rs.getString("nom");
				String mail= rs.getString("email");
				String pass = rs.getString("password");
				 u = new User(id,prenom,nom,email,password);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u;
		
	}
	
	// 3.Modifier un utilisateur
	public void Modifier(User u) {
		// 1.Connexion Base de donnee
		Connexion cnx = new Connexion();
		cnx.connect();
		
		// 2.Requete sql
		String rec = "Update User set prenom='"+u.getPrenom()+"',nom='"+u.getNom()+"',email='"+u.getEmail()+"',password='"+u.getPassword()+"'"
				+ "where id="+u.getId()+"";
		
		// 3.Statement
		try {
			cnx.st.executeUpdate(rec);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//4.Supprimer un utilisateur
	public void Supprimer(int id) {
		// 1.Connexion Base de donnes
		Connexion cnx = new Connexion();
		cnx.connect();
		
		// 2.Requete sql
		String rec = "delete User where id = '"+id+"'";
		
		// 3.Statement
		try {
			cnx.st.executeUpdate(rec);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
