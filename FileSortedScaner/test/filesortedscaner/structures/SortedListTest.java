package filesortedscaner.structures;

import filesortedscanner.structures.SortedList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Класс для тестирования SortedList
 * @author Александр Купш
 * @version 1.0
 */
public class SortedListTest {
    /**
     * Тестирование добавления элементов типа Integer, сортировка по возрастанию
     */
    @Test
    public void testAddIntegerAsk() {
        SortedList<Integer> instance = new SortedList<>(true);

        instance.add(3);
        instance.add(5);
        instance.add(2);
        instance.add(1);
        
        assertArrayEquals(new Integer[]{1,2,3,5},instance.toArray() );
    }
    
     /**
     * Тестирование добавления элементов типа Integer, сортировка по убыванию
     */
    @Test
    public void testAddIntegerDesk() {
        SortedList<Integer> instance = new SortedList<>(false);

        instance.add(3);
        instance.add(5);
        instance.add(2);
        instance.add(1);
        
        assertArrayEquals(new Integer[]{5,3,2,1},instance.toArray() );
    }
    
    /**
    * Тестирование добавления элементов типа String, сортировка по возрастанию
    */
    @Test
    public void testAddStringAsk() {
        SortedList<String> instance = new SortedList<>(true);

        instance.add("a");
        instance.add("gf");
        instance.add("hg");
        instance.add("fgdf");
        
        assertArrayEquals(new String[]{"a","fgdf","gf","hg"},instance.toArray() );
    }
    
    /**
     * Тестирование добавления элементов типа String, сортировка по убыванию
     */
    @Test
    public void testAddStringDesk() {
        SortedList<String> instance = new SortedList<>(false);

        instance.add("a");
        instance.add("gf");
        instance.add("hg");
        instance.add("fgdf");
        
        assertArrayEquals(new String[]{"hg", "gf", "fgdf", "a"},instance.toArray() );
    }
}
