package filesortedscanner.structures;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Класс для организации Списка, сортирующего элементы при добавлении
 * @author Александр Купш
 * @version 1.0
 */
public class SortedList<T extends Comparable<T>> implements Collection<T> {
    /** список данных*/
    private List<T> data;
    /** тип сортировки*/
    private boolean sortedType;

    public SortedList() {
        this.data = new LinkedList<>();
        sortedType=true;
    }

    public SortedList(boolean sortedType) {
        this.sortedType = sortedType;
        this.data = new LinkedList<>();
    }
    
     /**
     * добаление элемента в коллекцию  (сортировка вставками)
     * @param e добавляемый элемент
     * @return true если добавление успешно, false если не успешно
     */
    @Override
    public boolean add(T e) {
        data.add(e);
        int index = data.size()-1;
        while(index>0 && (sortedType ? (data.get(index).compareTo(data.get(index-1))<0):(data.get(index).compareTo(data.get(index-1))>0)) ) {
            T buffer = data.get(index);
            data.set(index, data.get(index-1));
            data.set(index-1, buffer);
            index--;
        }
        return true;
    }
    
    @Override
    public int size() {
        return data.size();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public Object[] toArray() {
        return data.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return  data.toArray(a);
    }

    

    @Override
    public boolean remove(Object o) {
        return data.remove(o);
    }

   
    @Override
    public void clear() {
        data.clear();
    }

    @Override
    public String toString() {
        return data.toString();
    }
    
    @Override
    public Iterator<T> iterator() {
        return data.iterator();
    }
    
    // TODO список нереализованных методов
    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
     @Override
    public boolean contains(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
