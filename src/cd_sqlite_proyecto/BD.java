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

        //ALMACENAMOS EN UNA VARIABLE STRING LA RUTA DONDE SE CREARÁ LA BD
        String url = "jdbc:sqlite:/home/local/DANIELCASTELAO/lvaqueiroperez/CLASE/NetBeansProjects/Boletines_Progra/TRABAJO_ManualSQL/" + bdName;
        //NOS CONECTAMOS AL DRIVER Y LA CREAMOS
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

}
