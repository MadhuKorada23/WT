import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {
    public static void main(String[] args) {
        try (Connection connection = JDBCConnection.getConnection();
             Statement statement = connection.createStatement()) {

            String createTableSQL = "CREATE TABLE students (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY, " +
                    "name VARCHAR(50) NOT NULL, " +
                    "age INT NOT NULL)";
            statement.executeUpdate(createTableSQL);
            System.out.println("Table 'students' created successfully.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
