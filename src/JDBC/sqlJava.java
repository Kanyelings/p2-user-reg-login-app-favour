package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;

public class sqlJava {

    private static Connection conn;

    static final String DB_URL = "jdbc:mysql://localhost:3306/login";

    public static Connection getConnection(){

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, "favour", "favour");
        }
        catch (Exception es){
            es.printStackTrace();
        }

        return conn;
    }
}
