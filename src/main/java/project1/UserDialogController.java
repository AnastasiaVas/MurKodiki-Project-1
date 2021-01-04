package project1;

import dialog.UserDialog;
import org.json.simple.parser.ParseException;
import project1.cmd.Executable;
import project1.model.Person;
import util.Constants.Cmd;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class UserDialogController {

    private final static char POINT = '.';
    private final FormatFactory factory = new FormatFactory();
    private final UserDialog userDialog = new UserDialog();
    private final Scanner scanner = new Scanner(System.in);
    Executable executable;
    String fieldToBeUpdated = "";
    String valueToUpdate = "";
    int idUpdate = 0;


    public void start() throws IOException, ParseException {
        System.out.println("Добро пожаловать в главное меню программы комманды \"МурКодики\"");
        System.out.println("Пожалуйста, введите название и тип файла с которым вы хотите работать (например: gymPersonBase.yaml)");
        String fileName = scanner.nextLine();
        String format = determineFormat(fileName);
        executable = factory.getInstance(format);
        System.out.println("Пожалуйста, введите одну из доступных комманд");
        System.out.println("(create, read, update, delete, exit, help, switch, start)");
        executeCmd(fileName);
    }

    // отдает формат файла
    private String determineFormat(String fileName) {
        return fileName.substring(fileName.lastIndexOf(POINT) + 1);
    }

    private void executeCmd(String fileName) throws IOException, ParseException {
        String cmd = scanner.nextLine();
        switch (cmd) {
            case Cmd.CREATE:
                List<Person> personsCreate = userDialog.typePersonData();
                executable.create(personsCreate, fileName);
                System.out.println("Файл был успешно создан");
                executeCmd(fileName);
            case Cmd.READ:
                List<Person> personsRead = executable.read(fileName);
                for (Person p : personsRead) {
                    System.out.println(p);
                }
                executeCmd(fileName);
            case Cmd.UPDATE:
                System.out.println("Введите id персоны которую вы хотите изменить");
                if (scanner.hasNextInt()) {
                    idUpdate = scanner.nextInt();
                    scanner.nextLine();
                } else {
                    System.out.println("Некорректно введенный айди пользователя");
                    executeCmd(fileName);
                }
                System.out.println("Введите какое значение вы хотите изменить (id, fname, lname, age, city)");
                if (scanner.hasNextLine()) {
                    fieldToBeUpdated = scanner.nextLine();
                } else {
                    System.out.println("Некорректно введенный айди пользователя");
                    executeCmd(fileName);
                }
                System.out.println("Введите новое значение выбранного поля");
                if (scanner.hasNextLine()) {
                    valueToUpdate = scanner.nextLine();
                } else {
                    System.out.println("Некорректно введенный айди пользователя");
                    executeCmd(fileName);
                }
                executable.update(idUpdate, fieldToBeUpdated, valueToUpdate, fileName);
                System.out.println("Редактирование успешно завершено");
                executeCmd(fileName);
            case Cmd.DELETE:
                System.out.println("Введите айди пользователя, которого вы хотите удалить");
                if (scanner.hasNextInt()) {
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    executable.delete(id, fileName);
                } else {
                    System.out.println("Некорректно введенный айди пользователя");
                    executeCmd(fileName);
                }
                System.out.println("Удаление выбранной вами персоны успешно завершено");
                executeCmd(fileName);
            case Cmd.EXIT:
                System.out.println("Вы точно хотите выйти? Yes / No ");
                String exitConformation = scanner.nextLine();
                if (exitConformation.equalsIgnoreCase("Yes")) {
                    System.out.println("До новых встреч");
                    System.exit(0);
                } else if (exitConformation.equalsIgnoreCase("No")) {
                    System.out.println("Введите желаемую комманду");
                    executeCmd(fileName);
                } else {
                    System.out.println("Команда подтверждения выхода была введена неправильно, попробуйте ещё раз ввести команду выхода");
                    executeCmd(fileName);
                }
            case Cmd.HELP:
                System.out.println("Данная программа предназначена для создания, редактирования, удаления и чтения списка персон");
                System.out.println("                  в пяти форматах: Binary, Json, Csv, Xml и Yaml.");
                System.out.println("Каждая персона должна иметь свой уникальный id, имя, фамилию, возраст и город проживания.");
                System.out.println("Описание доступных комманд:");
                System.out.println("create – если файл существует новая запись добавляется в файл. Если не существует – создание нового файла по записям.");
                System.out.println("read - чтение выбранного файла");
                System.out.println("update - изменение чего-то там");
                System.out.println("delete - удаление персоны. Предлагаеться выбрать id по которому будет осущетсвляться удаление");
                System.out.println("exit - вход в меню выхода из программы. При вводе \"Yes\" производится выход из программы,");
                System.out.println("а при вводе \"No\" - выполняется возврат к вводу комманд. ");
                System.out.println("switch - осуществляет возврат в главное меню");
                System.out.println("start - осуществляет сохранение измененных данных");
                System.out.println("Введите желаемую комманду");
                executeCmd(fileName);
            case Cmd.SWITCH:
                start();
            default:
                System.out.printf("Command %s is not supported command", cmd);
                executeCmd(fileName);
        }
    }
}
