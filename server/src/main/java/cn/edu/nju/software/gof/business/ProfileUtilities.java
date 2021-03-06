package cn.edu.nju.software.gof.business;

import org.springframework.stereotype.Component;

import cn.edu.nju.software.gof.beans.json.ProfileInfo;
import cn.edu.nju.software.gof.entity.Person;
import cn.edu.nju.software.gof.entity.Profile;
import cn.edu.nju.software.gof.type.UserState;



public class ProfileUtilities   extends BaseUtilities{

	/**
	 * Get the profile information of the given user.
	 * 
	 * @param sessionID
	 *            The session ID of the user.
	 * @return The profile information.
	 */
	public ProfileInfo getUserProfile(String sessionID) {
		Person person = accountManager.findBySessionId(sessionID).getOwner();
		if (person == null) {
			return null;
		} else {
			Profile profile = person.getProfile();
			String realName = profile.getRealName();
			String place = profile.getCurrentPlace();
			String birthday = profile.getBirthday();
			String school = profile.getSchool();
			ProfileInfo profileInfo = new ProfileInfo(realName, school,
					place, birthday,null);
			return profileInfo;
		}
	}

	/**
	 * Change the user's profile.
	 * 
	 * @param sessionID
	 * @param profileInfo
	 * @return
	 */
	public boolean setUserProfile(String sessionID, ProfileInfo profileInfo) {
		Person person = accountManager.findBySessionId(sessionID).getOwner();
		if (person == null) {
			return false;
		} else {
			String realName = profileInfo.getRealName();
			String birthday = profileInfo.getBirthday();
			String school = profileInfo.getSchool();
			String place = profileInfo.getPlace();

			Profile profile = person.getProfile();
			if (realName != null) {
				profile.setRealName(realName);
			}
			if (birthday != null) {
				profile.setBirthday(birthday);
			}
			if (school != null) {
				profile.setSchool(school);
			}
			if (place != null) {
				profile.setCurrentPlace(place);
			}
			return true;
		}
	}

	/**
	 * Get the avatar of the user.
	 * 
	 * @param sessionID
	 * @return
	 */
	public byte[] getUserAvatar(String sessionID) {
		Person person = accountManager.findBySessionId(sessionID).getOwner();
		if (person != null) {
			Profile profile = person.getProfile();
			byte[] avatar = profile.getAvatar();
			if (avatar != null) {
				return avatar;
			} else {
				return null;
			}
		} else {
			return null;
		}
	}

	/**
	 * Change the user's avatar.
	 * 
	 * @param sessionID
	 * @param avatar
	 * @return
	 */
	public boolean setUserAvatar(String sessionID, byte[] avatar) {
		Person person = accountManager.findBySessionId(sessionID).getOwner();
		if (person != null) {
			Profile profile = person.getProfile();
			if (avatar != null) {
				profile.setAvatar(avatar);
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	/**
	 * Change the user state.
	 * 
	 * @param sessionID
	 * @param userState
	 * @return
	 */
	public boolean changeOnlineState(String sessionID, UserState userState) {
		return true;
	}
}
