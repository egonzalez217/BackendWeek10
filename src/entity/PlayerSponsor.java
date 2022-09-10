package entity;

public class PlayerSponsor {
	private int playerId;
	private int sponsorId;
	
	public PlayerSponsor(int playerId, int sponsorId) {
		this.setPlayerId(playerId);
		this.setSponsorId(sponsorId);
	}

	public int getPlayerId() {
		return playerId;
	}

	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}

	public int getSponsorId() {
		return sponsorId;
	}

	public void setSponsorId(int sponsorId) {
		this.sponsorId = sponsorId;
	}
}
