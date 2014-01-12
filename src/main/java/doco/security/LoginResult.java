package doco.security;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class LoginResult {
    private int code;
    private String message;
    private String sessionId;

    public LoginResult() {
    }

    public LoginResult(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public LoginResult(int code, String message, String sessionId) {
        this.code = code;
        this.message = message;
        this.sessionId = sessionId;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
}
