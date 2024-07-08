import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateFormatter {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        System.out.println(today);
        String formattedDate = today.format(DateTimeFormatter.ofPattern("yyyy-MMM-dd"));
        System.out.println(formattedDate);
    }
}
