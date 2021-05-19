package vivimosJava.controller;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ReCaptchaResponse {
	private boolean success;
	private float score;
	private String action;
	private String challenge_ts;
	private String hostName;
	
	
	@JsonProperty("error-codes")
	private String[] errorCodes;
	
	public boolean isSuccess() {
		return success;
	}
	
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getChallenge_ts() {
		return challenge_ts;
	}
	public void setChallenge_ts(String challenge_ts) {
		this.challenge_ts = challenge_ts;
	}
	public String getHostName() {
		return hostName;
	}
	public void setHostName(String hostName) {
		this.hostName = hostName;
	}
	public float getScore() {
		return score;
	}
	public void setScore(float score) {
		this.score = score;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	
	
}
