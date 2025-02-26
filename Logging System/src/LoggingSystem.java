import com.logging.LogLevel;
import com.logging.Logger;
import com.logging.LoggerFactory;

public class LoggingSystem {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.createLogger();

        logger.log(LogLevel.INFO, "AUTH_MODULE", "User login successful.");
        logger.log(LogLevel.DEBUG, "PAYMENT_MODULE", "Payment initiated.");
        logger.log(LogLevel.WARN, "SECURITY_MODULE", "Possible security breach detected.");
        logger.log(LogLevel.ERROR, "SYSTEM_MODULE", "Critical system failure!");
    }
}


