import java.sql.*;
import java.util.Scanner;

public class Question12 {
    static final String DB_URL = "jdbc:mysql:///Niranjana";
    static final String USER = "root";
    static final String PASS = "Nira@12345";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("\nMenu:");
                System.out.println("1. Add Record");
                System.out.println("2. View Records");
                System.out.println("3. Update Record");
                System.out.println("4. Delete Record");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        addRecord(conn, scanner);
                        break;
                    case 2:
                        viewRecords(conn);
                        break;
                    case 3:
                        updateRecord(conn, scanner);
                        break;
                    case 4:
                        deleteRecord(conn, scanner);
                        break;
                    case 5:
                        System.out.println("Exiting...");
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addRecord(Connection conn, Scanner scanner) {
        try {
            System.out.print("Enter name: ");
            String name = scanner.next();
            System.out.print("Enter address: ");
            String address = scanner.next();       
            String sql = "INSERT INTO customer (cname, caddress) VALUES (?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, address);

            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Record added successfully!");
            } else {
                System.out.println("Failed to add record.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void viewRecords(Connection conn) {
        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM customer");

            while (resultSet.next()) {
                int id = resultSet.getInt("cid");
                String name = resultSet.getString("cname");
                String address = resultSet.getString("caddress");

                System.out.println("ID: " + id + ", Name: " + name + ", Age: " + address);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateRecord(Connection conn, Scanner scanner) {
        try {
            System.out.print("Enter ID of the record to update: ");
            int id = scanner.nextInt();

            System.out.print("Enter new name: ");
            String name = scanner.next();
            System.out.print("Enter new address: ");
            String address = scanner.next();

            String sql = "UPDATE customer SET cname = ?, caddress = ? WHERE cid = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, address);
            preparedStatement.setInt(3, id);

            int rowsUpdated = preparedStatement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Record updated successfully!");
            } else {
                System.out.println("Failed to update record. Make sure the ID exists.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteRecord(Connection conn, Scanner scanner) {
        try {
            System.out.print("Enter ID of the record to delete: ");
            int cid = scanner.nextInt();

            String sql = "DELETE FROM customer WHERE cid = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, cid);

            int rowsDeleted = preparedStatement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Record deleted successfully!");
            } else {
                System.out.println("Failed to delete record. Make sure the ID exists.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
