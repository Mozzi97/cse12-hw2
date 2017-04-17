package hw2;

import static org.junit.Assert.*;

import java.util.ListIterator;

import org.junit.Before;
import org.junit.Test;

public class BasicTester {

	private DoublyLinkedList<Integer> empty;
	private DoublyLinkedList<String> one;
	private DoublyLinkedList<Integer> several;
	
	private DoublyLinkedList<Integer> test;
	private ListIterator <Integer> testIter;
	private ListIterator <Integer> iterator;
	
	@Before
    public void setup() {
    	
		empty = new DoublyLinkedList<>();
		one = new DoublyLinkedList<>();
		several = new DoublyLinkedList<>();
		test = new DoublyLinkedList<>();
	
    }
	
	@Test
	public void testAllDLinkedListMethodsExist() {
		one.add("Testing");

		for(int i=0; i<25; i++)
			several.add(i,i);
		several.add(0, 5);
		int size = several.size();
		int elem = several.get(5);
		int index = several.lastIndexOf(new Integer(5));
		int item = several.set(7, 700);
		boolean check = several.removeFirstOccurrence(new Integer(20));
		check = several.contains(10);
		
		String s1 = one.remove(0);
		several.clear();
		one.isEmpty();
	}
	
	@Test
	public void testAllIteratorMethodsExist() {
		int data, index;
		boolean flag;
		
		for(int i=0; i<25; i++)
			several.add(i,i);
		
		testIter= several.listIterator();
		iterator = test.listIterator();
		
		data = testIter.next();
		index = testIter.nextIndex();
		index = testIter.previousIndex();
		flag = testIter.hasNext();
		flag = testIter.hasPrevious();
		testIter.add(500);
		testIter.next();
		testIter.remove();
		testIter.next();
		testIter.set(100);
		data = testIter.previous();
		
		iterator.add(1);
		iterator.add(2);;
		iterator.add(3);
		iterator.previous();
		iterator.next();
		iterator.remove();
	}

}