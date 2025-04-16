import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


/**
 * Custom exception class for when a 
 * student attempts to register but the class is full
 */
 
 public class ClassFullException extends Exception{
    private String date;
    private String month;

    // Constructor for ClassFullException
    public ClassFullException(String date, String month){
        super("Class is full. Registration attempted on " + month + " "+ date );
        this.date = date;
        this.month = month;
    }

    // getters for date and month
    public String getDate(){
        return date;
    }

    public String getMonth(){
        return month;
    }


}
