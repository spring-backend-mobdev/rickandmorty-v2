package cl.mobdev.challenge.usecase;

public class DeadException extends RuntimeException{

    public DeadException(String message){
        super(message);
    }
}

