/*
 * Name: Jinxiao Chen
 * ID:A14236655
 * Login:cs12xii
 */
package hw2;

import org.junit.*;
import static org.junit.Assert.*;
import java.util.LinkedList;
import java.util.ListIterator;


/**
 *  Title: class DoublyLinkedListTester
 *  Description: JUnit test class for doubly linked list class
 * */

/*
 * You should modify the information above to add your name 
 * 
 * Finally, when your tester is complete, you will rename it 
 * DoublyLinkedListTester.java 
 * (renaming LinkedList to DoublyLinkedList12 everywhere in the file) so 
 * that you can
 * use it to test your DoublyLinkedList12 and MyListIterator classes.
 */
//test
public class DoublyLinkedListTester
{
  private DoublyLinkedList<Integer> empty ;
  private DoublyLinkedList<Integer> one ;
  private DoublyLinkedList<Integer> several ;
  private DoublyLinkedList<String>  slist ;
  static final int DIM = 5;
  
  /**
   * Standard Test Fixture. An empty list, a list with one entry (0) and 
   * a list with several entries (0,1,2)
   */ 
  @Before
  public void setUp()
  {
    empty = new DoublyLinkedList<Integer>();
    one = new DoublyLinkedList<Integer>();
    one.add(0,new Integer(0));
    several = new DoublyLinkedList<Integer>() ;
    
    // List: 1,2,3,...,Dim
    for (int i = DIM; i > 0; i--)
      several.add(0,new Integer(i));
    
    // List: "First","Last"
    slist = new DoublyLinkedList<String>();
    slist.add(new String("First"));
    slist.add(new String("Last"));
  }
  /** Test if heads of the lists are correct */
  @Test
  public void testGetHead()
  {
    assertEquals("Check 0",new Integer(0),one.get(0)) ;
    assertEquals("Check 0",new Integer(1),several.get(0)) ;
  }
  
  /** Test if size of lists are correct */
  @Test
  public void testListSize()
  {
    assertEquals("Check Empty Size",0,empty.size()) ;
    assertEquals("Check One Size",1,one.size()) ;
    assertEquals("Check Several Size",DIM,several.size()) ;
  }
  
  /** Test setting a specific entry */
  @Test
  public void testSet()
  {
    slist.set(1,"Final");
    assertEquals("Setting specific value", "Final",slist.get(1));
  }
  
  /** Test isEmpty */
  @Test
  public void testEmpty()
  {
    assertTrue("empty is empty",empty.isEmpty()) ;
    assertTrue("one is not empty",!one.isEmpty()) ;
    assertTrue("several is not empty",!several.isEmpty()) ;
  }

  /** Test out of bounds exception on get */
  @Test
  public void testGetException()
  {
    try 
    {
      empty.get(0);
      // This is how you can test when an exception is supposed 
      // to be thrown
      fail("Should have generated an exception");  
    }
    catch(IndexOutOfBoundsException e)
    {
      //  normal
    }
  }
  
  /**Test add(index, E) method*/
  @Test
  public void testAddIndex(){
	  several.add(1,new Integer(10));
	  assertEquals("Check Add at index",(Integer)10,several.get(1));
  }
  
  /**Test add(E) method*/
  @Test
  public void testAdd(){
	  slist.add("New Last");
	  System.out.println(slist.get(0));
	  assertEquals("Check Add","New Last",slist.get(2));
  }
  
  /**Test get method*/
  @Test
  public void testGet(){
	  assertEquals("Check Get",(Integer)3, several.get(2));
  }
  
  /**Test clear method*/
  @Test
  public void testClear(){
	  slist.clear();
	  assertEquals("Check Clear",true, slist.isEmpty());
  }
  
  /**Test lastIndexOf method*/
  @Test
  public void testLastIndexOf(){
	  assertEquals("Check get last index",1,slist.lastIndexOf(slist));
  }
  
  /**Test remove method*/
  @Test
  public void testRemove(){
	  several.remove(3);
	  assertEquals("Check remove",null,several.get(3));
  }
  
  /**Test contains method*/
  @Test
  public void testContains(){
	  several.contains(3);
	  slist.contains("First");
	  assertEquals("Check contains",true,several.contains(3));
	  assertEquals("Check contains",true,slist.contains("First"));
  }
  
  /**Test removeFirstOccurrence method*/
  @Test
  public void testRemoveFirstOccurrence(){
//	  several.removeFirstOccurrence(3);
//	  slist.removeFirstOccurrence("First");
	  assertEquals("Check Remove First Occurrence",true,several.removeFirstOccurrence((Integer)3));
	  assertEquals("Check Remove First Occurrence",true,slist.removeFirstOccurrence("First"));
	  assertEquals("Check Remove First Occurrence",null,several.get(2));
  }

  
  /** Test iterator on empty list and several list */
  @Test
  public void testIterator()
  {
    int counter = 0 ;
    ListIterator<Integer> iter;
    for (iter = empty.listIterator() ; iter.hasNext(); )
    {
      fail("Iterating empty list and found element") ;
    }
    counter = 0 ;
    for (iter = several.listIterator() ; iter.hasNext(); iter.next())
      counter++;
    assertEquals("Iterator several count", counter, DIM);
  }
}