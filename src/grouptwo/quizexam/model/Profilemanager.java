package grouptwo.quizexam.model;

import java.util.Date;

public class Profilemanager {

	private String usersUserName;
	private String name;
	private Date dateOfBirth;
	private String gender;
	private String email;
	private String phoneNumber;
	private String image;
	private boolean showProfile;

	public Profilemanager() {
	}

	public Profilemanager(String usersUserName, String name, Date dateOfBirth, String gender, String email, String phoneNumber,
			String image,boolean showProfile) {
		this.usersUserName = usersUserName;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.image=image;
		this.showProfile = showProfile;
	}
	public Profilemanager( String name, Date dateOfBirth, String gender, String email, String phoneNumber,
			String image,boolean showProfile) {
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.image=image;
		this.showProfile = showProfile;
	}

	public String getUsersUserName() {
		return this.usersUserName;
	}

	public void setUsersUserName(String usersUserName) {
		this.usersUserName = usersUserName;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDateOfBirth() {
		return this.dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public boolean getShowProfile() {
		return this.showProfile;
	}

	public void setShowProfile(boolean showProfile) {
		this.showProfile = showProfile;
	}


}
