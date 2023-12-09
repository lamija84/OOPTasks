package week10;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

     class Events {

        private static final String[] EVENT_TYPES = {"Login", "Logout", "Purchase", "ViewPage", "Error"};
        private static final int NUMBER_OF_RECORDS = 1000000;

        public static void main(String[] args) {
            String filename = "events.txt";

            generateEventsFile(filename, NUMBER_OF_RECORDS);
            readEventsFile(filename);
        }

        // Method to generate events and write them to a file
        private static void generateEventsFile(String filename, int numberOfRecords) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
                Random random = new Random();

                for (int i = 0; i < numberOfRecords; i++) {
                    // Generate a random timestamp (replace this with your timestamp generation logic)
                    long timestamp = System.currentTimeMillis() - random.nextInt(365 * 24 * 60 * 60 * 1000);

                    // Select a random event type
                    String eventType = EVENT_TYPES[random.nextInt(EVENT_TYPES.length)];

                    // Generate a random user ID between 0 and 999
                    int userID = random.nextInt(1000);

                    // Write the event to the file
                    writer.write(timestamp + "," + eventType + "," + userID);
                    writer.newLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Method to read events from a file in multiple iterations and print them to the console
        private static void readEventsFile(String filename) {
            Path path = Paths.get(filename);

            try {
                for (int i = 1; i <= 5; i++) {
                    System.out.println("Iteration " + i + ":");
                    Files.lines(path).forEach(System.out::println);
                    System.out.println();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

