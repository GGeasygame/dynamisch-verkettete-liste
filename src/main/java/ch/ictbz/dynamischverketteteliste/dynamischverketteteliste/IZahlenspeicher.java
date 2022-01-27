package ch.ictbz.dynamischverketteteliste.dynamischverketteteliste;

public interface IZahlenspeicher <T extends Comparable<T>> {
    /**
     * Fügt eine Zahl in den Zahlenspeicher ein.
     * @param t
     */
    void add(T t);

    /**
     * Gibt true zurück, wenn die Zahl n im Zahlenspeicher vorhanden ist.
     * @param t
     * @return
     */
    boolean contains(T t);

    /**
     * Gibt alle Zahlen des Zahlenspeichers in einem Array zurück,
     * sortiert in der gewünschten Reihenfolge.
     * @param sortOrder
     * @return
     */
    String get(SortOrder sortOrder);

    /**
     * Löscht alle Zahlen aus dem Zahlenspeicher.
     */
    void clear();
}