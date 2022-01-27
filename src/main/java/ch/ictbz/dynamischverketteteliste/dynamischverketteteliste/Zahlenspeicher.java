package ch.ictbz.dynamischverketteteliste.dynamischverketteteliste;

public class Zahlenspeicher <T extends Comparable<T>> implements  IZahlenspeicher<T> {
    Elem<T> elem;
    public void add(T t) {
        elem = new Elem<>(t);
    }
    public void clear() {
        elem.clear();
        elem = null;
    }

    public  boolean contains(T t) {
        if (elem == null) return false;
        while (elem.Next != null) {
            elem = elem.Next;
        }
        do {
            if (elem.t.compareTo(t) == 0) return true;
            if (elem.Previous != null)
                elem = elem.Previous;
            else
                break;
        } while (true);
        return false;
    }
    public String get(SortOrder sortOrder) {
        int counter = countElem(elem);

        Elem<T>[] alreadyOrdered = new Elem[counter];
        String output = "";
        int counter2 = 0;
        while (counter2 < counter) {
            Elem<T> nextElem;
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
                output += String.valueOf(nextElem.t);
            else
                output += nextElem.t + ", ";
            while (elem.Next != null) {
                elem = elem.Next;
            }
            counter2 += 1;
        }



        return output;
    }

    private Elem<T> getLowestHighestElem(Elem<T> elem, SortOrder sortOrder, Elem<T>[] alreadyOrdered, Elem<T> nextElem) {
        do {
            if (sortOrder == SortOrder.ASCENDING) {
                if (elem.t.compareTo(nextElem.t) <= 0 && !arrayContainsElem(alreadyOrdered, elem)) {
                    nextElem = elem;
                }
            } else {
                if (elem.t.compareTo(nextElem.t) >= 0 && !arrayContainsElem(alreadyOrdered, elem)) {
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

    private int countElem(Elem<T> elem) {
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

    private boolean arrayContainsElem(Elem<T>[] arr, Elem<T> elem) {
        for (Elem<T> arrayElem : arr) {
            if (arrayElem == elem) return true;
        }
        return false;
    }
}
