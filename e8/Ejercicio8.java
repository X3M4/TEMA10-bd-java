package e8;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.DatabaseMetaData;

public class Ejercicio8 {
	
	public static void main(String[] args) {
		
		Connection c = null;
		Statement st = null;
		try {
			String url = "jdbc:mysql://localhost:3306/prueba" + "?serverTimezone=UTC";
			c = DriverManager.getConnection(url, "root", "orxata");
			st = c.createStatement();
			//Obtenemos el máximo de filas intercambiadas con el servidor
			System.out.println("Maxímo de filas intercambiadas: " + st.getMaxRows());
			//Ponemos nuevo máximo
			st.setMaxRows(10);
			System.out.println("Nuevo maxímo de filas intercambiadas: " + st.getMaxRows());
			
		}catch(Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
		
	}
}
