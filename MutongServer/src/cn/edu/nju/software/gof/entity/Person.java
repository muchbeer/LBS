package cn.edu.nju.software.gof.entity;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NoResultException;
import javax.persistence.OneToOne;
import javax.persistence.Query;

import com.google.appengine.api.datastore.Key;

@Entity
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Key ID;

	private String lastPersonalLocation;

	@OneToOne(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
	private Account account;

	@OneToOne(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
	private Profile profile;

	private List<Key> friendIDs = new ArrayList<Key>();

	private List<Key> topPlaceIDs = new ArrayList<Key>();

	public Person() {
		super();
	}

	public Key getID() {
		return ID;
	}

	public void setID(Key iD) {
		ID = iD;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public List<PersonalLocation> getPersonalLocations(EntityManager em) {
		String sqlCmd = "SELECT P FROM PersonalLocation AS P WHERE P.ownerID = :ownerID";
		Query query = em.createQuery(sqlCmd);
		query.setParameter("ownerID", ID);
		//
		@SuppressWarnings("unchecked")
		List<PersonalLocation> personalLocations = query.getResultList();
		//
		return personalLocations;
	}

	public List<Key> getFriendIDs() {
		return friendIDs;
	}

	public List<Person> getFriends(EntityManager em) {
		List<Person> friends = new LinkedList<Person>();
		for (Key friendID : friendIDs) {
			Person person = em.find(Person.class, friendID);
			friends.add(person);
		}
		return friends;
	}

	public List<FriendRequest> getFriendRequests(EntityManager em) {
		String sqlCmd = "SELECT F FROM FriendRequest AS F WHERE F.targetPersonID = :ID";
		Query query = em.createQuery(sqlCmd);
		query.setParameter("ID", ID);
		//
		@SuppressWarnings("unchecked")
		List<FriendRequest> friendRequests = query.getResultList();
		//
		return friendRequests;
	}

	public String getLastPersonalLocation() {
		return lastPersonalLocation;
	}

	public void setLastPersonalLocation(String lastPersonalLocation) {
		this.lastPersonalLocation = lastPersonalLocation;
	}

	public List<CheckIn> getCheckIns(EntityManager em) {
		String sqlCmd = "SELECT C FROM CheckIn AS C WHERE C.ownerID = :ID";
		Query query = em.createQuery(sqlCmd);
		query.setParameter("ID", ID);
		//
		@SuppressWarnings("unchecked")
		List<CheckIn> checkIns = query.getResultList();
		//
		return checkIns;
	}

	public int getCheckInTimes(Key placeID, EntityManager em) {
		String sqlCmd = "SELECT C.counter FROM CheckInCounter AS C WHERE C.ownerID = :ownerID AND C.placeID = :placeID";
		Query query = em.createQuery(sqlCmd);
		query.setParameter("ownerID", ID);
		query.setParameter("placeID", placeID);
		try {
			int counter = (Integer) query.getSingleResult();
			return counter;
		} catch (NoResultException exception) {
			return 0;
		}
	}

	public int increaseCheckInTimes(Key placeID, EntityManager em) {
		String sqlCmd = "SELECT C FROM CheckInCounter AS C WHERE C.ownerID = :ownerID AND C.placeID = :placeID";
		Query query = em.createQuery(sqlCmd);
		query.setParameter("ownerID", ID);
		query.setParameter("placeID", placeID);
		try {
			CheckInCounter counter = (CheckInCounter) query.getSingleResult();
			counter.setCounter(counter.getCounter() + 1);
			return counter.getCounter();
		} catch (NoResultException exception) {
			CheckInCounter counter = new CheckInCounter(ID, placeID, 1);
			em.persist(counter);
			return 1;
		}
	}

	public List<Key> getTopPlaceIDs() {
		return topPlaceIDs;
	}

}
