package ch.ictbz.dynamischverketteteliste.dynamischverketteteliste;

public interface IZahlenspeicher {
    /**
     * Fügt eine Zahl in den Zahlenspeicher ein.
     * @param c
     */
    void add(Comparable c);

    /**
     * Gibt true zurück, wenn die Zahl n im Zahlenspeicher vorhanden ist.
     * @param t
     * @return
     */
    <T extends Comparable<T>> boolean contains(T t);

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