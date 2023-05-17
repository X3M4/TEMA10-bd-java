package e1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Ejercicio1 {
public static Connection c;
	
	public static Connection conectaMySQL(String url, String user, String password) throws ClassNotFoundException {
	
		try {
			c = DriverManager.getConnection(url, user, password);
			System.out.println("Conexión establecida con la BD...");
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return c;
	}
	
	public static boolean desconectaMySQL(Connection c) {
		try {
			c.close();
			System.out.println("base de datos desconectada...");
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return true;
	}

	public static void main(String[] args) throws ClassNotFoundException {
		String url = "jdbc:mysql://localhost:3306/prueba?serverTimezone=UTC";
		String user = "root";
		String pass = "090584";
		
		try {
			Connection c = conectaMySQL(url, user, pass);
			desconectaMySQL(c);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
