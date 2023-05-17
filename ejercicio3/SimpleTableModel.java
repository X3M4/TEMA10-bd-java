package ejercicio3;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class SimpleTableModel {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }

    private static void createAndShowGUI() {
        JFrame ventana = new JFrame();
        ventana.setBounds(400, 400, 500, 400);

        JTable tabla = createTable();
        JScrollPane panel = new JScrollPane(tabla);
        ventana.getContentPane().add(panel);

        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);
    }

    private static JTable createTable() {
        Object[][] data = {
            { "ALBERTO", "APARICIO VILA", 28, "BASKET", null },
            { "JUAN", "LOPEZ APARICIO", 34, "FUTBOL", true },
            { "MARIA", "GARCIA PALOP", 36, "AJEDREZ", true },
            { "DOLORES", "FUERTES DE BARRIGA", 28, "FUTBOL", null }
        };

        String[] columnNames = {
            "Nombre", "Apellidos", "Edad", "Deporte", "Vegetariano"
        };

        DefaultTableModel model = new DefaultTableModel(data, columnNames) {
            Class<?>[] columnTypes = {
                String.class, String.class, Integer.class, String.class, Boolean.class
            };

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return columnTypes[columnIndex];
            }
        };

        return new JTable(model);
    }
}
