package e10;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class Ejercicio10 {
	
	public static String getNombreCols(ResultSet rs) {
		
		StringBuilder sb = new StringBuilder();
		ResultSetMetaData dsm;
		try {
			dsm = rs.getMetaData();
			sb.append("<NombreColumna>");
			
			for(int i = 1; i < dsm.getColumnCount()+1;i++) {
				sb.append(String.format("<columna = \"%s\" tabla = \"%s\">\n", 
						dsm.getColumnName(i), dsm.getTableName(i)));
			}
			
			sb.append("</NombreColumna>");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return sb.toString();
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url = "jdbc:mysql://localhost:3306/prueba?serverTimezone=UTC";
		String con = "select id, "
				+ "concat(Nombre, ' ', Apellidos) as nombre,"
				+ "Cargo,"
				+ "Salario from empleados";
		
		try {
			Connection c = DriverManager.getConnection(url, "root", "orxata");
			Statement stm = c.createStatement();
			ResultSet rs = stm.executeQuery(con);
			
			System.out.println(getNombreCols(rs));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
