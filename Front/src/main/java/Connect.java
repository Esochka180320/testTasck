import java.sql.*;

public class Connect {

    static final String URL = "jdbc:mysql://eu-cdbr-west-03.cleardb.net:3306/heroku_174735cab0dd328";
    static final String USER = "b9cd6b8ca36f20";
    static final String PASSWORD = "44cfb7d6";

    private static Connection con;
    private static Statement stmt;
    private static PreparedStatement preparedStatement;
    private static ResultSet rs;

    public static void mySQLClient() {
        try {
            con = DriverManager.getConnection(URL, USER, PASSWORD);
            stmt = con.createStatement();
        } catch (SQLException sqlEx) {
            System.out.println("Connection Failed! Check output console");
            sqlEx.printStackTrace();
        }

        if (con != null) {
            System.out.println("You made it, take control your database now!");
        } else {
            System.out.println("Failed to make connection!");
        }
        try {
            String myTableName = "CREATE TABLE month("
                    + "id   INT               NOT NULL AUTO_INCREMENT,"
                    + "name VARCHAR (100)     NOT NULL,"
                    + "number  INT        NOT NULL,"
                    + " PRIMARY KEY (id));";
            stmt.executeUpdate(myTableName);

            System.out.println("Table created");
        } catch (SQLException e) {
            System.out.println("Table is al created");
        }
    }
}
