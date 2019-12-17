package data;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLlite 
{
	private static String url;
    public static void createNewDatabase(String fileName) {
 
        url = "jdbc:sqlite:" + fileName;
 
        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("A new database has been created.");
            }
 
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        createNewDatabase("edGar.db");
        createTable();
    }
    
    public static void createTable()
    {
    	String sql = "CREATE TABLE IF NOT EXISTS warehouses (\n"
    			+ "id integer PRIMARY KEY,\n"
    			+ "name text NOT NULL,\n"
    			+ "capacity real\n"
    			+ ");";
    	
    	try (Connection conn = DriverManager.getConnection(url);
    			Statement stmt = conn.createStatement())
    	{
    		stmt.execute(sql);
    	}
    	catch (SQLException e) 
    	{
    		System.out.println(e.getMessage());
    	}
    }
}