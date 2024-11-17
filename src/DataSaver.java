import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DataSaver {

    public static void main(String[] args) {
        ArrayList<String> records = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter First Name: ");
            String firstName = scanner.nextLine();

            System.out.print("Enter Last Name: ");
            String lastName = scanner.nextLine();

            System.out.print("Enter ID Number: ");
            String idNumber = String.format("%06d", Integer.parseInt(scanner.nextLine()));

            System.out.print("Enter Email: ");
            String email = scanner.nextLine();

            System.out.print("Enter Year of Birth: ");
            int yearOfBirth = Integer.parseInt(scanner.nextLine());

            String record = String.format("%s, %s, %s, %s, %d", firstName, lastName, idNumber, email, yearOfBirth);
            records.add(record);

            System.out.print("Do you want to add another record? (yes/no): ");
            if (!scanner.nextLine().equalsIgnoreCase("yes")) {
                break;
            }
        }

        System.out.print("Enter the file name to save (with .csv extension): ");
        String fileName = scanner.nextLine();

        try (FileWriter fileWriter = new FileWriter("src/" + fileName)) {
            for (String record : records) {
                fileWriter.write(record + "\n");
            }
            System.out.println("Data saved to " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}