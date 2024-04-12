import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


public class InsertSnowFlakeTable {

    public static void main(String[] args) {

        Properties properties = new Properties();
        properties.put("user", "<my-snowflake-user-id>");
        properties.put("password", "<my-password>");
        properties.put("account", "wtlejzi-fv69824"); //account-id followed by cloud region.
        properties.put("warehouse", "COMPUTE_WH");
        properties.put("db", "TEST_DATA");
        properties.put("schema", "PUBLIC");
        properties.put("role", "ACCOUNTADMIN");

        //https://wtlejzi-fv69824.snowflakecomputing.com
        // snowflake JDBC URL
        String jdbcUrl = "jdbc:snowflake://wtlejzi-fv69824.snowflakecomputing.com/";

        try {

            Connection connection = DriverManager.getConnection(jdbcUrl, properties);
            System.out.println("\tConnection established, connection id : " + connection);

            Statement stmt = connection.createStatement();
            System.out.println("\tGot the statement object, object-id : " + stmt);

            //number of records to be inserted
            int recordInsert = 5;

            for(int i = 0; i < recordInsert; ++i) {
                String dmlQuery = "insert into jdbc_demo values (" + i + ", 'Demo" + i + "')";
                System.out.println("The query is:" + dmlQuery);
                int insertCnt = stmt.executeUpdate(dmlQuery);
                System.out.println("\t(" + i + ") Row inserted: " + insertCnt);
            }


            System.out.println("\t----------------------------------------");
            System.out.println("\tProgram executed successfully");
        } catch (SQLException var11) {
            var11.printStackTrace();
        }


    }
}


