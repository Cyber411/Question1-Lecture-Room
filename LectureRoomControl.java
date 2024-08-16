/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package question_one.lectureroomcontrol;

/**
 *
 * @author USER
 */
import java.util.Scanner;

// Main class to control the Lecture Room
public class LectureRoomControl {

    // Inner class to represent a Lecture Room
    static class LectureRoom {
        private int studentCount;      // Number of students in the room
        private boolean[] lightStatus; // Array to keep track of the lights (ON/OFF)

        // Constructor to initialize the room
        public LectureRoom() {
            this.studentCount = 0;     // Initially, there are no students
            this.lightStatus = new boolean[3]; // Initialize 3 lights, all off (false)
        }

        // Method to add students to the room
        public void addStudents(int number) {
            this.studentCount += number; // Increase the number of students
            System.out.println(number + " students added. Total students: " + this.studentCount);
        }

        // Method to remove students from the room
        public void removeStudents(int number) {
            // Remove students but ensure the number of students doesn't go below zero
            if (this.studentCount >= number) {
                this.studentCount -= number;
            } else {
                this.studentCount = 0;
            }
            System.out.println(number + " students removed. Total students: " + this.studentCount);
        }

        // Method to turn on a specific light
        public void turnOnLight(int lightNumber) {
            // Check if the light number is valid (1, 2, or 3)
            if (lightNumber >= 1 && lightNumber <= 3) {
                this.lightStatus[lightNumber - 1] = true; // Turn on the light
                System.out.println("Light " + lightNumber + " is now ON.");
            } else {
                System.out.println("Invalid light number. Choose 1, 2, or 3.");
            }
        }

        // Method to turn off a specific light
        public void turnOffLight(int lightNumber) {
            // Check if the light number is valid (1, 2, or 3)
            if (lightNumber >= 1 && lightNumber <= 3) {
                this.lightStatus[lightNumber - 1] = false; // Turn off the light
                System.out.println("Light " + lightNumber + " is now OFF.");
            } else {
                System.out.println("Invalid light number. Choose 1, 2, or 3.");
            }
        }

        // Method to display the current status of the room
        public void displayStatus() {
            System.out.println("Total students: " + this.studentCount); // Show total number of students
            System.out.println("Lights status: "); // Show the status of each light
            for (int i = 0; i < lightStatus.length; i++) {
                System.out.println("Light " + (i + 1) + ": " + (lightStatus[i] ? "ON" : "OFF"));
            }
        }
    }

    // Main method to interact with the user and control the Lecture Room
    public static void main(String[] args) {
        LectureRoom room = new LectureRoom(); // Create a new LectureRoom object
        Scanner scanner = new Scanner(System.in); // Create a Scanner object for user input
        char choice;

        do {
            // Display menu options to the user
            System.out.println("\nLecture Room Control Menu:");
            System.out.println("W - Add students");
            System.out.println("X - Remove students");
            System.out.println("Y - Turn on a light");
            System.out.println("Z - Turn off a light");
            System.out.println("Q - Quit");
            System.out.print("Enter your choice: ");
            choice = scanner.next().charAt(0); // Read the user's choice

            switch (choice) {
                case 'W':
                    // Handle adding students
                    System.out.print("Enter number of students to add: ");
                    int studentsToAdd = scanner.nextInt();
                    room.addStudents(studentsToAdd);
                    break;

                case 'X':
                    // Handle removing students
                    System.out.print("Enter number of students to remove: ");
                    int studentsToRemove = scanner.nextInt();
                    room.removeStudents(studentsToRemove);
                    break;

                case 'Y':
                    // Handle turning on a light
                    System.out.print("Enter the light number to turn on (1-3): ");
                    int lightOn = scanner.nextInt();
                    room.turnOnLight(lightOn);
                    break;

                case 'Z':
                    // Handle turning off a light
                    System.out.print("Enter the light number to turn off (1-3): ");
                    int lightOff = scanner.nextInt();
                    room.turnOffLight(lightOff);
                    break;

                case 'Q':
                    // Handle quitting the program
                    System.out.println("Exiting the program.");
                    break;

                default:
                    // Handle invalid choices
                    System.out.println("Invalid choice. Please choose again.");
            }

            // Display the status of the room after each operation
            room.displayStatus();

        } while (choice != 'Q'); // Continue the loop until the user chooses 'Q'

        scanner.close(); // Close the scanner
    }
}
