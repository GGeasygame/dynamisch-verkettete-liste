package ch.ictbz.dynamischverketteteliste.dynamischverketteteliste;

public class Elem {
    public Elem Next;
    public Elem Previous;
    public Comparable comparable;
    private static Elem safe;
    public Elem(Comparable comparable) {
        Previous = safe;
        if (Previous != null)
            Previous.Next = this;
        this.comparable = comparable;
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
