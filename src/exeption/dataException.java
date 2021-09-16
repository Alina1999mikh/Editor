package exeption;

public class dataException extends Exception{
    public dataException(String data){
        super("Invalid data " + data);
    }
}
