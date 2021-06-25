//Author: Julius
import java.sql.*;

public class Datenbankreiniger
{
    public void leeren(){
        datenbankinsert("DELETE * FROM multiplayer");
    }
    
    private void auslesne(){
        Connection verbindung = null;
        try {
            verbindung = DriverManager.getConnection("jdbc:mysql://srvxampp/q11wolfenstein", "q11wolfenstein", "abitur");
        } catch (SQLException e) {
            System.err.println("Datenbankfehler(Verbindungsaufbau): " + e);
            System.exit(0);
        }
        try {
            Statement st = verbindung.createStatement();
            st.executeUpdate("SELECT * FROM multiplayer");
            
            st.close();
        } catch (SQLException e) {
            System.out.println("Fehler beim Einfügen des Datensatzes: " + e);
            System.exit(0);
        }
        try {
            verbindung.close();
        } catch (SQLException e) {
            System.err.println("Fehler beim schließen der Verbindung:" + e);
            System.exit(0);
        }
    }
    
    private void datenbankinsert(String sql) {
        Connection verbindung = null;
        try {
            verbindung = DriverManager.getConnection("jdbc:mysql://srvxampp/q11wolfenstein", "q11wolfenstein", "abitur");
        } catch (SQLException e) {
            System.err.println("Datenbankfehler(Verbindungsaufbau): " + e);
            System.exit(0);
        }
        try {
            Statement st = verbindung.createStatement();
            st.executeUpdate(sql);
            st.close();
        } catch (SQLException e) {
            System.out.println("Fehler beim Einfügen des Datensatzes: " + e);
            System.exit(0);
        }
        try {
            verbindung.close();
        } catch (SQLException e) {
            System.err.println("Fehler beim schließen der Verbindung:" + e);
            System.exit(0);
        }
    }
}
