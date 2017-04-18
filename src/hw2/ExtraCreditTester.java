/*
 * Name: Jinxiao Chen
 * ID:A14236655
 * Login:cs12xii
 */
package hw2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ExtraCreditTester {
	  private DoublyLinkedList<Integer> several;

	@Before
	public void setUp(){
		several = new DoublyLinkedList<Integer>();
		several.add(3);
		several.add(9);
		several.add(11);
	}
	
	/**Test reverseAndConcat method
	 */
	@Test
	public void testreverseAndConcat() {
		DoublyLinkedList<Integer> newSeveral = new DoublyLinkedList<Integer>();
		newSeveral.reverseAndConcat(several);
		assertEquals("Check reverseAndConcat",(Integer)11,several.get(3));
		assertEquals("Check reverseAndConcat",(Integer)9,several.get(4));
		assertEquals("Check reverseAndConcat",(Integer)3,several.get(5));
	}
	
	/**Test sortLists method
	 */
	@Test
	public void testsortLists() {
		DoublyLinkedList<Integer> newSeveral = new DoublyLinkedList<Integer>();
		newSeveral.add(7); newSeveral.add(100); newSeveral.add(4);
		DoublyLinkedList<Integer> result = new DoublyLinkedList<Integer>();
		several.sortLists(newSeveral, result);
//		System.out.println(result.get(0));
//		System.out.println(result.get(1));
//		System.out.println(result.get(2));
//		System.out.println(result.get(3));
//		System.out.println(result.get(4));
//		System.out.println(result.get(5));
		assertEquals("Check reverseAndConcat",(Integer)7,result.get(2));
		assertEquals("Check reverseAndConcat",(Integer)11,result.get(4));
		assertEquals("Check reverseAndConcat",(Integer)100,result.get(5));
	}

}
