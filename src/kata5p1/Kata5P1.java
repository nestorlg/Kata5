package kata5p1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Kata5P1 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
        Class.forName("org.sqlite.JDBC");
        String urlConection = "jdbc:sqlite:KATA5.db";
        Connection connection =DriverManager.getConnection(urlConection);
        
        Statement statement = connection.createStatement();
        String query = "CREATE TABLE IF NOT EXISTS MAIL2 ('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'mail' TEXT NOT NULL)";
        
        statement.execute(query);

        BufferedReader reader = new BufferedReader(new FileReader(new File ("emails.txt")));
        String mail;
        
        while ((mail = reader.readLine()) != null) {
            if (!mail.contains("@")) continue;
            query = "INSERT INTO MAIL2 (mail) VALUES ('" + mail + "')";
               statement.executeUpdate(query);
        }
    }
    
}
