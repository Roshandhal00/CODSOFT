import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.File;

public class Codsoft_taskno2 {

	public static void main(String[] args) {
		
		 Scanner scanner = new Scanner(System.in);

	        // Step 1: Prompt user for input
	        System.out.print("Enter text or provide a file path to count words: ");
	        String input = scanner.nextLine();

	        String text;
	        if (input.endsWith(".txt")) {
	            // Step 2: Read input from file
	            text = readFile(input);
	        } else {
	            // Step 2: Read input as text
	            text = input;
	        }

	        // Step 3: Split the string into an array of words
	        String[] words = text.split("[\\s\\p{Punct}]+");

	        // Step 4: Initialize counter variable
	        int wordCount = 0;

	        // Step 7: Ignore common words
	        String[] stopWords = {"the", "and", "is", "in", "it", "to", "of", "this"};
	        Map<String, Integer> wordFrequency = new HashMap<>();

	        // Step 5: Iterate through the array of words
	        for (String word : words) {
	            // Step 7: Ignore common words
	            if (!isStopWord(word.toLowerCase(), stopWords)) {
	                wordCount++;
	                // Step 8: Update word frequency statistics
	                wordFrequency.put(word.toLowerCase(), wordFrequency.getOrDefault(word.toLowerCase(), 0) + 1);
	            }
	        }

	        // Step 6: Display the total count of words
	        System.out.println("Total words: " + wordCount);

	        // Step 8: Display word frequency statistics
	        System.out.println("Word Frequency Statistics:");
	        for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
	            System.out.println(entry.getKey() + ": " + entry.getValue());
	        }
	    }

	    private static String readFile(String filePath) {
	        StringBuilder content = new StringBuilder();
	        try {
	            Scanner fileScanner = new Scanner(new File(filePath));
	            while (fileScanner.hasNext()) {
	                content.append(fileScanner.nextLine()).append(" ");
	            }
	            fileScanner.close();
	        } catch (FileNotFoundException e) {
	            System.err.println("File not found. Please provide a valid file path.");
	            System.exit(1);
	        }
	        return content.toString();
	    }

	    private static boolean isStopWord(String word, String[] stopWords) {
	        for (String stopWord : stopWords) {
	            if (word.equals(stopWord)) {
	                return true;
	            }
	        }
	        return false;
	        

	}

}
