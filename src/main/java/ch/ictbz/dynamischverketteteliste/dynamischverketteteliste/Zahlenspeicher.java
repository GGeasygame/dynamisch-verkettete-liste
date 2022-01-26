package ch.ictbz.dynamischverketteteliste.dynamischverketteteliste;

public class Zahlenspeicher implements  IZahlenspeicher{
    Elem elem;
    public void add(int n) {
        elem = new Elem(n);
    }
    public void clear() {
        elem.clear();
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
        int counter = countElem(elem);

        Elem[] alreadyOrdered = new Elem[counter];
        String output = "";
        int counter2 = 0;
        while (counter2 < counter) {
            Elem nextElem;
            do {
                nextElem = elem;
                if (elem.Previous != null)
                    elem = elem.Previous;
                if (elem.Next == null)
                    break;
            } while (arrayContainsElem(alreadyOrdered, elem.Next));
            while (elem.Next != null) {
                elem = elem.Next;
            }
            do {
                if (sortOrder == SortOrder.ASCENDING) {
                    if (elem.Number <= nextElem.Number && !arrayContainsElem(alreadyOrdered, elem)) {
                        nextElem = elem;
                    }
                } else {
                    if (elem.Number >= nextElem.Number && !arrayContainsElem(alreadyOrdered, elem)) {
                        nextElem = elem;
                    }
                }

                if (elem.Previous != null)
                    elem = elem.Previous;
                else
                    break;
            } while (true);
            alreadyOrdered[counter2] = nextElem;
            if (counter2 == counter-1)
                output += String.valueOf(nextElem.Number);
            else
                output += nextElem.Number + ", ";
            while (elem.Next != null) {
                elem = elem.Next;
            }
            counter2 += 1;
        }



        return output;
    }

    private int countElem(Elem elem) {
        if (elem == null) return 0;
        while (elem.Previous != null) {
            elem = elem.Previous;
        }
        int counter = 1;
        while (elem.Next != null) {
            elem = elem.Next;
            counter += 1;
        }
        return counter;
    }

    private boolean arrayContainsElem(Elem[] arr, Elem elem) {
        for (Elem arrayElem : arr) {
            if (arrayElem == elem) return true;
        }
        return false;
    }
}
