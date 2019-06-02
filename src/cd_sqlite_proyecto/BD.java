package cd_sqlite_proyecto;

import java.sql.*;
import javax.swing.JOptionPane;

public class BD {

    public static String bdName;

    /**
     * Método para crear una nueva BD en el directorio especificado
     *
     * @param fileName El nombre de la BD que vamos a crear.
     */
    public static void createNewDatabase(String fileName) {

        bdName = fileName;

        String url = "jdbc:sqlite:/home/local/DANIELCASTELAO/lvaqueiroperez/CLASE/NetBeansProjects/Boletines_Progra/TRABAJO_ManualSQL/" + bdName;

        try (Connection conn = DriverManager.getConnection(url)) {

            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                JOptionPane.showMessageDialog(null, "BD Creada");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "ERROR al crear la BD, revisa las execepciones");
        }
    }

    public static String baseCon;

    /**
     * Método para conectarse a una BD de SQLite
     *
     * @param nombreConn El nombre de la BD a la que nos vamos a conectar.
     */
    public static void connect(String nombreBDCon) {

        baseCon = nombreBDCon;

        Connection conn = null;

        try {

            String url = "jdbc:sqlite:/home/local/DANIELCASTELAO/lvaqueiroperez/CLASE/NetBeansProjects/Boletines_Progra/TRABAJO_ManualSQL/" + baseCon;

            conn = DriverManager.getConnection(url);

            JOptionPane.showMessageDialog(null, "Conectado a la BD");

        } catch (SQLException e) {

            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Fallo en la conexión, asegúrate de poner bien el nombre de la BD");

        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

}
