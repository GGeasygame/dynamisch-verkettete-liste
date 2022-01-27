package ch.ictbz.dynamischverketteteliste.dynamischverketteteliste;

public class Elem <T extends Comparable<T>> {
    public Elem<T> Next;
    public Elem<T> Previous;
    public T t;
    private static Elem safe;
    public Elem(T t) {
        Previous = safe;
        if (Previous != null)
            Previous.Next = this;
        this.t = t;
        safe = this;
    }

    public void clear() {
        if (safe == null) return;
        safe = this;
        while (safe.Next != null) {
            safe = safe.Next;
        }
        while (safe.Previous != null) {
            safe = safe.Previous;
            safe.Next = null;
        }
        safe = null;
    }
}
