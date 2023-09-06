package res.exceptions;

public class ArrivalAndDepartureSameException extends NoStackTraceRuntimeException {
    public ArrivalAndDepartureSameException() {
        super("La station d'arrivée ne peut pas être la même que de départ.");
    }
}
