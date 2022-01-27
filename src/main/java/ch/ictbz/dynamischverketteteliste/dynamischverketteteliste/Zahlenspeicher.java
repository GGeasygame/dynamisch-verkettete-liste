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
        // got to last elem
        while (elem.Next != null) {
            elem = elem.Next;
        }
        // go backwards in the list and check for every elem if it is the one that has been searched for
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

        // Since ArrayLists are in the java.util package, a counter is used to determine the amount of elems.
        // This way an array can be used to store the ones that have already been used in the output.
        Elem<T>[] alreadyOrdered = new Elem[counter];
        String output = "";
        int counter2 = 0;
        // The counter can also be used to determine how many times the process has to be executed.
        // We have to execute the process for every elem in the linked list.
        while (counter2 < counter) {
            Elem<T> nextElem;
            // Something is needed to compare the elem with, and it cannot be a random number because it might be too high or low.
            // An elem can be used for this purpose. Because the elem cannot be too high or low, an elem will be chosen that is not in the
            // alreadyOrdered-variable. This will ensure the elem is not too high/low.
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
            // Get next highest or lowest elem.
            nextElem = getNextElem(elem, sortOrder, alreadyOrdered, nextElem);

            alreadyOrdered[counter2] = nextElem;
            // generate the output-string
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

    private Elem<T> getNextElem(Elem<T> elem, SortOrder sortOrder, Elem<T>[] alreadyOrdered, Elem<T> nextElem) {
        do {
            // Use compare function to check if it is lower than the elem in the nextElem-variable, if so assign it to the nextElem-variable.
            if (sortOrder == SortOrder.ASCENDING) {
                if (elem.t.compareTo(nextElem.t) <= 0 && !arrayContainsElem(alreadyOrdered, elem)) {
                    nextElem = elem;
                }
            }
            // Inverse the <= to a >= for the descending order
            else {
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
        // got to first elem
        while (elem.Previous != null) {
            elem = elem.Previous;
        }
        int counter = 1;
        // go to last elem and count every elem on the way
        while (elem.Next != null) {
            elem = elem.Next;
            counter += 1;
        }
        return counter;
    }

    private boolean arrayContainsElem(Elem<T>[] arr, Elem<T> elem) {
        // loop through every elem in the elem-array to find the wanted elem
        for (Elem<T> arrayElem : arr) {
            if (arrayElem == elem) return true;
        }
        return false;
    }
}
