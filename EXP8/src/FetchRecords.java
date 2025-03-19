import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FetchRecords {
    public static void main(String[] args) {
        try (Connection connection = JDBCConnection.getConnection()) {

            // SQL query to fetch data
            String selectSQL = "SELECT * FROM students";

            try (PreparedStatement preparedStatement = connection.prepareStatement(selectSQL);
                 ResultSet resultSet = preparedStatement.executeQuery()) {

                System.out.println("ID\tName\t\tAge");
                System.out.println("------------------------");

                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    int age = resultSet.getInt("age");

                    System.out.println(id + "\t" + name + "\t\t" + age);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

