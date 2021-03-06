package cn.edu.nju.software.gof.beans;

import com.google.android.maps.GeoPoint;

public class FriendNearbyInformationBean extends JSONTarget {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7197395421943440208L;
	private String friendID;
	private String friendName;
	private double latitude;
	private double longitude;
	private String time;

	public FriendNearbyInformationBean() {
		super();
	}

	public FriendNearbyInformationBean(String friendID, String friendName,
			double latitude, double longitude, String time) {
		super();
		this.setFriendID(friendID);
		this.setFriendName(friendName);
		this.setLatitude(latitude);
		this.setLongitude(longitude);
		this.setTime(time);
	}

	public GeoPoint getGeoPoint() {
		int latitudeE6 = new Double(latitude * 1E6).intValue();
		int longitudeE6 = new Double(longitude * 1E6).intValue();
		return new GeoPoint(latitudeE6, longitudeE6);
	}

	public void setFriendID(String friendID) {
		this.friendID = friendID;
	}

	public String getFriendID() {
		return friendID;
	}

	public void setFriendName(String friendName) {
		this.friendName = friendName;
	}

	public String getFriendName() {
		return friendName;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getTime() {
		return time;
	}
}
