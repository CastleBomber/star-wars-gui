package sample;
import java.sql.Connection;
import java.sql.DriverManager;


public class DatabaseConnection {
    public Connection databaseLink = null; /////

    public Connection getConnection(){
        String databaseName = "saleco";
        String databaseUser = "root";
        String databasePassword = "dB420$?CX";
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/" + databaseName;

        try{
            Class.forName(driver);
            databaseLink = DriverManager.getConnection(url, databaseUser, databasePassword);
        } catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }

        return databaseLink;
    }
}