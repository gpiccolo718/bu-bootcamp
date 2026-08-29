import java.io.BufferedReader;
import java.io.FileReader; 
import java.io.IOException;
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.FileWriter;
 
public class GradeAnalyzer {
    public static void main(String[] args) {

        int high = Integer.MIN_VALUE;
        int low = Integer.MAX_VALUE;

        ArrayList<Integer> scores = readScores("scores.txt");

        if (scores.isEmpty()) {
            System.out.println("No valid scores found.");
            return;
        }

        for (int score : scores) {
            if (score > high) {
                high = score;
            }

            if (score < low) {
                low = score;
            }
        }

        double avg = calculateAverage(scores);

        writeReport(scores, avg, high, low, "report.txt");
        // Step 1: read scores from file
        // Step 2: calculate statistics
        // Step 3: write and print report
    } 

    // Returns a list of valid scores read from the file
    public static ArrayList<Integer> readScores(String filename) {
        // your code here
        ArrayList<Integer> scores = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();

                if (line.isEmpty()) {
                    continue;
                }

                try {
                    int n = Integer.parseInt(line.trim());
                    scores.add(n);
                } catch (NumberFormatException e) {
                    System.out.println("Skipping invalid value: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Could not read file: " + e.getMessage());
        }
        return scores;
    }

    // Returns the average of a list of scores, or 0.0 if the list is empty
    public static double calculateAverage(ArrayList<Integer> scores) {
        // your code here
        if (scores.size() == 0) {
            return 0.0;
        } else {

            double total = 0.0;
            for (int score : scores) {
                total += score;
            }
            
            return total / scores.size();
        }
    } 

    // Writes and prints the report
    public static void writeReport(ArrayList<Integer> scores,
                                   double avg, int high, int low,
                                   String outputFile) {
        // your code here

        // Count Grades
        int countA = 0;
        int countB = 0;
        int countC = 0;
        int countD = 0;
        int countF = 0;

        for (int score : scores) {
            if (score >= 90) {
                countA++;
            } else if (score >= 80) {
                countB++;
            } else if (score >= 70) {
                countC++;
            } else if (score >= 60) {
                countD++;
            } else {
                countF++;
            }
        }

        outputFile = "report.txt";
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            
            writer.write(String.format("Average score: %.2f%n", avg));
            System.out.println(String.format("Average score: %.2f", avg));

            writer.write(String.format("Highest score: %d%n", high));
            System.out.println(String.format("Highest score: %d", high));

            writer.write(String.format("Lowest score: %d%n", low));
            System.out.println(String.format("Lowest score: %d", low));

            writer.write(String.format("%nGrade Distribution:%n"));
            System.out.println("\nGrade Distribution:");

            writer.write(String.format("A (90-100): %d%n", countA));
            System.out.println(String.format("A (90-100): %d", countA));

            writer.write(String.format("B (80-89): %d%n", countB));
            System.out.println(String.format("B (80-89): %d", countB));

            writer.write(String.format("C (70-79): %d%n", countC));
            System.out.println(String.format("C (70-79): %d", countC));

            writer.write(String.format("D (60-69): %d%n", countD));
            System.out.println(String.format("D (60-69): %d", countD));

            writer.write(String.format("F (below 60): %d%n", countF));
            System.out.println(String.format("F (below 60): %d", countF));

        } catch (IOException e) {
            System.out.println("Could not write file: " + e.getMessage());
        }
    }
} 


