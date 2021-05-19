package vivimosJava.controller.recaptcha;

import java.util.HashMap;
import java.util.Map;

public class ReCaptchaErrorCodes {
	public static Map<String,String> reCaptchaErrorCodes;
	static {
		reCaptchaErrorCodes=new HashMap<>();
		reCaptchaErrorCodes.put("missing-input-secret","The secret parameter is missing.");
		reCaptchaErrorCodes.put("invalid-input-secret","The secret parameter is invalid or malformed.");
		reCaptchaErrorCodes.put("missing-input-response	","The response parameter is missing.");
		reCaptchaErrorCodes.put("invalid-input-response	","The response parameter is invalid or malformed.");
		reCaptchaErrorCodes.put("bad-request","The request is invalid or malformed.");
		reCaptchaErrorCodes.put("timeout-or-duplicate","The response is no longer valid: either is too old or has been used previously.");

	}
}
	


