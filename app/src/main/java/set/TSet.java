package set;

import model.Model;

import java.util.*;

public class TSet<T extends Model> implements Set {
    Set<T> set;

    TSet() {
        set = new HashSet();
    }

    @Override
    public int size() {
        return set.size();
    }

    @Override
    public boolean isEmpty() {
        return set.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return set.contains(o);
    }

    @Override
    public Iterator iterator() {
        return set.iterator();
    }

    @Override
    public Object[] toArray() {
        return set.toArray();
    }

    @Override
    public boolean add(Object o) {
        return set.add((T) o);
    }

    @Override
    public boolean remove(Object o) {
        return set.remove(o);
    }

    @Override
    public boolean addAll(Collection c) {
        return set.add((T) c);
    }

    @Override
    public void clear() {
        set.clear();
    }

    @Override
    public boolean removeAll(Collection c) {
        return set.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection c) {
        return set.retainAll(c);
    }

    @Override
    public boolean containsAll(Collection c) {
        return set.containsAll(c);
    }

    @Override
    public Object[] toArray(Object[] a) {
        return set.toArray(a);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TSet<?> tSet = (TSet<?>) o;
        return Objects.equals(set, tSet.set);
    }

    @Override
    public int hashCode() {
        return Objects.hash(set);
    }
}
