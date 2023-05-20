package e9;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ejercicio9 {
	
	static Connection c = null;
	static Statement st = null;
	static ResultSet rs = null;
	
	public static Connection conectaDb(String url, String user, String pass) {
		try {
			c = DriverManager.getConnection(url, user, pass);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return c;
	}
	
	public static void recuperaDatos(Connection c) {
		
		String sql = "select id, Apellidos from empleados";
		int id = 0;
		String apellido = null;
		try {
			st = c.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				id = rs.getInt("id");
				apellido = rs.getString("Apellidos");
				
				if(apellido == null) {
					System.out.printf("El apellido del id %d es NULL", id);
				}else {
					System.out.printf("ID: %d - Apellido: %s\n", id, apellido);
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public static void main (String[] args) {
		String url = "jdbc:mysql://localhost:3306/prueba?serverTimezone=UTC";
		
		Connection c = conectaDb(url, "root", "orxata");
		recuperaDatos(c);
	}
}
