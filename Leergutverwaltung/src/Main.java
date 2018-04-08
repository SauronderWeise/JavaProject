
import java.sql.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // createTable();
        getConnection();
    }
    
    

    public static void createTable() throws Exception {
        try {
            PreparedStatement create = null;
            Connection con = getConnection();

            create = con.prepareStatement(
                    "CREATE TABLE IF NOT EXISTS Kunden(Kundennummer int NOT NULL AUTO_INCREMENT, Vorname varchar(255), Nachname varchar(255), PRIMARY KEY(Kundennummer)) ");
            create.executeUpdate();

            create = con.prepareStatement(
                    "CREATE TABLE IF NOT EXISTS Mahnung(Mahnungsnummer int NOT NULL AUTO_INCREMENT, Datum String, PRIMARY KEY(Mahnungsnummer))");
            create.executeUpdate();
            
            

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            System.out.println("Function complete.");
        }
    }

    public static Connection getConnection() throws Exception {

        try {
            Connection conn = null;
            String driver = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/Leergutverwaltung?useSSL=false";
            String user = "Timm";
            String password = "18-19tus";

            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Worked so far.");
            return conn;
        } catch (Exception e) {
            System.out.println(e);
        }

        return null;

    }

    public static Connection getConnection2() throws Exception {

        try {
            Connection conn = null;
            String driver = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/data_pcgarten?useSSL=false";
            String user = "root";
            String password = "";

            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Worked so far.");
            return conn;
        } catch (Exception e) {
            System.out.println(e);
        }

        return null;

    }
}
