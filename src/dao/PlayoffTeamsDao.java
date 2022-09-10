package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.PlayoffTeams;

public class PlayoffTeamsDao {
	
	private Connection connection;
	private PlayersDao playerDao = new PlayersDao(); 
	private final String GET_TEAMS_QUERY = "SELECT * FROM playoff_teams";
	private final String GET_TEAM_BY_ID_QUERY = "SELECT * FROM playoff_teams WHERE id = ?";
	private final String CREATE_NEW_TEAM_QUERY = "INSERT INTO playoff_teams(id, team_rank, team_name, wins, losses, conference) VALUES(?,?,?,?,?,?)";
	private final String DELETE_TEAM_BY_ID_QUERY = "DELETE FROM playoff_teams WHERE id = ?";
	
	//constructor so that the connection can be used outside of the private definition within this class (line 14)
	public PlayoffTeamsDao () {
		connection = DBConnection.getConnection();
	}
	
	public List<PlayoffTeams> getTeams() throws SQLException {
		ResultSet rs = connection.prepareStatement(GET_TEAMS_QUERY).executeQuery();
		List<PlayoffTeams> playoffTeams = new ArrayList<PlayoffTeams>();
		
		while(rs.next()) {
			playoffTeams.add(populateTeam(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getString(6)));
		}
		
		return playoffTeams;
	}
	
	//get all playoffteams with proper syntax according to our playoffteam table parameters
	public PlayoffTeams getTeamById(int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(GET_TEAM_BY_ID_QUERY);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		rs.next();
		return populateTeam(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getString(6));
		
	}
	
	//create a team with proper syntax according to table parameters
	public void createNewTeam(int id, int teamRank, String teamName, int wins, int losses, String conference) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(CREATE_NEW_TEAM_QUERY);
		ps.setInt(1, id);
		ps.setInt(2, teamRank);
		ps.setString(3, teamName);
		ps.setInt(4, wins);
		ps.setInt(5, losses);
		ps.setString(6, conference);
		ps.executeUpdate();
	}
	
	//get a team with proper syntax according to our playoffteam table parameters
	private PlayoffTeams populateTeam(int id, int teamRank, String teamName, int wins, int losses, String conference) {
		return new PlayoffTeams(id, teamRank, teamName, wins, losses, conference);
	}
	
	//delete a team according to the playoffteam table parameters
	public void deleteTeamById(int id) throws SQLException {
		playerDao.deletePlayersByPlayoffTeamsId(id);
		PreparedStatement ps = connection.prepareStatement(DELETE_TEAM_BY_ID_QUERY);
		ps.setInt(1,  id);
		ps.executeUpdate();
	}
	
}
