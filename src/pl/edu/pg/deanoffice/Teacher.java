package pl.edu.pg.deanoffice;

public class Teacher extends Person implements Savable {

    private String degree;
 //   private Long id;

    // przykład użycia zmiennej statycznej - numerowanie nauczycieli
    private static Long currentId = 0L;

    public Teacher() {
        setId(currentId++);
    }

    public Teacher(String firstName, String lastName, Long pesel) {
        super(firstName, lastName, pesel);
        setId(currentId++);       // przydziel identyfikator, następnie zwiększ licznik o 1
    }

    @Override
    public void info() {
        System.out.println("Nauczyciel " + getId());
        System.out.println("imię: " + firstName);
        System.out.println("nazwisko: " + lastName);
        System.out.println("pesel: " + pesel);
        System.out.println("stopień: " + degree);
        System.out.println();       // wypisz linię odstępu
    }

    public String getAllData() {
        String allData = "";
        allData += getId() + ":";
        allData += firstName + ":";
        allData += lastName + ":";
        allData += pesel + ":";
        allData += degree + "\n";
        return allData;
    }

    /* ------------------- metody wymagane przez interfejs Savable ------------------- */
    @Override
    public String getFileName() {
        return "teacher.txt";
    }

    @Override
    public String toString() {
        return this.firstName + " " + this.lastName + " " + this.pesel + " " + this.degree;
    }


    ////////////////////////// gettery i settery //////////////////////////

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }


}
