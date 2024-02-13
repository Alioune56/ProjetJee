package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Connexion {
	// Parametre de l'utilisateur
	String url = "jdbc:mysql://localhost/projetjee";
	String username = "root";
	String pwd = "";
	
	Connection conn = null;
	public Statement st = null; 
	public void connect() {
		//  Charger la pilote jdbc
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		
		//  Etablir la connection
			conn = DriverManager.getConnection(url,username,pwd);
		
		// 	Creation du statement
			st = conn.createStatement();
			
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
