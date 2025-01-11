package comparator;

import java.util.Comparator;

// Generic comparator for objects with a length() method
public class LengthCompare<T extends CharSequence> implements Comparator<T> {
    @Override
    public int compare(T obj1, T obj2) {
        return obj1.length() - obj2.length();
    }
}