package ch.ictbz.dynamischverketteteliste.dynamischverketteteliste;

public class Elem <T extends Comparable<T>> {
    public Elem<T> Next;
    public Elem<T> Previous;
    public T t;
    private static Elem safe;
    public Elem(T t) {
        // put elem into safe so the next elem can use it for the previous-attribute. Then go to the previous elem and assign current elem to next.
        Previous = safe;
        if (Previous != null)
            Previous.Next = this;
        this.t = t;
        safe = this;
    }

    public void clear() {
        // cannot fully self-destruct so the last remaining elem has to be destroyed from the outside.

        if (safe == null) return;
        safe = this;
        // go to the last elem
        while (safe.Next != null) {
            safe = safe.Next;
        }
        // go backwards and destroy the last elem
        while (safe.Previous != null) {
            safe = safe.Previous;
            safe.Next = null;
        }
        safe = null;
    }

    public static <T extends Comparable<T>> Elem<T> goToFirstElem(Elem<T> elem) {
        while (elem.Previous != null) {
            elem = elem.Previous;
        }
        return elem;
    }

    public static <T extends Comparable<T>> Elem<T> goToLastElem(Elem<T> elem) {
        while (elem.Next != null) {
            elem = elem.Next;
        }
        return elem;
    }
}
