package vivimosJava.controller.recaptcha;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="google.recaptcha")
public class ReCaptchaKeys {
	
	private String siteKey;
	private String secretKey;
	private String serverUrl;
	public String getSiteKey() {
		return siteKey;
	}
	public void setSiteKey(String siteKey) {
		this.siteKey = siteKey;
	}
	public String getSecretKey() {
		return secretKey;
	}
	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}
	public String getServerUrl() {
		return serverUrl;
	}
	public void setServerUrl(String serverUrl) {
		this.serverUrl = serverUrl;
	}
	
	
}
