import java.time.LocalDate;
import java.util.Scanner;

public class Ex8{
    public static void main(String[] args){
        int year, month, day;
        Scanner input = new Scanner(System.in);
        System.out.println("Ano:");
        year = input.nextInt();
        System.out.println("Mês:");
        month = input.nextInt();
        System.out.println("Dia:");
        day = input.nextInt();

        System.out.println("Faz uma diferença de " + dayDiff(LocalDate.of(year, month, day)) + " dias para 1/1/1990");
    }


    public static int dayDiff(LocalDate date){
        LocalDate base = LocalDate.of(1900,1,1);

        int yearsDiff, daysDiff;

        yearsDiff = date.getYear() - base.getYear();

        daysDiff = yearsDiff * 365 + (yearsDiff/4);

        if ((date.getYear() % 4) == 0 && (date.getMonthValue() == 1 || date.getMonthValue() ==2)) daysDiff--;

        daysDiff += date.getDayOfYear();

        return daysDiff;
    }
}
