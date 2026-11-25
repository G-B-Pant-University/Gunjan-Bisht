import java.util.Random;

public class lab2 {

    static class Student {
        String name, gender;

        Student(String name, String gender) {
            this.name = name;
            this.gender = gender;
        }
    }

    static class Room {
        int no;
        Student s1, s2;

        Room(int no) {
            this.no = no;
        }

        boolean allot(Student s) {
            if (s1 == null) {
                s1 = s;
                return true;
            }
            if (s2 == null && s1.gender.equals(s.gender)) {
                s2 = s;
                return true;
            }
            return false;
        }

        void display() {
            System.out.print("Room " + no + ": ");
            if (s1 != null)
                System.out.print(s1.name + " (" + s1.gender + ") ");
            if (s2 != null)
                System.out.print(s2.name + " (" + s2.gender + ")");
            System.out.println();
        }
    }

    public static void main(String[] args) {

        Student[] s = {
            new Student("UG1","M"), new Student("UG2","F"),
            new Student("UG3","M"), new Student("UG4","F"),
            new Student("UG5","M"), new Student("UG6","F"),
            new Student("UG7","M"), new Student("UG8","F"),
            new Student("UG9","M"), new Student("UG10","F"),
            new Student("UG11","M"), new Student("PG1","F"),
            new Student("PG2","M"), new Student("PG3","F"),
            new Student("PG4","M"), new Student("PG5","F"),
            new Student("PG6","M"), new Student("PG7","F"),
            new Student("PG8","M"), new Student("PG9","F"),
            new Student("PG10","M")
        };

        Random r = new Random();

        for (int i = s.length - 1; i > 0; i--) {
            int j = r.nextInt(i + 1);
            Student t = s[i];
            s[i] = s[j];
            s[j] = t;
        }

        Room[] rooms = new Room[10];

        for (int i = 0; i < 10; i++)
            rooms[i] = new Room(i + 1);

        boolean[] allotted = new boolean[21];

        for (int i = 0; i < 21; i++)
            for (int j = 0; j < 10; j++)
                if (!allotted[i] && rooms[j].allot(s[i])) {
                    allotted[i] = true;
                    break;
                }

        System.out.println("Room Allotment:");

        for (Room room : rooms)
            room.display();

        System.out.println("\nRemaining Student:");

        for (int i = 0; i < 21; i++)
            if (!allotted[i])
                System.out.println(s[i].name + " (" + s[i].gender + ")");
    }
}
