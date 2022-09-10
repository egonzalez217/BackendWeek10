package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.PlayerSponsor;
import entity.TeamSponsor;

public class TeamSponsorDao {
	
	private Connection connection;
	private final String GET_TEAM_SPONSOR_QUERY = "SELECT * FROM team_sponsor";
	private final String GET_TEAM_SPONSOR_BY_ID_QUERY = "SELECT * from team_sponsor WHERE team_id = ?";
	
	public TeamSponsorDao() {
		connection = DBConnection.getConnection();
	}
	
	//get list of all team sponsors from the database
	public List<TeamSponsor> getTeamSponsors() throws SQLException {
		ResultSet rs = connection.prepareStatement(GET_TEAM_SPONSOR_QUERY).executeQuery();
		List<TeamSponsor> teamSponsors = new ArrayList<TeamSponsor>();
		
		while(rs.next()) {
			teamSponsors.add(populateTeamSponsor(rs.getInt(1), rs.getInt(2)));
		}
		
		return teamSponsors;
	}
	
	public List<TeamSponsor> getTeamSponsorById(int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(GET_TEAM_SPONSOR_BY_ID_QUERY);
		
		List<TeamSponsor> teamSponsors = new ArrayList<TeamSponsor>();
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			teamSponsors.add(populateTeamSponsor(rs.getInt(1), rs.getInt(2)));
		}
		return teamSponsors;
		
	}
	
	
	private TeamSponsor populateTeamSponsor(int teamId, int sponsorId) {
		return new TeamSponsor(teamId, sponsorId);
	}
	
	

}
