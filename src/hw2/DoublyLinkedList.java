/*
 * Name: Jinxiao Chen
 * ID:A14236655
 * Login:cs12xii
 */

/**
 * TODO - your comments here
 */

package hw2;

import java.util.*;

//some comments

public class DoublyLinkedList<E> extends AbstractList<E> {

	private int nelems;   //No. of items in the list
	private Node head;
	private Node tail;

	protected class Node {

		E data;
		Node next;
		Node prev;

		/** Constructor to create singleton Node */
		public Node(E element)
		{
			data = element;
//			Node nod = new Node(data);
		}
		/** Constructor to create singleton link it between previous and next 
		 *   @param element Element to add, can be null
		 *   @param prevNode predecessor Node, can be null
		 *   @param nextNode successor Node, can be null 
		 */
		public Node(E element, Node prevNode, Node nextNode)
		{
			data = element;
			Node nod = new Node(data);
			next = nextNode;
			prev = prevNode;
		}
		/** Remove this node from the list. Update previous and next nodes */
		public void remove()
		{	
		}
		/** Set the previous node in the list
		 *  @param p new previous node
		 */
		public void setPrev(Node p)
		{
			prev = p;
		}
		/** Set the next node in the list
		 *  @param n new next node
		 */
		public void setNext(Node n)
		{
			next = n;
		}

		/** Set the element 
		 *  @param e new element 
		 */
		public void setElement(E e)
		{
			data = e;
		}
		/** Accessor to get the next Node in the list */
		public Node getNext()
		{
			return (Node) next; // XXX-CHANGE-XXX
		}
		/** Accessor to get the prev Node in the list */
		public Node getPrev()
		{
			return (Node) prev; // XXX-CHANGE-XXX
		} 
		/** Accessor to get the Nodes Element */
		public E getElement()
		{
			return (E) data; // XXX-CHANGE-XXX
		} 
	}

	/** ListIterator implementation */ 

	protected class MyListIterator implements ListIterator<E> {

		private boolean forward;
		private boolean canRemove;
		private Node left,right; // Cursor sits between these two nodes
		private int index;        
		// Tracks current position. what next() would return

		public MyListIterator()
		{
			MyListIterator it = new MyListIterator();
		}

		@Override
		public void add(E e) throws  NullPointerException
		{
		}
		@Override
		public boolean hasNext()
		{
			return false; // XXX-CHANGE-XXX
		}

		@Override
		public boolean hasPrevious()
		{
			return false; // XXX-CHANGE-XXX
		}
		@Override
		public E next() throws NoSuchElementException
		{
			return (E) null;  // XXX-CHANGE-XXX
		}
		@Override
		public int nextIndex()
		{
			return 0; // XXX-CHANGE-XXX
		}
		@Override
		public E previous() throws NoSuchElementException
		{
			return (E) null; // XXX-CHANGE-XXX
		}

		@Override
		public int previousIndex()
		{
			return 0;  // XXX-CHANGE-XXX
		}
		@Override
		public void remove() throws IllegalStateException
		{
		}
		@Override
		public void set(E e) 
				throws NullPointerException,IllegalStateException
		{
		}

	}

	//  Implementation of the DoublyLinkedList Class


	/** Only 0-argument constructor is define */
	/**
	 * Creates a new, empty doubly-linked list.
	 */
	public DoublyLinkedList()
	{
		head = new Node(null);
		tail = new Node(null);
		head.next = tail;
		tail.prev = head;
	}

	/**
	 * Retrieves the amount of elements that are currently on the list.
	 * 
	 * @return Number of elements currently on the list
	 */
	@Override
	public int size()
	{
		return nelems; // XXX-CHANGE-XXX 
	}

	/**
	 * Adds an element to a certain index in the list, shifting exist elements
	 * create room. Does not accept null values.
	 * 
	 * @param index Where in the list to add the element.
	 * @param data Data to be added.
	 * @throws IndexOutOfBoundsException if index received is out of bounds for 
	 *             the current list. 
	 * @throws NullPointerException if data received is null.
	 */
	@Override
	public void add(int index, E data) 
			throws IndexOutOfBoundsException,NullPointerException
	{
		if(data == null){
			throw new NullPointerException();
		}
		if(index < 0 || index > nelems){
			throw new IndexOutOfBoundsException();
		}
		
		Node curNode = head;
//		Node preNode = new Node(null);
		for(int i = 0; i <= index; i ++){
//			preNode = curNode;
			curNode = curNode.next;
		}
		Node newNode = new Node(data);
		curNode.prev.next = newNode;
		newNode.prev = curNode.prev;
		newNode.next = curNode;
		curNode.prev = newNode;
//		System.out.printf("%s\n", head.next.getElement());
		nelems ++;
	}

	/**
	 * Add an element to the end of the list
	 * 
	 * @param the data which is added
	 * @return always true when user attempt to add an element 
	 * @throws NullPointerException if user try to add a null data
	 */
	@Override
	public boolean add(E data) throws NullPointerException
	{
		if(data == null){
			throw new NullPointerException();
		}
		/*
		Node curNode = head;
		if(curNode.next == null){
			curNode.prev = head;
			curNode.next = tail;
		}
		else{*/
			Node newNode = new Node(data);
			tail.prev.next = newNode;
			newNode.prev = tail.prev;
			newNode.next= tail;
			tail.prev = newNode;
			
		
		nelems ++;
		return true; // XXX-CHANGE-XXX
	}

	/**
	 * Retrieves the element stored with a given index on the list.
	 * 
	 * @param index The index of the desired element.
	 * @return The element stored in the Node with the desired index.
	 * @throws IndexOutOfBoundsException if index received is out of bounds for 
	 *             the current list. 
	 */
	@Override
	public E get(int index) throws IndexOutOfBoundsException
	{
		Node myNode = head;
		if(index < 0 || index >= nelems){
			throw new IndexOutOfBoundsException();
		}
		/*
		if(index == 0){
			myNode = head.next;
		}*/
		
		for(int i = 0; i <= index; i ++){
			myNode = myNode.next;
		}
		//System.out.printf("%s\n", head.next.getElement());
		return myNode.getElement();
	}

	/**
	 * Retrieves the last index of the item passed as a parameter
	 * 
	 * @param Item whose index is to be retrieved
	 * @return index The index of the desired item, -1 if the item is not found.
	 * @throws NullPointerException if item passed is null
	 */
	@Override
	public int lastIndexOf(Object o) throws NullPointerException {
	   return -1; //XXX-CHANGE-XXX
	}
	/**
	 * Sets the value of an element at a certain index in the list.
	 * 
	 * @param index Where in the list the data should be added.
	 * @param data Data to add.
	 * @return Element that was previously at this index.
	 * @throws IndexOutOfBoundsException if index received is out of bounds for 
	 *             the current list. 
	 * @throws NullPointerException if data received is null.
	 */
	@Override
	public E set(int index, E data) 
			throws IndexOutOfBoundsException,NullPointerException
	{
		Node myNode = head;
		if(index < 0 || index >= nelems){
			throw new IndexOutOfBoundsException();
		}
		if(data == null){
			throw new NullPointerException();
		}
		for(int i = 0; i <= index; i ++){
			myNode = myNode.next;
		}
		myNode.setElement(data);
		return myNode.data;
	}

	@Override
	public E remove(int index) throws IndexOutOfBoundsException
	{
		return (E) null; // XXX-CHANGE-XXX
	}

	/**Returns true if this list contains the specified element,
	 * false otherwise.
	 * @param data to be searched in the list
	 * @return true if the data is in the list, false otherwise
	 * @throws NullPointerException if the data is null
	 */
	@Override
	public boolean contains(Object o) throws NullPointerException {

		return false; //XXX-CHANGE-XXX
	}
	/**Removes the first occurrence of the specified element in this list,
	 * (when traversing the list from head to tail).
	 * If the list does not contain the element, it is unchanged.
	 * @param data to be removed from the list
	 * @return true if the data is in the list, false otherwise
	 * @throws NullPointerException if the data is null
	 */
	public boolean removeFirstOccurrence(Object o) throws NullPointerException {
		return false; //XXX-CHANGE-XXX
	}
	/** Clear the linked list */
	public void clear()
	{
		head.next = tail;
		tail.prev = head;
	}

	/** Determine if the list empty 
	 * 
	 *  @return true if empty, false otherwise
	 */
	public boolean isEmpty()
	{
		return nelems == 0;
	}

	public Iterator<E> QQQiterator()
	{
		return new MyListIterator();
	}
	public ListIterator<E> QQQlistIterator()
	{
		return new MyListIterator();
	}

	// Helper method to get the Node at the Nth index
	private Node getNth(int index) 
	{
		return (Node) null;  // XXX-CHANGE-XXX
	}




	/*  UNCOMMENT the following when you believe your MyListIterator class is
   functioning correctly
   public Iterator<E> iterator()
   {
   return new MyListIterator();
   }
   public ListIterator<E> listIterator()
   {
   return new MyListIterator();
   }
	 */
}