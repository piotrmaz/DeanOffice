package pl.edu.pg.deanoffice.application;


import pl.edu.pg.deanoffice.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Application {

    public static List<Person> people = new ArrayList<>();
    public static List<Subject> subjects = new ArrayList<>();
    public static List<Teacher> teachers = new ArrayList<>();

    public static int menu() {
        System.out.println();
        System.out.println("     ****************************************");
        System.out.println("     *                 MENU                 *");
        System.out.println("     ****************************************");
        System.out.println("     1. Dodaj studenta, nauczyciela lub przedmiot");
        System.out.println("     2. Zapisz dane");
        System.out.println("     3. Wczytaj wszystkie dane");
        System.out.println("     4. Wczytaj studentow");
        System.out.println("     5. Wczytaj nauczycieli");
        System.out.println("     6. Wczytaj przedmioty");
        System.out.println("     0. Zakoncz i wyswietl");

        Scanner in = new Scanner(System.in);
        int w = in.nextInt();

        return w;
    }


    public static void main(String[] args) {

        FileManager fileManager = new FileManager();

        int wybor = 999;
        while (wybor != 0) {
            wybor = menu();
            switch (wybor) {
                case 1:
                    showAddOption();
                    break;
                case 2:
                    System.out.format("Zapisywanie danych");
                    for (Person person : people) {
                        fileManager.save(person);
                    }
                    for ( Subject subject:subjects) {
                        fileManager.save(subject);
                    }
                    for (Teacher teacher: teachers) {
                        fileManager.save(teacher);
                    }
                    break;
                case 3:
                    System.out.println("Wczytywanie danych");
                    List<Teacher> teachers = fileManager.readTeachers();
                    List<Student> students = fileManager.readStudents();
                    subjects = fileManager.readSubjects();
                    people.addAll(teachers);
                    people.addAll(students);
                    subjects.addAll(subjects);


                    break;
                case 4:
                    System.out.println("Wczytywanie studentow");
                    students = fileManager.readStudents();
                    people.addAll(students);
                    break;
                case 5:
                    System.out.println("Wczytywanie nauczycieli");
                    teachers = fileManager.readTeachers();
                    people.addAll(teachers);
                    break;
                case 6:
                      System.out.println("Wczytywanie przedmiotow");
                      subjects = fileManager.readSubjects();
                      subjects.addAll(subjects);


                   break;
            }
        }


//        Teacher t = new Teacher("Janusz", "Kowalski", 231231231L);
//        t.setDegree("dr hab.");


        for (Person person : people) {
            person.info();
        }

        for (Subject subject:subjects){
            subject.info();
        }
        for (Teacher teacher: teachers){
            teacher.info();
        }
       //        Subject sub = new Subject("Algebra liniowa");

//        FileManager fileManager = new FileManager();
//        fileManager.save(t);
//        fileManager.save(s);
//        fileManager.save(s1);
//        fileManager.save(sub);

    }

    public static void showAddOption() {
        System.out.println("**************************************");
        System.out.println("1-Dodaj studenta");
        System.out.println("2-Dodaj nauczyciela");
        System.out.println("3-Dodaj przedmiot");
        System.out.println("4-Wróć do poprzedniego menu");
        System.out.println("**************************************");

        Scanner in = new Scanner(System.in);
        int wybor = in.nextInt();

        switch (wybor) {
            case 1:
                Student student = addStudent();
                people.add(student);
                break;
            case 2:
                Teacher teacher = addTeacher();
                people.add(teacher);
                break;
            case 3:
                Subject subject = addSubject();
                subjects.add(subject);
                break;
            case 4:
                System.out.println("Powrot");
                break;
            default:
                break;
        }
    }

    public static Student addStudent() {
        Scanner scanner = new Scanner(System.in);

        Student student = new Student();
        System.out.println("Dodaj studenta");
        System.out.print("Imie: ");
        String imie = scanner.nextLine();
        System.out.print("Nazwisko: ");
        String nazwisko = scanner.nextLine();
        System.out.print("Pesel: ");
        Long pesel = scanner.nextLong();
        System.out.print("Numer albumu: ");
        Integer nrAlbumu = scanner.nextInt();
        System.out.print("Status: 1. Aktywny, 2. Urlopowany, 3. Skreslony ");
        int status = scanner.nextInt();
        System.out.println("Punkty ects: ");
        int ects = scanner.nextInt();

        switch(status){
            case 1:
                student.setStatus(Status.ACTIVE);
                break;
            case 2:
                student.setStatus(Status.ON_BREAK);
                break;
            case 3:
                student.setStatus(Status.DELETED);
                break;
        }


        student.setFirstName(imie);
        student.setLastName(nazwisko);
        student.setPesel(pesel);
        student.setAlbumNumber(nrAlbumu);
        student.setEcts((ects));
        return student;
    }


    public static Teacher addTeacher() {
        Scanner scanner = new Scanner(System.in);

        Teacher teacher = new Teacher();
        System.out.println("Dodaj nauczyciela");
        System.out.print("Imie: ");
        String imie = scanner.nextLine();
        teacher.setFirstName(imie);
        System.out.print("Nazwisko: ");
        String nazwisko = scanner.nextLine();
        teacher.setLastName(nazwisko);
        System.out.print("Stopien naukowy: ");
        String stopienNaukowy = scanner.nextLine();
        teacher.setDegree(stopienNaukowy);
        System.out.print("PESEL: ");
        Long pesel = scanner.nextLong();
        teacher.setPesel(pesel);

        teacher.setFirstName(imie);
        teacher.setLastName(nazwisko);
        teacher.setDegree(stopienNaukowy);
        teacher.setPesel(pesel);
        return teacher;
    }

    public static Subject addSubject() {
        Scanner scanner = new Scanner(System.in);

        Subject subject = new Subject();
        System.out.println("Dodaj przedmiot");
        System.out.print("Nazwa: ");
        String nazwa = scanner.nextLine();
        subject.setName(nazwa);


        return subject;
    }

}
