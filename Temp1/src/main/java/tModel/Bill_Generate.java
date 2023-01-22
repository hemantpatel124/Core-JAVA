package tModel;

public class Bill_Generate {
	private int bid,property_tax,water_charge,drainage_charge,streetlight_charge,fire_charge,other_charge,total_amount;
	private String dobg;
	public String getDobg() {
		return dobg;
	}

	public void setDobg(String dobg) {
		this.dobg = dobg;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}



	public int getProperty_tax() {
		return property_tax;
	}

	public void setProperty_tax(int property_tax) {
		this.property_tax = property_tax;
	}

	public int getWater_charge() {
		return water_charge;
	}

	public void setWater_charge(int water_charge) {
		this.water_charge = water_charge;
	}

	public int getDrainage_charge() {
		return drainage_charge;
	}

	public void setDrainage_charge(int drainage_charge) {
		this.drainage_charge = drainage_charge;
	}

	public int getStreetlight_charge() {
		return streetlight_charge;
	}

	public void setStreetlight_charge(int streetlight_charge) {
		this.streetlight_charge = streetlight_charge;
	}

	public int getFire_charge() {
		return fire_charge;
	}

	public void setFire_charge(int fire_charge) {
		this.fire_charge = fire_charge;
	}

	public int getOther_charge() {
		return other_charge;
	}

	public void setOther_charge(int other_charge) {
		this.other_charge = other_charge;
	}

	public int getTotal_amount() {
		return total_amount;
	}

	public void setTotal_amount(int total_amount) {
		this.total_amount = total_amount;
	}

	@Override
	public String toString() {
		return "Bill_Generate [bid=" + bid + ", property_tax=" + property_tax + ", water_charge=" + water_charge
				+ ", drainage_charge=" + drainage_charge + ", streetlight_charge=" + streetlight_charge
				+ ", fire_charge=" + fire_charge + ", other_charge=" + other_charge + ", total_amount=" + total_amount
				+ ", dobg=" + dobg + "]";
	}
	
	
}
