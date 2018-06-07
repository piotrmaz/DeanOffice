package pl.edu.pg.deanoffice;

public class Grade implements Savable {
    private float value;
    private String shortName;
    private String longName;

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        if (value < 2.0 || value > 5.5) {
            System.out.println("nie wolno");
            this.value = (float) 2.0;
        } else {
            this.value = value;
        }
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getLongName() {
        return longName;
    }

    public void setLongName(String longName) {
        this.longName = longName;
    }

    @Override
    public String getAllData() {
        String allData = " ";
        allData += value +"/n";
        allData += shortName + "/n";
        allData += longName + "/n";
        return allData;
    }

    @Override
    public String getFileName() {
        return "Grade.txt";
    }
}
