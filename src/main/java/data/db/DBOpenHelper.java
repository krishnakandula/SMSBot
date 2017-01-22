package data.db;

import config.Config;

import java.sql.*;

/**
 * Created by krishnakandula on 1/21/17.
 */
public class DBOpenHelper {
    private static DBOpenHelper dbInstance;
    private Connection connection;
    private DBOpenHelper(){}

    public static DBOpenHelper getDbOpenHelper(){
        if(dbInstance == null)
            dbInstance = new DBOpenHelper();
        return dbInstance;
    }

    public void initializeDb(){
        try{
            Class.forName("org.postgresql.Driver");
            connection = DriverManager
                    .getConnection(Config.PostgresDB.DB_URL
                                    + Config.PostgresDB.DB_NAME
                                    , Config.PostgresDB.USERNAME
                                    , Config.PostgresDB.PASSWORD);
            createTable();
        } catch (Exception e){
            System.out.println(e.getMessage());
            System.exit(0);
        }
    }

    private void createTable() throws SQLException {
        if(!checkTableExists()) {
            Statement statement = connection.createStatement();
            String createTable =
                    "CREATE TABLE " + ContactDBSchema.ContactTable.name + "( " +
                            ContactDBSchema.ContactTable.Cols.UUID + "   INT PRIMARY KEY    NOT NULL, " +
                            ContactDBSchema.ContactTable.Cols.NAME + "          TEXT        NOT NULL, " +
                            ContactDBSchema.ContactTable.Cols.PHONE_NUMBER + "  CHAR(10)    NOT NULL)";
            statement.execute(createTable);
        }
    }

    private boolean checkTableExists() throws SQLException{
        //User meta data to get existing tables
        DatabaseMetaData metaData = connection.getMetaData();
        ResultSet results = metaData.getTables(null
                , null
                , ContactDBSchema.ContactTable.name
                , new String[]{"TABLE"});
        //If result set has more than one entry, then table exists
        return results.next();
    }
}
