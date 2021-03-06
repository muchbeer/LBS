package cn.edu.nju.software.gof.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.google.appengine.api.datastore.Blob;
import com.google.appengine.api.datastore.Key;

@Entity
public class Place {

	public static final Long START_MONEY = 256L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Key ID;

	private String placeName;

	private Double latitude;

	private Double longutide;

	private Key creatorID;

	private Key topUserID;

	private Long checkInTimes = 0L;

	private Long currentMoney = START_MONEY;

	@Basic(fetch = FetchType.LAZY)
	private Blob image;

	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
	private List<Reply> replies = new ArrayList<Reply>();

	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
	private List<Place> subPlaces = new ArrayList<Place>();

	public Place() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Place(String placeName, Key creatorID) {
		super();
		this.placeName = placeName;
		this.creatorID = creatorID;
	}

	public Place(String placeName, Double latitude, Double longutide,
			Key creator) {
		super();
		this.placeName = placeName;
		this.latitude = latitude;
		this.longutide = longutide;
		this.creatorID = creator;
	}

	public Blob getImage() {
		return image;
	}

	public void setImage(Blob image) {
		this.image = image;
	}

	public void increaseCheckInTimes() {
		checkInTimes++;
	}

	public Long getCurrentMoney() {
		return currentMoney;
	}

	public void setCurrentMoney(Long currentMoney) {
		this.currentMoney = currentMoney;
	}

	public Long getCheckInTimes() {
		return checkInTimes;
	}

	public void setCheckInTimes(Long checkInTimes) {
		this.checkInTimes = checkInTimes;
	}

	public Key getID() {
		return ID;
	}

	public void setID(Key iD) {
		ID = iD;
	}

	public Key getTopUserID() {
		return topUserID;
	}

	public void setTopUserID(Key topUserID) {
		this.topUserID = topUserID;
	}

	public Person getTopUser(EntityManager em) {

		return (topUserID == null) ? null : em.find(Person.class, topUserID);
	}

	public String getPlaceName() {
		return placeName;
	}

	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongutide() {
		return longutide;
	}

	public void setLongutide(Double longutide) {
		this.longutide = longutide;
	}

	public List<Reply> getReplies() {
		return replies;
	}

	public void setReplies(List<Reply> replies) {
		this.replies = replies;
	}

	public List<Place> getSubPlaces() {
		return subPlaces;
	}

	public void setSubPlaces(List<Place> subPlaces) {
		this.subPlaces = subPlaces;
	}

	public Key getCreatorID() {
		return creatorID;
	}

	public void setCreatorID(Key creatorID) {
		this.creatorID = creatorID;
	}
}
