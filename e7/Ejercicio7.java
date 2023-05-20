package e7;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Ejercicio7 {

	public static boolean soportaTransacciones(Connection c) throws SQLException {
		if (c == null) return false;
		DatabaseMetaData dbMD = c.getMetaData();
		if (dbMD == null)
			return false; // no soporta metadata
		return dbMD.supportsTransactions();

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Escribe el nombre del host");
		String host = sc.next();
		System.out.println("Escribe el nombre del puerto");
		String puerto = sc.next();
		System.out.println("Escribe el nombre de la base de datos");
		String bd = sc.next();
		
		String url = "jdbc:mysql://" + host + ":" + puerto + "/" + bd;
		
		Connection c = null;
		try {
			c = DriverManager.getConnection(url, "root", "131106");
			System.out.println("Soporta transacciones: " + soportaTransacciones(c));
		}catch(Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

}
