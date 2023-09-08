package global.globalException;

/**
 * Abdyrazakova Aizada
 */
public class NotFoundException extends RuntimeException{
    public NotFoundException() {
    }

    public NotFoundException(String message) {
        super(message);
    }
}
