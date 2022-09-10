import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		String connectionString = "jdbc:mysql://localhost:3306/nba";
		String SELECT_QUERY = "SELECT * FROM nba.players WHERE id = ?";
		
		Scanner scanner = new Scanner(System.in);
		
		try {
		Connection conn = DriverManager.getConnection(connectionString, "root", "EyesUpGuardian");
		System.out.println("Connected successfully!");
				System.out.println("Enter ID of desired nba player rank: ");
				String id = scanner.nextLine();
				
				PreparedStatement ps = conn.prepareStatement(SELECT_QUERY);
				ps.setString(1, id);
				ResultSet rs = ps.executeQuery();
				
				while (rs.next()) {
					System.out.println("ID: " + rs.getInt(1) + " | Team ID: " + rs.getInt(2) + " | Player Name: " + rs.getString(3) + 
					" | Player Rank: " + rs.getInt(4) + " | Team: " + rs.getString(5) + " | Average Points: " + rs.getInt(6) 
					+ " | Games Played: " + rs.getInt(7) + " | Minutes Per Game: " + rs.getInt(8) + "\n");
					
				System.out.println("You have been disconnected.");
				}
		} catch (SQLException e) {
			System.out.println("Error connecting to the database.");
			e.printStackTrace();
	}
		
	}

}
