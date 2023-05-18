package e5;

import java.sql.Statement;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Ejercicio5 {
	
	public static Connection c;
	public static Statement stmt = null;
	public static ResultSet rs = null;
	
	public static Connection conectaMySQL(String url, String user, String password) throws ClassNotFoundException {
		
		try {
			c = DriverManager.getConnection(url, user, password);
			
			//EJERCICIO 4
			Scanner sc = new Scanner(System.in);
			System.out.println("Escribe la cantidad de salario a filtrar:\n");
			Double svalor = null;
			try {
				svalor = sc.nextDouble();
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
			
			System.out.println("Conexión establecida con la BD...");
			stmt = c.createStatement();
			//EJERCICIO 5: FILTRO POR SALARIO EN LA CONSULTA
			String sql = "select * from empleados where Salario > " + svalor;
			rs = stmt.executeQuery(sql);
			//VARIABLES
			int id;
			String nombre;
			String apellido;
			String puesto;
			double salario;
			
			while(rs.next()) {
				id = rs.getInt("id");
				nombre = rs.getString("Nombre");
				apellido = rs.getString("Apellidos");
				puesto = rs.getString("Cargo");
				salario = rs.getDouble("Salario");
				
				System.out.printf("ID: %s - Nombre: %s - Apellidos: %s - Cargo: %s - Salario: %1.2f€\n",
						id, nombre, apellido, puesto, salario);
			}
			
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
		String pass = "orxata";
		
		try {
			Connection c = conectaMySQL(url, user, pass);
			desconectaMySQL(c);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
