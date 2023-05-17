package ejercicio2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.*;

public class Ventana {
	
	public Connection c;

	public Ventana() {

		inicio();
	}
	//ENTORNO GRÁFICO
	public void inicio() {
		JFrame panel = new JFrame();
		panel.setBounds(400, 400, 500, 400);
		panel.setVisible(true);
		panel.getContentPane().setLayout(null);

		JTextField host = new JTextField();
		host.setBounds(100, 10, 110, 40);
		panel.add(host);

		JLabel lhost = new JLabel("HOST");
		lhost.setBounds(20, 10, 90, 40);
		panel.add(lhost);

		JTextField puerto = new JTextField(4);
		puerto.setBounds(100, 60, 110, 40);
		panel.add(puerto);

		JLabel lpuerto = new JLabel("PUERTO");
		lpuerto.setBounds(20, 60, 90, 40);
		panel.add(lpuerto);

		JTextField bd = new JTextField();
		bd.setBounds(100, 110, 110, 40);
		panel.add(bd);

		JLabel lbd = new JLabel("BD");
		lbd.setBounds(20, 110, 90, 40);
		panel.add(lbd);

		JTextField user = new JTextField();
		user.setBounds(100, 160, 110, 40);
		panel.add(user);

		JLabel luser = new JLabel("USER");
		luser.setBounds(20, 160, 90, 40);
		panel.add(luser);

		JPasswordField pass = new JPasswordField();
		pass.setBounds(100, 210, 110, 40);
		panel.add(pass);

		JLabel lpass = new JLabel("CONTRASEÑA");
		lpass.setBounds(20, 210, 90, 40);
		panel.add(lpass);

		JButton bconecta = new JButton("CONECTA BD");
		bconecta.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String url = "jdbc:mysql://" + host.getText() + ":" + puerto.getText() + 
						"/" + bd.getText() + "?serverTimezone=UTC";
				conectaMySQL(url, user.getText(), pass.getPassword());
			}

			private Connection conectaMySQL(String url, String text, char[] password) {
				// TODO Auto-generated method stub
				String pass = new String(password);
				try {
					c = DriverManager.getConnection(url, user.getText(), pass);
					System.out.println("Conexión establecida con la BD...");
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return c;
			}

			
			
		});
		bconecta.setBounds(250, 10, 200, 40);
		panel.add(bconecta);

		JButton bdescon = new JButton("DESCONECTA BD");
		bdescon.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				desconectaMySQL(c);
			}

			private boolean desconectaMySQL(Connection c) {
				// TODO Auto-generated method stub
				try {
					c.close();
					System.out.println("base de datos desconectada...");
				} catch (SQLException e) {
					e.printStackTrace();
				}

				return true;
			}
			
		});
		bdescon.setBounds(250, 60, 200, 40);
		panel.add(bdescon);
	}
}
