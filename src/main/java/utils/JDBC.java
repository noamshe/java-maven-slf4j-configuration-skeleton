package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class JDBC {

  private static final String db = ApplicationConf.getConfig().getString("report_db_connection");

  private static Map<String, Connection> connections = new HashMap<String, Connection>();

  static {
    try {
      DriverManager.registerDriver(new com.mysql.jdbc.Driver());
    } catch (Exception e) {
      System.out.println("Failed to register driver: " + e.getMessage());
    }
  }

  public static Connection connect(String dbname) {

    try {
      return DriverManager.getConnection(db);
    } catch (Exception e) {
      System.out.println("failed to connect to db with configuration string: " + db + " " + e);
    }
    return null;
  }

  public static void execute(String sql) {
    Connection connection = null;
    try {
      connection = connect(db);
      Statement statement = connection.createStatement();
      System.out.println("Executing query \"" + sql + "\"");
      statement.executeUpdate(sql);
      statement.close();

    } catch (Exception ex) {
      ex.printStackTrace();
      System.out.println("error in execute" + ex);
    } finally {
      if (connection != null) {

        try {
          connection.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }

      }

    }
  }

}