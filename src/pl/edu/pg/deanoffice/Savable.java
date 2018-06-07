package pl.edu.pg.deanoffice;

public interface Savable {
    /**
     * Wygeneruj String zawierający zestaw informacji o obiekcie w takiej postaci, w jakiej chcemy by znalazły się w pliku
     */
    String getAllData();

    /**
     * Nazwa pliku do którego chcemy zapisywać informacje o obiektach tej klasy
     */
    String getFileName();

}
