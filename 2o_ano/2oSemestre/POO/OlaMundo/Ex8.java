import java.time.LocalDate

public class Ex8
{
    public static void main(){
    }


    public static int dayDiff(LocalDate date){
        LocalDate base = LocalDate.of(1900,1,1);

        int yearsDiff, daysDiff;

        yearsDiff = date.getYear() - base.get(Year);

        daysDiff = yearsDiff * 365 + (yearsDiff/4);


}
