package project1;

import dialog.UserDialog;
import org.json.simple.parser.ParseException;
import project1.cmd.Executable;
import project1.io.FileHelper;
import project1.model.Person;
import util.Constants.Cmd;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class UserDialogController {

    private final static char POINT = '.';
    private final FormatFactory factory = new FormatFactory();
    private final UserDialog userDialog = new UserDialog();
    private final Scanner scanner = new Scanner(System.in);
    public static String fileName;
    Executable executable;
    String fieldToBeUpdated = "";
    String valueToUpdate = "";
    int idUpdate = 0;
    FileHelper fileHelper = new FileHelper();

    public void start() throws IOException, ParseException {
        while (true) {
            try {
                System.out.println("                Добро пожаловать в главное меню программы комманды \"МурКодики\"");
                System.out.println("Пожалуйста, введите название и тип файла с которым вы хотите работать (например: gymPersonBase.yaml)");
                fileName = scanner.nextLine();
                String format = determineFormat();
                executable = factory.getInstance(format);
                mainMenu();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    // todo перенести прием данных в юзер диалог, а обработку в контроллер
    public void mainMenu() throws IOException, ParseException {
        while (true) {
            try {
                System.out.println("\n      Пожалуйста, введите одну из доступных комманд");
                System.out.println("(create, read, update, delete, exit, help, switch, start)");
                String cmd = scanner.nextLine();
                executeCmd(fileName, cmd);
                break;
            } catch (FileNotFoundException | ClassNotFoundException e) {
                System.out.println("Файл не существует. Пожалуйста, создайте файл перед чтением либо выберите другой.");
            }
        }
    }

    // отдает формат файла
    private String determineFormat() {
        return fileName.substring(fileName.lastIndexOf(POINT) + 1);
    }

    private void executeCmd(String fileName, String cmd) throws IOException, ParseException, ClassNotFoundException {
        switch (cmd) {
            case Cmd.CREATE:
                List<Person> personsCreate = userDialog.typePersonData();
                executable.create(personsCreate);
                System.out.println("Файл был успешно создан");
                mainMenu();
            case Cmd.READ:
                List<Person> personsRead = executable.read();
                for (Person p : personsRead) {
                    System.out.println(p);
                }
                mainMenu();
            case Cmd.UPDATE:
                if (fileHelper.fileExists()) {
                    System.out.println("Введите id персоны которую вы хотите изменить");
                    if (scanner.hasNextInt()) {
                        idUpdate = scanner.nextInt();
                        scanner.nextLine();
                    } else {
                        System.out.println("Некорректно введенный айди пользователя");
                        mainMenu();
                    }
                    System.out.println("Введите какое значение вы хотите изменить (id, fname, lname, age, city)");
                    if (scanner.hasNextLine()) {
                        fieldToBeUpdated = scanner.nextLine();
                    } else {
                        System.out.println("Некорректно введенный айди пользователя");
                        mainMenu();
                    }
                    System.out.println("Введите новое значение выбранного поля");
                    if (scanner.hasNextLine()) {
                        valueToUpdate = scanner.nextLine();
                    } else {
                        System.out.println("Некорректно введенный айди пользователя");
                        mainMenu();
                    }
                    executable.update(idUpdate, fieldToBeUpdated, valueToUpdate);
                    System.out.println("Редактирование успешно завершено");
                    mainMenu();
                } else{
                  throw new FileNotFoundException();
                }
            case Cmd.DELETE:
                if (fileHelper.fileExists()) {
                System.out.println("Введите айди пользователя, которого вы хотите удалить");
                if (scanner.hasNextInt()) {
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    executable.delete(id);
                } else {
                    System.out.println("Некорректно введенный айди пользователя");
                    mainMenu();
                }
                System.out.println("Удаление выбранной вами персоны успешно завершено");
                mainMenu();
                } else{
                    throw new FileNotFoundException();
                }
            case Cmd.EXIT:
                System.out.println("Вы точно хотите выйти? Yes / No ");
                String exitConformation = scanner.nextLine();
                if (exitConformation.equalsIgnoreCase("Yes")) {
                    System.out.println("До новых встреч");
                    System.exit(0);
                } else if (exitConformation.equalsIgnoreCase("No")) {
                    System.out.println("Введите желаемую комманду");
                    mainMenu();
                } else {
                    System.out.println("Команда подтверждения выхода была введена неправильно, попробуйте ещё раз ввести команду выхода");
                    mainMenu();
                }
            case Cmd.HELP:
                System.out.println("Данная программа предназначена для создания, редактирования, удаления и чтения списка персон\n" +
                        "Для работы доступно 5 файловых форматов: .bin, .json, .csv, .xml и .yaml.\n" +
                        "Каждая персона должна иметь свой уникальный id, имя, фамилию, возраст и город проживания.\n" +
                        "Описание доступных комманд:\n" +
                        "create – если файл существует новая запись добавляется в файл. Если не существует – создание нового файла по записям.\n" +
                        "read - при вводе данной команды в консоле отобразиться содержимое файла с которым вы работаете.\n" +
                        "update - при вводе данной команды вам предложат выбрать id,\n" +
                        "по которому будет осуществлятся изменения характеристики.\n" +
                        "Далее вам предложать выбрать ту характеристику, которую вы хотите изменить\n" +
                        "(id -Id персоны, fname - Имя персоны, lname - Фамилия персоны,\n" +
                        "age - Возраст персоны, city - Город, в котором живет персона).\n" +
                        "delete - при вводе данной команды вам предложат выбрать id, по которому будет\n" +
                        "осуществлятся удаление выбранной по id персоны\n" +
                        "exit - при вводе данной команды выполнится вход в меню выхода из программы.\n" +
                        "При вводе \"Yes\" производится выход из программы,\n" +
                        "а при вводе \"No\" - выполняется возврат к вводу комманд. \n" +
                        "switch - при вводе данной команды выполнится возврат в главное меню с возможностью выбора нового файла\n" +
                        "start - осуществляет сохранение измененных данных\n");
                mainMenu();
            case Cmd.SWITCH:
                start();
            case Cmd.START:
                start();
            default:
                System.out.printf("Command %s is not supported command", cmd);
                mainMenu();
        }
    }
}
