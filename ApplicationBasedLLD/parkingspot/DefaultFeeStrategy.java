import java.util.Date;

public class DefaultFeeStrategy implements FeeStrategy {
    @Override
    public double calculateFee(Ticket ticket) {
        // Implement your fee calculation logic here
        // For example, you can calculate the fee based on the duration of parking
        long durationInMinutes = new Date().getTime() - ticket.entryTime.getTime();
        durationInMinutes /= 60000; // Convert milliseconds to minutes
        double ratePerMinute = 0.05; // Example rate
        return durationInMinutes * ratePerMinute;
    }
    
}
