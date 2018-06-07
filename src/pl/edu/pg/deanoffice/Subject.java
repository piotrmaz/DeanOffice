package pl.edu.pg.deanoffice;


public class Subject implements Savable {

    private String name;

    public void info(){

        System.out.println("Nazwa przedmiotu: " + name);
    }

    /***************** metody wymagane przez interfejs Savable ********************/
    @Override
    public String getAllData() {
        String allData = "";
        allData += name + "\n";
        return allData;
    }

    @Override
    public String getFileName() {
        return "subject.txt";
    }



    /* ------------------- metody wymagane przez interfejs Savable ------------------- */

    public Subject(){

    }

    public Subject(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
