//package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class CreateSnowFlakeTable {

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

        //ddl statement
        String sqlQuery = "create or replace table jdbc_demo (id int, name varchar(255))";

        System.out.println("\tStarting the Snowflake Java JDBC Connection Program");

        try {

            Connection connection = DriverManager.getConnection(jdbcUrl, properties);
            System.out.println("\tConnection established, connection id : " + connection);

            Statement stmt = connection.createStatement();
            System.out.println("\tGot the statement object, object-id : " + stmt);

            int positiveInt = stmt.executeUpdate(sqlQuery);
            System.out.println("\tDDL statement executed : " + positiveInt);

            System.out.println("\t----------------------------------------");
            System.out.println("\tProgram executed successfully");
        } catch (SQLException var11) {
            var11.printStackTrace();
        }


    }
}