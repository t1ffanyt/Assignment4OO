package assign4.model;

public class TeamException extends RuntimeException {

    public TeamException(Exception e){
        super(e);
    }
    public TeamException(String message){
        super(message);
    }

}
