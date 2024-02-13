package test;
import dao.Connexion;
public class Test {
	public static void main(String []args) {
		Connexion cnx = new Connexion();
		cnx.connect();
	}
}
