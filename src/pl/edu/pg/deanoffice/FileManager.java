package pl.edu.pg.deanoffice;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Long.parseLong;

public class FileManager {

    public void save(Savable objectToSave) {
        File file = new File(objectToSave.getFileName());
        try {
            FileWriter fr = new FileWriter(file, true);
            fr.write(objectToSave.getAllData());
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Teacher> readTeachers() {
        List<Teacher> teachers = new ArrayList<>();
        try {
            File file = new File("teacher.txt");
            List<String> lines = Files.readAllLines(Paths.get(file.toURI()));

            for (String teacherLine : lines) {
                String[] teacherFields = teacherLine.split(":");
                Teacher teacher = new Teacher();
                teacher.setId(parseLong(teacherFields[0]));
                teacher.setFirstName(teacherFields[1]);
                teacher.setLastName(teacherFields[2]);
                teacher.setPesel(parseLong(teacherFields[3]));
                teacher.setDegree(teacherFields[4]);

                teachers.add(teacher);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


        return teachers;
    }

    public List<Student> readStudents() {
        List<Student> students = new ArrayList<>();
        try {
            File file = new File("student.txt");
            List<String> lines = Files.readAllLines(Paths.get(file.toURI()));

            for (String studentLine : lines) {
                String[] studentFields = studentLine.split(":");
                Student student = new Student();
                student.setId(parseLong(studentFields[0]));
                student.setFirstName(studentFields[1]);
                student.setLastName(studentFields[2]);
                student.setPesel(parseLong(studentFields[3]));
                student.setAlbumNumber(Integer.parseInt(studentFields[4]));
                student.setStatus(Status.valueOf(studentFields[5]));
                student.setEcts(Integer.parseInt(studentFields[6]));


                students.add(student);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


        return students;
    }

    public List<Subject> readSubjects() {
        List<Subject> subjects = new ArrayList<>();
        try {
            File file = new File("subject.txt");
            List<String> lines = Files.readAllLines(Paths.get(file.toURI()));

            for (String nameLine : lines) {
                Subject subject = new Subject();
                subject.setName(nameLine);
                subjects.add(subject);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return subjects;
    }

//    public List<Subject> readSubject() {
//
//        FileReader fr = null;
//        String linia = "";
//        try {
//            fr = new FileReader("subject.txt");
//        } catch (FileNotFoundException e) {
//            System.out.println("BŁĄD PRZY OTWIERANIU PLIKU!");
//            System.exit(1);
//        }
//
//        BufferedReader bfr = new BufferedReader(fr);
//        try {
//            while ((linia = bfr.readLine()) != null) {
//                System.out.println(linia);
//            }
//        } catch (IOException e) {
//            System.out.println("BŁĄD ODCZYTU Z PLIKU!");
//            System.exit(2);
//        }
//
//        try {
//            fr.close();
//        } catch (IOException e) {
//            System.out.println("BŁĄD PRZY ZAMYKANIU PLIKU!");
//            System.exit(3);
//        }
//        return null;
//    }
}
