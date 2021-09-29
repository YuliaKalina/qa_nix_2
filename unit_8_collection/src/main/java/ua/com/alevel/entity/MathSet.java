package ua.com.alevel.entity;

import java.lang.Number;


public class MathSet<T extends Number & Comparable<T>> {

    private static final int CAPACITY = 10;
    private int size;
    private T[] mathSet;

    public MathSet() {
        mathSet = (T[]) new Number[CAPACITY];
    }

    public MathSet(int capacity) {
        mathSet = (T[]) new Number[capacity];
    }

    private void size(int size) {
        this.size = size;
    }

    public MathSet(T[] numbers) {
        this.size = numbers.length;
        mathSet = (T[]) new Number[size];
        add(numbers);
    }

    @SafeVarargs
    public MathSet(T[]... numbers) {
        int sizeCalc = 0;
        for (T[] number : numbers) {
            for (int j = 0; j < number.length; j++) {
                sizeCalc++;
            }
        }
        size(sizeCalc);
        int counter = 0;
        mathSet = (T[]) new Number[sizeCalc + CAPACITY];
        for (T[] number : numbers) {
            for (T t : number) {
                mathSet[counter] = t;
                counter++;
            }
        }
    }

    public MathSet(MathSet<T> numbers) {
        this.size = numbers.getSize();
        mathSet = numbers.getMathSet();
    }

    @SafeVarargs
    public MathSet(MathSet<T>... numbers) {
        int currentSize = 0;
        for (MathSet<T> number : numbers) {
            if (number == null) continue;
            currentSize += number.getSize();
        }
        this.size = currentSize;
        mathSet = new MathSet<T>(currentSize).getMathSet();
        for (MathSet<T> tMathSet : numbers) {
            if (tMathSet == null) continue;
            Number[] set = tMathSet.getMathSet();
            for (Number number : set) {
                add((T) number);
            }
        }
    }

    private void increase(int currentValue) {
        int newValue = currentValue + CAPACITY;
        T[] newMathSet = (T[]) new Number[newValue];
        System.arraycopy(mathSet, 0, newMathSet, 0, size);
        mathSet = newMathSet;
    }

    public void add(T n) {
        if (size == mathSet.length) {
            increase(size);
        }
        mathSet[size] = n;
        size = size + 1;
    }

    @SafeVarargs
    public final void add(T... ns) {
        for (T n : ns) {
            add(n);
        }
    }

    public void join(MathSet<T> set) {
        for (int i = 0; i < set.size(); i++) {
            add(set.mathSet[i]);
        }
    }


    @SafeVarargs
    public final void join(MathSet<T>... set) {
        for (MathSet<T> tMathSet : set) {
            join(tMathSet);
        }
    }

    @SafeVarargs
    public final void intersection(MathSet<T>... mathSets) {
        for (MathSet<T> mathSet : mathSets) {
            intersection(mathSet);
        }
    }

    private void desk(T[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i] == null) continue;
            T newArray = array[i];
            int j = i;
            while (true) {
                if (j <= 0) break;
                int compare = numberComparator(array[j - 1], newArray);
                if (compare < 0) {
                    array[j] = array[j - 1];
                } else break;
                j--;
            }
            array[j] = newArray;
        }
    }

    private void asc(T[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i] == null) continue;
            T newArray = array[i];
            int j = i;
            while (true) {
                int compare = numberComparator(array[j - 1], newArray);
                if (compare > 0) {
                    array[j] = array[j - 1];
                } else break;
                j--;
            }
            array[j] = newArray;
        }
    }

    public void sortDesc() {
        desk(mathSet);
    }

    public void sortDesc(int firstIndex, int lastIndex) {
        if ((lastIndex - firstIndex) > 0) {
            for (int i = firstIndex; i < lastIndex - 1; i++) {
                for (int j = i + 1; j < lastIndex; j++) {
                    if (mathSet[i].compareTo(mathSet[j]) > 0) {
                        T newArray = mathSet[i];
                        mathSet[i] = mathSet[j];
                        mathSet[j] = newArray;
                    }
                }
            }
        }
    }


    private int getIndex(T value) {
        for (int i = 0; i < mathSet.length; i++) {
            if (numberComparator((T) value, (T) mathSet[i]) == 0) {
                return i;
            }
        }
        return mathSet.length;
    }

    public void sortDesc(T value) {
        int index = getIndex(value);
        sortDesc(index, mathSet.length - 1);
    }

    public void sortAsc() {
        asc(mathSet);
    }

    public void sortAsc(int firstIndex, int lastIndex) {
        if ((lastIndex - firstIndex) > 0) {
            for (int i = firstIndex; i < lastIndex - 1; i++) {
                for (int j = i + 1; j < lastIndex; j++) {
                    if (mathSet[i].compareTo(mathSet[j]) < 0) {
                        T newArray = mathSet[i];
                        mathSet[i] = mathSet[j];
                        mathSet[j] = newArray;
                    }
                }
            }
        }
    }

    public void sortAsc(T value) {
        int index = getIndex(value);
        sortAsc(index, mathSet.length - 1);
    }


    public T get(int index) {
        if (index < 0 || index > size) throw new IllegalArgumentException("Incorrect index");
        return mathSet[index];
    }

    public T getMax() {
        Number max = 0;
        for (int i = 0; i < size; i++) {
            if (mathSet[i].compareTo((T) max) > 0) {
                max = mathSet[i];
            }
        }
        return (T) max;
    }

    public T getMin() {
        Number min = mathSet[0];
        for (int i = 0; i < size; i++) {
            if (mathSet[i].compareTo((T) min) < 0) {
                min = mathSet[i];
            }
        }
        return (T) min;
    }


    public Number getAverage() {
        long average = 0;
        for (int i = 0; i < size; i++) {
            average += mathSet[i].doubleValue();
        }
        return average / size;
    }

    public Number getMedian() {
        if (size != 0) {
            sortAsc();
            if (size % 2 != 0) {
                return mathSet[size / 2];
            } else {
                Long firstElement = mathSet[size / 2].longValue();
                Long secondElement = mathSet[size / 2 - 1].longValue();
                return (firstElement + secondElement) / 2;
            }
        } else {
            return null;
        }
    }

    public T[] toArray() {
        return getMathSet();
    }

    public Number[] toArray(int firstIndex, int lastIndex) {
        Number[] array = new Number[lastIndex - firstIndex + 1];
        int j = 0;
        for (int i = firstIndex; i <= lastIndex; i++) {
            array[j] = mathSet[i];
            j++;
        }
        return array;
    }

    public MathSet cut(int firstIndex, int lastIndex) {
        MathSet<T> cutMathSet = new MathSet<>();
        for (int i = 0; i < CAPACITY; i++) {
            if (i >= firstIndex && i <= lastIndex) cutMathSet.add(mathSet[i]);
        }
        return cutMathSet;
    }

    public void clear() {
        for (int i = 0; i < mathSet.length; i++) {
            mathSet[i] = null;
        }
    }

    public void clear(Number[] numbers) {
        for (Number number : numbers) {
            for (int i = 0; i < size; i++) {
                if (number.equals(mathSet[i])) {
                    for (int j = i; j < size; j++) {
                        mathSet[j] = mathSet[j + 1];
                        mathSet[j + 1] = null;
                    }
                    size--;
                }
            }
        }
    }


    private int numberComparator(T num1, T num2) {
        if (num1.equals(num2) || num1.longValue() == num2.longValue() || num1.equals(num2) || num1.hashCode() == num2.hashCode()) {
            return 0;
        } else if (num1.longValue() > num2.longValue()) {
            return 1;
        } else {
            return -1;
        }
    }

    private T[] getMathSet() {
        return mathSet;
    }

    public int getSize() {
        return mathSet.length;
    }

    public int size() {
        return getSize();
    }

    public void printMathSet() {
        String result = "MathSet - ";
        StringBuilder set = new StringBuilder("");
        for (Number number : mathSet) {
            if (number != null) {
                set.append(number).append(" ");
            }
        }
        result += set.toString().trim();
        System.out.println(result);
    }
}

