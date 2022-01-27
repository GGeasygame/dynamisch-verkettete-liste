package ch.ictbz.dynamischverketteteliste.dynamischverketteteliste;

public class Zahlenspeicher implements  IZahlenspeicher {
    Elem elem;
    public void add(Comparable c) {
        elem = new Elem(c);
    }
    public void clear() {
        elem.clear();
        elem = null;
    }
    public  boolean contains(Comparable c) {
        if (elem == null) return false;
        while (elem.Next != null) {
            elem = elem.Next;
        }
        do {
            if (elem.comparable.compareTo(c) == 0) return true;
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

            nextElem = getLowestHighestElem(elem, sortOrder, alreadyOrdered, nextElem);

            alreadyOrdered[counter2] = nextElem;
            if (counter2 == counter-1)
                output += String.valueOf(nextElem.comparable);
            else
                output += nextElem.comparable + ", ";
            while (elem.Next != null) {
                elem = elem.Next;
            }
            counter2 += 1;
        }



        return output;
    }

    private Elem getLowestHighestElem(Elem elem, SortOrder sortOrder, Elem[] alreadyOrdered, Elem nextElem) {
        do {
            if (sortOrder == SortOrder.ASCENDING) {
                if (elem.comparable.compareTo(nextElem.comparable) <= 0 && !arrayContainsElem(alreadyOrdered, elem)) {
                    nextElem = elem;
                }
            } else {
                if (elem.comparable.compareTo(nextElem.comparable) >= 0 && !arrayContainsElem(alreadyOrdered, elem)) {
                    nextElem = elem;
                }
            }

            if (elem.Previous != null)
                elem = elem.Previous;
            else
                break;
        } while (true);
        return  nextElem;
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
