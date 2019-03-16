package kamil.rojek.ox.CustomExceptions;

public class PlayerSeedTypeException extends Exception{

    public PlayerSeedTypeException(String message) {
        super(message);
    }

    public PlayerSeedTypeException(String message, Throwable cause) {
        super(message, cause);
    }
}
