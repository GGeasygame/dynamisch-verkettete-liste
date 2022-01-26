package ch.ictbz.dynamischverketteteliste.dynamischverketteteliste;

public class Zahlenspeicher implements  IZahlenspeicher{
    Elem elem;
    public void add(int n) {
        elem = new Elem(n);
    }
    public void clear() {
        Elem.clear();
    }
    public boolean contains(int n) {
        while (elem.Next != null) {
            elem = elem.Next;
        }
        do {
            if (elem.Number == n) return true;
            if (elem.Previous != null)
                elem = elem.Previous;
            else
                break;
        } while (true);
        return false;
    }
    public String get(SortOrder sortOrder) {

        while (elem.Previous != null) {
            elem = elem.Previous;
        }
        int counter = 1;
        while (elem.Next != null) {
            elem = elem.Next;
            counter += 1;
        }
        Elem[] alreadyOrdered = new Elem[counter];
        String output = "";
        int counter2 = 0;
        while (counter2 < counter) {
            Elem nextLowest;
            do {
                nextLowest = elem;
                if (elem.Previous != null)
                    elem = elem.Previous;
                if (elem.Next == null)
                    break;
            } while (arrayContainsElem(alreadyOrdered, elem.Next));
            while (elem.Next != null) {
                elem = elem.Next;
            }
            do {
                if (elem.Number <= nextLowest.Number && !arrayContainsElem(alreadyOrdered, elem)) {
                    nextLowest = elem;
                }

                if (elem.Previous != null)
                    elem = elem.Previous;
                else
                    break;
            } while (true);
            alreadyOrdered[counter2] = nextLowest;
            if (counter2 == counter-1)
                output += String.valueOf(nextLowest.Number);
            else
                output += nextLowest.Number + ", ";
            while (elem.Next != null) {
                elem = elem.Next;
            }
            counter2 += 1;
        }



        return output;
    }

    private boolean arrayContainsElem(Elem[] arr, Elem elem) {
        for (Elem arrayElem : arr) {
            if (arrayElem == elem) return true;
        }
        return false;
    }
}
