package action;

public class LoginAction {
    static private String TOKEN = "petitkoala";

    /**
     * Attest that a token is valid to use the API
     * @param token Token to validate
     * @return True if token is valid
     */
    static public boolean isValidToken(String token) {
        return TOKEN.equals(token);
    }
}
