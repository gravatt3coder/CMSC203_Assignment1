//////////////////
// Class CMSC 203
//Instructor: Grinberg
//Description ESP Guessing Game  - Assignment 1
// Due 9/15/2025
//Platform Mac / IDE IntelliJI pledge I have done this independently /and have neither given nor received information or assistance about this assignment.
// Robert Gravatt

import java.io.*;
import java.util.Scanner;
import java.util.Random;



public class program1 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        while (true) {
            // Menu
            System.out.println("\n--- ESP Color Game Menu ---");
            System.out.println("a. First 16 colors");
            System.out.println("b. First 10 colors");
            System.out.println("c. First 5 colors");
            System.out.println("d. Exit");
            System.out.print("Choose: ");
            String choice = sc.nextLine().toLowerCase();

            int numberOfColors = 0;
            if (choice.equals("a")) numberOfColors = 16;
            else if (choice.equals("b")) numberOfColors = 10;
            else if (choice.equals("c")) numberOfColors = 5;
            else if (choice.equals("d")) break;
            else continue;

            // Read colors
            String[] colors = new String[numberOfColors];
            Scanner fileScan = new Scanner(new File("colors.txt"));
            for (int i = 0; i < numberOfColors; i++) {
                colors[i] = fileScan.nextLine();
            }
            fileScan.close();

            // Show available (classic for-loop instead of for-each)
            System.out.println("\nAvailable colors:");
            for (int i = 0; i < colors.length; i++) {
                System.out.print(colors[i] + " ");
            }
            System.out.println();

            // Play 3 rounds
            int correct = 0;
            for (int round = 1; round <= 3; round++) {
                String comp = colors[rand.nextInt(numberOfColors)];
                System.out.print("\nRound " + round + " – Guess the color: ");
                String guess = sc.nextLine();
                System.out.println("Computer chose: " + comp);
                if (guess.equalsIgnoreCase(comp)) correct++;
            }

            // Student info
            System.out.print("\nYour name: ");
            String name = sc.nextLine();
            System.out.print("Describe yourself: ");
            String desc = sc.nextLine();
            System.out.print("Due date (MM/DD/YY): ");
            String dueDate = sc.nextLine();

            // Results
            String results = "\nGame Over\nYou guessed " + correct + " out of 3 correctly.\n" +
                             "Name: " + name + "\n" +
                             "Description: " + desc + "\n" +
                             "Due Date: " + dueDate + "\n";

            System.out.println(results);

            // Write to file
            PrintWriter pw = new PrintWriter(new FileWriter("EspGameResults.txt", true));
            pw.println(results);
            pw.close();
        }
    }
}
