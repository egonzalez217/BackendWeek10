package dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Sponsors;

public class SponsorsDao {
	
	private Connection connection;
	private final String GET_SPONSORS_QUERY = "SELECT * FROM sponsors";
	private final String GET_SPONSOR_BY_ID_QUERY = "SELECT * FROM sponsors WHERE id = ?";
	
	public SponsorsDao () {
		connection = DBConnection.getConnection();
	}
	
	public List<Sponsors> getSponsors() throws SQLException {
		ResultSet rs = connection.prepareStatement(GET_SPONSORS_QUERY).executeQuery();
		List<Sponsors> sponsors = new ArrayList<Sponsors>();
		
		while(rs.next()) {
			sponsors.add(populateSponsor(rs.getInt(1), rs.getString(2)));
		}
		return sponsors;
		
	}
	//get all sponsors with proper syntax according to our sponsors table parameters
	public Sponsors getSponsorById(int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(GET_SPONSOR_BY_ID_QUERY);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		rs.next();
		return populateSponsor(rs.getInt(1), rs.getString(2));
		
	}
	//get a sponsor with proper syntax according to our sponsors table parameters
	private Sponsors populateSponsor(int id, String sponsorName) {
		return new Sponsors(id, sponsorName);
	}

}
