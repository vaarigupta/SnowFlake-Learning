//java.sql library for all connection objects
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//java util library
import java.util.Properties;

public class SnowFlakeJDBC {

    public static void main(String[] args) {

        //properties object
        Properties properties = new Properties();

        //setting properties
        properties.put("user", "vaarigupta");
        properties.put("password", "Codingislove@1");
        properties.put("account", "wtlejzi-fv69824"); //account-id followed by cloud region.
        properties.put("warehouse", "COMPUTE_WH");
        properties.put("db", "TEST_DATA");
        properties.put("schema", "PUBLIC");
        properties.put("role", "ACCOUNTADMIN");

      //  https://wtlejzi-fv69824.snowflakecomputing.com
        //change this below URL as per your snowflake instance
        String jdbcUrl = "jdbc:snowflake://wtlejzi-fv69824.snowflakecomputing.com/";

        //change this select statement, but make sure the logic below is hard coded for now.
        String selectSQL = "SELECT * FROM TEST_DATA.PUBLIC.Persons";
        //"SELECT * FROM  TEST_DB.TEST_SCHEMA.Employees";
        //try-catch block
        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, properties);
            System.out.println("\tConnection established, connection id : " + connection);

            Statement stmt = connection.createStatement();
            System.out.println("\tGot the statement object, object-id : " + stmt);

            ResultSet rs = stmt.executeQuery(selectSQL);
            System.out.println("\tGot the result set object, object-id : " + rs);
            System.out.println("\t----------------------------------------");

            while(rs.next()) {
                //following rs.getXXX should also change as per your select query
                System.out.println(" \tEmployee " + rs.getInt("PERSONID") +  ": "
                        + rs.getString("FIRSTNAME") + " " + rs.getString("LASTNAME")
                + ", Age: " + rs.getInt("AGE"));
    /*            System.out.println(" \tEmployee First: " + );
                System.out.println(" \tEmployee Last: " + );
                System.out.println(" \tEmployee Age: " + rs.getInt("AGE"));
                System.out.println(); */
            }

            System.out.println("\t----------------------------------------");
            System.out.println("\tProgram executed successfully");
        } catch (SQLException exp) {
            exp.printStackTrace();
        }


    }
}
