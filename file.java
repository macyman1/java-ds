import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class file {
	public static void main(String[] args) {
		if (args.length != 2) {
			System.out.println("Usage: java file <inputFile> <outputFile>");
			return;
		}

		String inputFile = args[0];
		String outputFile = args[1];

		int vowelCount = 0;
		int consonantCount = 0;

		try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
			int ch;
			while ((ch = reader.read()) != -1) {
				char c = Character.toLowerCase((char) ch);
				if (c >= 'a' && c <= 'z') 
                {
					if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') 
                    {
						vowelCount++;
					} else 
                    {
						consonantCount++;
					}
				}
			}
		} catch (IOException e) {
			System.out.println("Error reading input file: " + e.getMessage());
			return;
		}

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
			writer.write("Vowels: " + vowelCount);
			writer.newLine();
			writer.write("Consonants: " + consonantCount);
			writer.newLine();
			System.out.println("Counts written to " + outputFile);
		} catch (IOException e) {
			System.out.println("Error writing output file: " + e.getMessage());
		}
	}
}
