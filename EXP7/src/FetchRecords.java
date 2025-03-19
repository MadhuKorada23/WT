import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FetchRecords {
    public static void main(String[] args) {
        try (Connection connection = JDBCConnection.getConnection();
             Statement statement = connection.createStatement()) {

            String selectSQL = "SELECT * FROM students";
            ResultSet resultSet = statement.executeQuery(selectSQL);

            System.out.println("ID\tName\t\tAge");
            System.out.println("------------------------");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                System.out.println(id + "\t" + name + "\t\t" + age);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
