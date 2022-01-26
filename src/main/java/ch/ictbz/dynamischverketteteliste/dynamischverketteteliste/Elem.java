package ch.ictbz.dynamischverketteteliste.dynamischverketteteliste;

public class Elem {
    public Elem Next;
    public Elem Previous;
    public int Number;
    private static Elem safe;
    public Elem(int number) {
        Previous = safe;
        if (Previous != null)
            Previous.Next = this;
        Number = number;
        safe = this;
    }

    public void clear() {
        if (safe == null) return;

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
