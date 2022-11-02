package racing.transport;

public class FailedCheckupException extends Exception {

    public FailedCheckupException() {
    }

    public FailedCheckupException(String message) {
        super(message);
    }
}
