package com.tic.app.model;

import java.sql.Date;

public class UserVO {
	private String USER_ID;
	private String USER_PW;
	private String USER_NAME;
	private String USER_EMAIL;
	private Date REG_DT;
	private Date UPD_DT;

	public String getUSER_ID() {
		return USER_ID;
	}

	public void setUSER_ID(String uSER_ID) {
		USER_ID = uSER_ID;
	}

	public String getUSER_PW() {
		return USER_PW;
	}

	public void setUSER_PW(String uSER_PW) {
		USER_PW = uSER_PW;
	}

	public String getUSER_NAME() {
		return USER_NAME;
	}

	public void setUSER_NAME(String uSER_NAME) {
		USER_NAME = uSER_NAME;
	}

	public String getUSER_EMAIL() {
		return USER_EMAIL;
	}

	public void setUSER_EMAIL(String uSER_EMAIL) {
		USER_EMAIL = uSER_EMAIL;
	}

	public Date getREG_DT() {
		return REG_DT;
	}

	public void setREG_DT(Date rEG_DT) {
		REG_DT = rEG_DT;
	}

	public Date getUPD_DT() {
		return UPD_DT;
	}

	public void setUPD_DT(Date uPD_DT) {
		UPD_DT = uPD_DT;
	}

}
