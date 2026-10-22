import java.util.Random;

public class Lab1 {

    static void allotRooms(String[] students, String[] gender) {

        String[][] rooms = new String[10][2];

        Random random = new Random();

        
        for (int i = students.length - 1; i > 0; i--) {

            int j = random.nextInt(i + 1);

            String temp = students[i];
            students[i] = students[j];
            students[j] = temp;

            temp = gender[i];
            gender[i] = gender[j];
            gender[j] = temp;
        }

        int student = 0;

        
        for (int i = 0; i < 10; i++) {

            for (int j = 0; j < 2; j++) {

                if (student < students.length) {

                    rooms[i][j] = students[student]
                            + " (" + gender[student] + ")";

                    student++;
                }
            }
        }

        
        System.out.println("Room Allotment:");

        for (int i = 0; i < 10; i++) {

            System.out.print("Room " + (i + 1) + ": ");

            for (int j = 0; j < 2; j++) {

                if (rooms[i][j] != null) {
                    System.out.print(rooms[i][j] + " ");
                }
            }

            System.out.println();
        }

        
        if (student < students.length) {

            System.out.println("\nRemaining Student:");

            for (int i = student; i < students.length; i++) {
                System.out.println(
                    students[i] + " (" + gender[i] + ")"
                );
            }
        }
    }

    public static void main(String[] args) {

        String[] students = {
            "UG1", "UG2", "UG3", "UG4", "UG5",
            "UG6", "UG7", "UG8", "UG9", "UG10",
            "UG11", "PG1", "PG2", "PG3", "PG4",
            "PG5", "PG6", "PG7", "PG8", "PG9",
            "PG10"
        };

        String[] gender = {
            "Male", "Female", "Male", "Female", "Male",
            "Female", "Male", "Female", "Male", "Female",
            "Male", "Female", "Male", "Female", "Male",
            "Female", "Male", "Female", "Male", "Female",
            "Male"
        };

        allotRooms(students, gender);
    }
          }
