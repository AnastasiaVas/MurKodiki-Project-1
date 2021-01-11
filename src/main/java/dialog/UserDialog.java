package dialog;

import project1.model.Person;

import java.util.*;

public class UserDialog {
    Scanner scanner = new Scanner(System.in);
    public List<Person> typePersonData() {
        System.out.println("Введите колличество персон которое вы хотите добавить в файл: ");
        long personNumber = scanner.nextLong();
        int personCounter = 1;
        List<Person> people = new ArrayList<>();
        int id = 0;
        String firstName = "";
        String lastName = "";
        int age = 0;
        String city = "";
        while (personNumber > 0) {
            System.out.print("Введите айди персоны №"+personCounter+" :");
            if (scanner.hasNextInt()) {
                id = scanner.nextInt();
            } else {
                System.out.println("Некорректные данные, попробуйте заново");
                typePersonData();
            }
            System.out.print("Введите имя персоны №"+personCounter+" :");
            if (scanner.hasNextLine()) {
                scanner.nextLine();
                firstName = scanner.nextLine();
            } else {
                System.out.println("Некорректные данные, попробуйте заново");
                typePersonData();
            }
            System.out.print("Введите фамилию персоны №"+personCounter+" :");
            if (scanner.hasNextLine()) {
                lastName = scanner.nextLine();
            } else {
                System.out.println("Некорректные данные, попробуйте заново");
                typePersonData();
            }
            System.out.print("Введите возраст персоны №"+personCounter+" :");
            if (scanner.hasNextInt()) {
                age = scanner.nextInt();
            } else {
                System.out.println("Некорректные данные, попробуйте заново");
                typePersonData();
            }
            System.out.print("Введите город в котором живет персона №"+personCounter+" :");
            if (scanner.hasNextLine()) {
                scanner.nextLine();
                city = scanner.nextLine();
            } else {
                System.out.println("Некорректные данные, попробуйте заново");
                typePersonData();
            }
            people.add(new Person(id,firstName,lastName,age,city));
            personNumber--;
            personCounter++;
        }
        return people;
    }
}
