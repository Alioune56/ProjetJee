package entity;

public class User {
	int id;
	String prenom,nom,email,password;
	public User() {
		super();
	}
	public User(int id, String prenom, String nom, String email, String password) {
		super();
		this.id = id;
		this.prenom = prenom;
		this.nom = nom;
		this.email = email;
		this.password = password;
	}
	public User(String prenom, String nom, String email, String password) {
		super();
		this.prenom = prenom;
		this.nom = nom;
		this.email = email;
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
