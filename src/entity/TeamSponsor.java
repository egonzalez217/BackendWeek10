package entity;

public class TeamSponsor {
	private int teamId;
	private int sponsorId;
	
	public TeamSponsor (int teamId, int sponsorId) {
		this.setTeamId(teamId);
		this.setSponsorId(sponsorId);
	}

	public int getTeamId() {
		return teamId;
	}

	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}

	public int getSponsorId() {
		return sponsorId;
	}

	public void setSponsorId(int sponsorId) {
		this.sponsorId = sponsorId;
	}
}
