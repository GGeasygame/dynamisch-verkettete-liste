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

    public static void clear() { safe = null; }
}
