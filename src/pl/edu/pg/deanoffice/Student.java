package pl.edu.pg.deanoffice;

public class Student extends Person implements Savable {

    private Integer albumNumber;
    private Status status = Status.ACTIVE;
    private int ects;

    private static Long currentId = 0L;

    public Student(){
        setId(currentId++);
    }

    public Student(String firstName, String lastName, Long pesel, Integer albumNumber, int ects) {
        super(firstName, lastName, pesel);
        this.albumNumber = albumNumber;
        this.ects = ects;
        setId(currentId++);
    }

    @Override
    public void info() {
        System.out.println("Student" + getId());
        System.out.println("imię: " + firstName);
        System.out.println("nazwisko: " + lastName);
        System.out.println("pesel: " + pesel);
        System.out.println("nr albumu: " + albumNumber);
        System.out.println("status: " + status.getValuePL());
        System.out.println("ects: " + ects);
        System.out.println();
    }

    @Override
    public String getAllData() {
        String allData = "";
        allData += getId() + ":";
        allData += firstName + ":";
        allData += lastName + ":";
        allData += pesel + ":";
        allData += albumNumber + ":";
        allData += status + ":";
        allData +=ects + "\n";
        return allData;
    }

    @Override
    public String getFileName() {
        return "student.txt";
    }


    public Integer getAlbumNumber() {
        return albumNumber;
    }

    public Status getStatus() {
        return status;
    }

    public void setEcts(int ects) {
        this.ects = ects;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setAlbumNumber(Integer albumNumber) {
        this.albumNumber = albumNumber;
    }
}
