package e6;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.DriverPropertyInfo;
import java.sql.SQLException;

public class Ejercicio6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url = "jdbc:mysql://localhost:3306/prueba";
		DriverPropertyInfo[] dpi = null;
		StringBuilder sb = new StringBuilder();
		
		try {
			Driver driver = DriverManager.getDriver(url);
			
			if(driver != null) {
				dpi = driver.getPropertyInfo(url, null);
				
				
				sb.append("--- driver Propiedades Info\n");
				sb.append("<?xml version='1.0'>\n");
				sb.append("<PopiedadesDriver driver = \"com.mysql.cj.jdbc.Driver\" url = \"jdbc:mysql://localhost/prueba\">\n");
				
				for(DriverPropertyInfo d: dpi) {
					sb.append("<PropiedadDriver>\n");
					sb.append("<name>").append(d.name).append("</name>\n");
					sb.append("<required>").append(d.required).append("</required>\n");
					sb.append("<value>").append(d.value).append("</value>\n");
					sb.append("<description>").append(d.description).append("</description>\n");
					sb.append("<opciones>\n").append("</opciones>\n");
					sb.append("</PropiedadDriver>\n");
				}
				
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		System.out.println(sb.toString());
		
	}

}
