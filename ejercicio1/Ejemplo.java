package ejercicio1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Ejemplo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Conectando con la Base de datos...");
		String url = "jdbc:mysql://localhost:3306/jardineria" + "?serverTimezone=UTC";
		System.out.println(url);
		String urd = "jdbc:mysql://localhost:3306/jardineria?serverTimezone=UTC";
		String urp = "jbdc:mysql://localhost:3306/jardineria?serverTimezone=UTC";// una opción
		String u = "root"; // usuario
		String p = "orxata"; // password
		try {
			Connection c = DriverManager.getConnection(url, u, p);
			System.out.println("Conexión establecida con la BD...");
			c.close();
			System.out.println("Conexión cerrada con la BD.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
