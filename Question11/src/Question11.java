import java.sql.*;

public class Question11 {
    public static void main(String[] args) {
        String url = "jdbc:mysql:///Niranjana"; // Replace with your MySQL URL
        String username = "root"; // Replace with your MySQL username
        String password = "Nira@12345"; // Replace with your MySQL password

        try {
            Connection connection = DriverManager.getConnection(url, username, password);

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM customer"); // Replace with your table name

            while (resultSet.next()) {
                int id = resultSet.getInt("cid"); // Assuming you have a column named "id"
                String name = resultSet.getString("cname"); // Assuming you have a column named "name"

                System.out.println("ID: " + id + ", Name: " + name);
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
