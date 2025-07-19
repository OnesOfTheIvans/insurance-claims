import claim.processor.ClaimProcessor;
import claim.reader.CSVReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    private static final char SEPARATOR = ',';
    private static final double AMOUNT_LIMIT = 15000;
    private static final int MAX_HIGH_CLAIMS = 2;

    public static void main(String[] args) {
        if (args.length != 1) {
            logger.error("Path to source file must be provided as a command line argument");
            System.exit(1);
        }

        String sourceFilePath = args[0];
        if (!sourceFilePath.endsWith(".csv")) {
            logger.error("Source file must be a CSV file");
            System.exit(1);
        }

        try {
            var reader = new CSVReader(SEPARATOR);
            var claims = reader.read(sourceFilePath);
            var processor = new ClaimProcessor(claims, AMOUNT_LIMIT, MAX_HIGH_CLAIMS);
            int counter = 0;
            while (!processor.isQueueEmpty()) {
                System.out.println("=== Processing day Nr." + ++counter + " ===");
                processor.processDay();
            }
        } catch (IOException e) {
            logger.error("Error occurred while reading claims from file", e);
        }
    }
}
