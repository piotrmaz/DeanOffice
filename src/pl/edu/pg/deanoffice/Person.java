package pl.edu.pg.deanoffice;


public abstract class Person implements Savable{

    private Long id;
    protected String firstName;
    protected String lastName;
    protected Long pesel;

    public Person() {
    }

    public Person(String firstName, String lastName, Long pesel) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pesel = pesel;
    }

    public abstract void info();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Long getPesel() {
        return pesel;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPesel(Long pesel) {
        this.pesel = pesel;
    }
}
