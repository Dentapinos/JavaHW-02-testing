package homework;

import java.util.Objects;

public class Dancer {
    private int id;
    private final String name;
    private final DressCode dressCode;
    private boolean debt = false;

    public Dancer(String name, DressCode dressCode) {
        this.name = name;
        this.dressCode = dressCode;
    }

    public String getName() {
        return name;
    }

    public DressCode getDressCode() {
        return dressCode;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDebt(boolean debt) {
        this.debt = debt;
    }

    public boolean isDebt() {
        return debt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dancer dancer = (Dancer) o;
        return debt == dancer.debt && Objects.equals(name, dancer.name) && dressCode == dancer.dressCode;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, debt, dressCode);
    }

    @Override
    public String toString() {
        return "Dancer\n" +
                "id - " + id +
                "\nname - " + name +
                "\ndebt - " + debt +
                "\ndressCode = " + dressCode + "\n";
    }
}
