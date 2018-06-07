package pl.edu.pg.deanoffice;

public enum Status {
    /**
     * Oznacza, że student jest aktywny
     */
    ACTIVE("Aktywny", "Active"),
    /**
     * Oznacza, że student jest skreślony
     */
    DELETED("Skreślony", "Deleted"),
    /**
     * Oznacza, że student jest urlopowany
     */
    ON_BREAK("Urlopowany", "On break");

    // pola zwierajace tłumaczenia dla danej wartości enum
    private String valuePL;
    private String valueEN;

    // konstruktor pozwalający przypisać tłumaczenia do poszczególnych wartości enum
    Status(String valuePL, String valueEN) {
        this.valuePL = valuePL;
        this.valueEN = valueEN;
    }

    /////////////////////// gettery ///////////////////////
    public String getValuePL() {
        return valuePL;
    }

    public String getValueEN() {
        return valueEN;
    }
}
