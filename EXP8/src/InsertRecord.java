import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertRecord {
    public static void main(String[] args) {
        try (Connection connection = JDBCConnection.getConnection();
             Scanner scanner = new Scanner(System.in)) {

            // Ensure the table exists
            String createTable = "CREATE TABLE IF NOT EXISTS students (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY, " +
                    "name VARCHAR(50) NOT NULL, " +
                    "age INT NOT NULL)";
            connection.createStatement().executeUpdate(createTable);

            // SQL query with placeholders (?)
            String insertSQL = "INSERT INTO students (name, age) VALUES (?, ?)";

            try (PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {

                System.out.println("Enter student name: ");
                String name = scanner.nextLine();

                System.out.println("Enter student age: ");
                int age = scanner.nextInt();

                // Set parameters
                preparedStatement.setString(1, name);
                preparedStatement.setInt(2, age);

                // Execute insertion
                int rowsInserted = preparedStatement.executeUpdate();
                System.out.println(rowsInserted + " record inserted successfully.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

