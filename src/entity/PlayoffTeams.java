package entity;

public class PlayoffTeams {
	private int id;
	private int teamRank;
	private String teamName;
	private int wins;
	private int losses;
	private String conference;
	
	public PlayoffTeams (int id, int teamRank, String teamName, int wins, int losses, String conference) {
		this.setId(id);
		this.setTeamRank(teamRank);
		this.setTeamName(teamName);
		this.setWins(wins);
		this.setLosses(losses);
		this.setConference(conference);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTeamRank() {
		return teamRank;
	}

	public void setTeamRank(int teamRank) {
		this.teamRank = teamRank;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public int getWins() {
		return wins;
	}

	public void setWins(int wins) {
		this.wins = wins;
	}

	public int getLosses() {
		return losses;
	}

	public void setLosses(int losses) {
		this.losses = losses;
	}

	public String getConference() {
		return conference;
	}

	public void setConference(String conference) {
		this.conference = conference;
	}
}
