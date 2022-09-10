package dao;

import entity.Players;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;


public class PlayersDao {

	private Connection connection;
	private final String GET_PLAYERS_QUERY = "SELECT * FROM players";
	private final String GET_PLAYER_BY_ID_QUERY = "SELECT * FROM players WHERE id = ?";
	private final String DELETE_PLAYERS_BY_TEAM_ID_QUERY = "DELETE FROM players WHERE id = ?";
	private final String CREATE_NEW_PLAYER_QUERY = "INSERT INTO players(id, team_id, player_name, player_rank, team, avg_points, games_played, minutes_per_game) VALUES(?,?,?,?,?,?,?,?)";

	public PlayersDao() {
		connection = DBConnection.getConnection();
	}
	
	//get all players with proper syntax according to our players table parameters
	public List<Players> getPlayers() throws SQLException {
		ResultSet rs = connection.prepareStatement(GET_PLAYERS_QUERY).executeQuery();
		List<Players> players = new ArrayList<Players>();
		
		while(rs.next()) {
			players.add(populatePlayer(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getDouble(6),rs.getInt(7), rs.getDouble(8)));
		}
		
		return players;
	}
	//get all players with proper syntax according to our players table parameters
	public Players getPlayerById(int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(GET_PLAYER_BY_ID_QUERY);
		ps.setInt(1,id);
		ResultSet rs = ps.executeQuery();
		rs.next();
		return populatePlayer(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getDouble(6),rs.getInt(7), rs.getDouble(8));
	}
	
	//get a player with proper syntax according to our players table parameters
	private Players populatePlayer(int id, int teamId, String playerName, int playerRank, String team, double averagePoints, int gamesPlayed, double minutesPerGame) {
		return new Players(id, teamId, playerName, playerRank, team, averagePoints, gamesPlayed, minutesPerGame);
	}
	
	public void createNewPlayer(int id, int teamId, String playerName, int playerRank, String team, double averagePoints, int gamesPlayed, double minutesPerGame) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(CREATE_NEW_PLAYER_QUERY);
		ps.setInt(1, id);
		ps.setInt(2,teamId);
		ps.setString(3, playerName);
		ps.setInt(4, playerRank);
		ps.setString(5, team);
		ps.setDouble(6, averagePoints);
		ps.setInt(7, gamesPlayed);
		ps.setDouble(8, minutesPerGame);
		ps.executeUpdate();
	}
	
	//delete players by team id
	public void deletePlayersByPlayoffTeamsId(int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(DELETE_PLAYERS_BY_TEAM_ID_QUERY);
		ps.setInt(1, id);
		ps.executeUpdate();
	}
	
}
