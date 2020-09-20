package model;

import java.util.Arrays;

public class GenericArray<I> {
    private final Object[] obj_array; // object array
    public final int length;

    // class constructor
    public GenericArray(int length) {
        // instantiate a new Object array of specified length
        obj_array = new Object[length];
        this.length = length;
    }

    // get obj_array[i]
    public I get(int i) {
        @SuppressWarnings("unchecked")
        final I e = (I) obj_array[i];
        return e;
    }

    // set e at obj_array[i]
    public void set(int i, I e) {
        obj_array[i] = e;
    }

    @Override
    public String toString() {
        return Arrays.toString(obj_array);
    }
}
