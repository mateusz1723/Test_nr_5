package pl.kurs.figures.models;

import java.util.Objects;

public class MultiKey {

    private double key1;
    private double key2;

    public MultiKey(double key1, double key2) {
        this.key1 = key1;
        this.key2 = key2;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MultiKey twoKeys = (MultiKey) o;
        return Double.compare(twoKeys.key1, key1) == 0 && Double.compare(twoKeys.key2, key2) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(key1, key2);
    }
}
