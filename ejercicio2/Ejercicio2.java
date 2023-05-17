package ejercicio2;

import java.awt.EventQueue;

import javax.swing.*;

public class Ejercicio2 {
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					Ventana v = new Ventana();
				}catch(Exception e) {
					e.getMessage();
				}
			}
			
		});
	}
}
