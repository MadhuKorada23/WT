import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertRecord {
    public static void main(String[] args) {
        try (Connection connection = JDBCConnection.getConnection();
             Statement statement = connection.createStatement()) {

            String insertSQL = "INSERT INTO students (name, age) VALUES " +
                    "('John Doe', 22), ('Jane Smith', 21), ('Mike Johnson', 23)";
            int rowsInserted = statement.executeUpdate(insertSQL);
            System.out.println(rowsInserted + " record(s) inserted successfully.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
