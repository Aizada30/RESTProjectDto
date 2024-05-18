package global.globalException;

public class BadRequests extends RuntimeException{
    public BadRequests(String message) {
        super(message);
    }
}