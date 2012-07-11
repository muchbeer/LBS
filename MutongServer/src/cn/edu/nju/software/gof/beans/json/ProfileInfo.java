package cn.edu.nju.software.gof.beans.json;

public class ProfileInfo extends JSONAble {
	private String realName;
	private String school;
	private String place;
	private String birthday;

	public ProfileInfo() {
		super();
	}

	public ProfileInfo(String realName, String school, String place,
			String birthday) {
		super();
		this.realName = realName;
		this.school = school;
		this.place = place;
		this.birthday = birthday;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
}