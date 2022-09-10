package entity;

public class Sponsors {
	private int id;
	private String sponsorName;
	
	public Sponsors(int id, String sponsorName) {
		this.setId(id);
		this.setSponsorName(sponsorName);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSponsorName() {
		return sponsorName;
	}

	public void setSponsorName(String sponsorName) {
		this.sponsorName = sponsorName;
	}
	
	
}
