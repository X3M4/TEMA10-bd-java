package ejercicio1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class ejercicio1 {
	
	public static Connection c;
	
	public static Connection conectaMySQL(String host, String puerto, String bd, String user, String password) throws ClassNotFoundException {
		String url = "jdbc:mysql://" + host + ":" + puerto + "/" + bd + "?serverTimezone=UTC";
		
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
		Scanner sc = new Scanner(System.in);
		System.out.println("Escribe el host, el puerto, el nombre de la BD, el ususario root y la contraseña");
		String host = sc.next();
		String puerto = sc.next();
		String bd = sc.next();
		String user = sc.next();
		String pass = sc.next();
		
		try {
			Connection c = conectaMySQL(host, puerto, bd, user, pass);
			desconectaMySQL(c);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
