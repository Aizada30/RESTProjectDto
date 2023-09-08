package global.globalException;

/**
 * Abdyrazakova Aizada
 */
public class BadRequests extends RuntimeException{
    public BadRequests() {
    }

    public BadRequests(String message) {
        super(message);
    }
}
