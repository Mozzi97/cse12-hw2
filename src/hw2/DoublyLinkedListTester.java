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
import java.util.NoSuchElementException;


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
    try 
    {
      slist.set(10,null);
      slist.set(10,(String) "Hello");
      fail("Should have generated an exception");  
    }
    catch(IndexOutOfBoundsException e){}
    catch(NullPointerException e){}
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
	    try 
	    {
	      slist.add(null);
	      several.add(10,7);
	      fail("Should have generated an exception");  
	    }
	    catch(IndexOutOfBoundsException e){}
	    catch(NullPointerException e){}
}
  
  
  /**Test add(E) method*/
  @Test
  public void testAdd(){
	  slist.add("New Last");
	  System.out.println(slist.get(0));
	  assertEquals("Check Add","New Last",slist.get(2));
	    try 
	    {
	      slist.add(null);
	      fail("Should have generated an exception");  
	    }
	    catch(NullPointerException e){}
  }
  
  /**Test get method*/
  @Test
  public void testGet(){
	  assertEquals("Check Get",(Integer)3, several.get(2));
	    try 
	    {
	      slist.get(7);
	      fail("Should have generated an exception");  
	    }
	    catch(IndexOutOfBoundsException e){}
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
	    try 
	    {
	      slist.lastIndexOf(null);
	      fail("Should have generated an exception");  
	    }
	    catch(NullPointerException e){}
  }
  
  /**Test remove method*/
  @Test
  public void testRemove(){
	  several.remove(3);
	  assertEquals("Check remove",null,several.get(3));
	    try 
	    {
	      slist.remove(10);
	      fail("Should have generated an exception");  
	    }
	    catch(IndexOutOfBoundsException e){}
  }
  
  /**Test contains method*/
  @Test
  public void testContains(){
	  several.contains(3);
	  slist.contains("First");
	  assertEquals("Check contains",true,several.contains(3));
	  assertEquals("Check contains",true,slist.contains("First"));
	    try 
	    {
	      slist.contains(null);
	      fail("Should have generated an exception");  
	    }
	    catch(NullPointerException e){}
  }
  
  /**Test removeFirstOccurrence method*/
  @Test
  public void testRemoveFirstOccurrence(){
	  assertEquals("Check Remove First Occurrence",true,
			  several.removeFirstOccurrence((Integer)3));
	  assertEquals("Check Remove First Occurrence",true,
			  slist.removeFirstOccurrence("First"));
	  assertEquals("Check Remove First Occurrence",null,several.get(2));
	    try 
	    {
	      slist.removeFirstOccurrence(null);
	      fail("Should have generated an exception");  
	    }
	    catch(NullPointerException e){}
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
  
  /** Test iterator add method */
  @Test
  public void testItAdd(){
	  ListIterator<Integer> ite;
	  ite = several.listIterator();
	  ite.next();
	  ite.add((Integer) 4);
	  assertEquals("Iterator add", (Integer) 4, ite.previous());
	    try 
	    {
	      ite.next();
	      ite.set(null);
	      fail("Should have generated an exception");  
	    }
	    catch(NullPointerException e){}
  }
  
  /** Test iterator hasNext method */
  @Test
  public void testIthasNext(){
	  ListIterator<Integer> ite;
	  ite = several.listIterator();
	  ite.next();
	  ite.add((Integer) 4);

	  assertEquals("Iterator hasNext", true,ite.hasNext());
  }
  
  /** Test iterator hasPrevious method */
  @Test
  public void testIthasPrevious(){
	  ListIterator<Integer> ite;
	  ite = several.listIterator();
	  ite.next();
	  ite.add((Integer) 4);
	  ite.previous();
	  assertEquals("Iterator hasPrevious", true,ite.hasPrevious());
	  ite.previous();
	  assertEquals("Iterator hasPrevious", false,ite.hasPrevious());
  }
  
  /** Test iterator Next method */
  @Test
  public void testItNext(){
	  ListIterator<Integer> ite;
	  ite = several.listIterator();
	  ite.next();
	  ite.add((Integer) 4);
	  ite.next();
	  ite.next();
	  assertEquals("Iterator next",(Integer) 3,ite.previous());
	    try 
	    {
	      ite = empty.listIterator();
	      ite.next();
	      fail("Should have generated an exception");  
	    }
	    catch(NoSuchElementException e)
	    {
	      //  normal
	    }
  }
  
  /** Test iterator previous method */
  @Test
  public void testItPrevious(){
	  ListIterator<Integer> ite;
	  ite = several.listIterator();
	  ite.next();
	  ite.add((Integer) 4);
	  ite.next(); ite.next(); ite.previous();

	  assertEquals("Iterator previous",(Integer) 3,ite.next());
	    try 
	    {
	      ite = empty.listIterator();
	      ite.next();
	      fail("Should have generated an exception");  
	    }
	    catch(NoSuchElementException e)
	    {
	      //  normal
	    }
  }
  
  /** Test iterator nextIndex method */
  @Test
  public void testItNextIndex(){
	  ListIterator<Integer> ite;
	  ite = several.listIterator();
	  ite.next();
	  ite.add((Integer) 4);
	  ite.next(); //ite.next(); ite.previous();

	  assertEquals("Iterator nextIndex",(int) 2,ite.nextIndex());
  }
  
  /** Test iterator previousIndex method */
  @Test
  public void testItPreviousIndex(){
	  ListIterator<Integer> ite;
	  ite = several.listIterator();
	  ite.next();
	  ite.add((Integer) 4);
	  ite.next(); ite.next(); ite.previous();

	  assertEquals("Iterator previousIndex",(int) 2,ite.previousIndex());
  }
  
  /** Test iterator set method */
  @Test
  public void testItSet(){
	  ListIterator<Integer> ite;
	  ite = several.listIterator();
	  ite.next();
	  ite.add((Integer) 4);
	  ite.next();
	  ite.set((Integer) 9);
	  assertEquals("Iterator set",(Integer) 3,ite.next());
	    try 
	    {
	      ite.next();
	      ite.set(null);
	      ite.add((Integer) 4);
	      ite.set((Integer) 9);
	      fail("Should have generated an exception");  
	    }
	    catch(NullPointerException e){}
	    catch(IllegalStateException e){}
  }
  
  /** Test iterator remove method */
  @Test
  public void testItRemove(){
	  ListIterator<Integer> ite;
	  ite = several.listIterator();
	  ite.next();
	  ite.next();
	  ite.remove();
	  assertEquals("Iterator remove",(Integer) 3,ite.next());
	    try 
	    {
	      ite.add((Integer) 4);
	      ite.remove();
	      fail("Should have generated an exception");  
	    }
	    catch(IllegalStateException e){}
  }
  
}