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
			Node node = new Node(data);
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
		private Node curNode;

		public MyListIterator()
		{

			forward = false;
			canRemove = false;
			left = head;
			right = head.next;
			index = -1;
		}
		
		
		/**
		 * Adds a node to a certain index in the list
		 * 
		 * @param e Element to be added.
		 * @throws NullPointerException if data received is null.
		 */
		@Override
		public void add(E e) throws  NullPointerException
		{
			if(e == null){
				throw new NullPointerException();
			}
			Node newNode = new Node(e);
			left.next = newNode;
			newNode.prev = left;
			newNode.next = right;
			right.prev = newNode;
			left = newNode;
			curNode = null;
			index ++;
			
		}
		
		/**
		 * Checks if there is another element to be retrieved by calling next 
		 */
		@Override
		public boolean hasNext()
		{
			curNode = null;
			if(right == tail){
				return false;
			}
			return true; // XXX-CHANGE-XXX
		}
		
		/**
		 * Checks if there is another element to be retrieved by calling 
		 * previous 
		 */
		@Override
		public boolean hasPrevious()
		{
			curNode = null;
			if(left == head){
				return false;
			}
			return true; // XXX-CHANGE-XXX
		}
		
		/**
		 * Advances through the list by one index, and retrieves the next 
		 * element
		 * 
		 * @throws NoSuchElementException if there are no more elements 
		 * remaining in the list for the iterator to retrieve when moving 
		 * forward
		 */
		@Override
		public E next() throws NoSuchElementException
		{
			if(this.hasNext() || this.hasPrevious()){
				throw new NoSuchElementException();
			}
			curNode = right;
			left = left.next;
			right = right.next;
			index ++;
			forward = true;
			return (E) curNode.data;  // XXX-CHANGE-XXX
		}
		/**
		 * Retrieves the index of the next element (that would be retrieved by 
		 * next() call)
		 */
		@Override
		public int nextIndex()
		{
			curNode = null;
			return index; // XXX-CHANGE-XXX
		}
		
		/**
		 * Advances through the list by one index, and retrieves the previous 
		 * element
		 * 
		 * @throws NoSuchElementException if there are no more elements 
		 * remaining in the list for the iterator to retrieve when moving 
		 * backwards
		 */
		@Override
		public E previous() throws NoSuchElementException
		{
			if(this.hasNext() || this.hasPrevious()){
				throw new NoSuchElementException();
			}
			curNode = left;
			left = left.prev;
			right = right.prev;
			index --;
			forward = false;

			return (E) curNode.data;  // XXX-CHANGE-XXX
		}
		
		/**
		 * Retrieves the index of the next element (that would be retrieved by 
		 * previous() call)
		 */
		@Override
		public int previousIndex()
		{
			curNode = null;
			return index;  // XXX-CHANGE-XXX
		}
		
		/**
		 *Removes from the list the last element that was returned by next() or 
		 *previous()
		 * 
		 * @throws IllegalStateException if neither next() nor previous() were 
		 * called, or if add() or remove() were	called since the last 
		 * next()/previous() call.
		 */
		@Override
		public void remove() throws IllegalStateException
		{
			if(curNode == null){
				throw new IllegalStateException();
			}
			right = curNode.next;
			left.next = curNode.next;
			right.prev = curNode.prev;
			curNode.next = null;
			curNode.prev = null;
			index --;
		}
		
		/**
		 * Replaces	the	last element returned by next() or previous() with a 
		 * given element
		 * 
		 * @param 
		 * @throws Throw NullPointerException if the data given	is null
		 * @throws IllegalStateException if neither next() nor previous() were 
		 * called, or if add() or remove() were	called since the last 
		 * next()/previous() call.
		 */
		@Override
		public void set(E e) 
				throws NullPointerException,IllegalStateException
		{
			if(curNode == null){
				throw new IllegalStateException();
			}
			if(e == null){
				throw new NullPointerException();
			}
			curNode.data = e;
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
		if(o == null){
			throw new NullPointerException();
		}
//		if(o instanceof DooublyLinkedList){
		if(this.getNth(nelems - 1) != null){
			return nelems - 1;
		}
		else{
			return -1;	
		}
	    //XXX-CHANGE-XXX
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
	
	/**
	 * remove the element from position i in this list
	 * 
	 * @param index Where the element should be removed.
	 * @return the element that was removed
	 * @throws IndexOutOfBoundsException if index received is out of bounds for 
	 *             the current list. 
	 */
	@Override
	public E remove(int index) throws IndexOutOfBoundsException
	{
		if(index < 0 || index >= nelems){
			throw new IndexOutOfBoundsException();
		}
//		Node nextNode = this.getNth(index).next;
//		Node prevNode = this.getNth(index).prev;
//		prevNode.next = nextNode;
//		nextNode.prev = prevNode;
		this.getNth(index).data = null;
		return (E) this.getNth(index).data; // XXX-CHANGE-XXX
	}

	/**Returns true if this list contains the specified element,
	 * false otherwise.
	 * @param data to be searched in the list
	 * @return true if the data is in the list, false otherwise
	 * @throws NullPointerException if the data is null
	 */
	@Override
	public boolean contains(Object o) throws NullPointerException {
		if(o == null){
			throw new NullPointerException();
		}
		for(int i = 0; i < nelems; i++){
			if(this.getNth(i).data.equals(o)){
				return true;
			}
		}
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
		if(o == null){
			throw new NullPointerException();
		}
		for(int i = 0; i < nelems; i++){
			if(this.getNth(i).data.equals(o)){
				this.getNth(i).data = null;
				return true;
			}
		}
		return false; //XXX-CHANGE-XXX
	}
	/** Clear the linked list and release the nodes */
	public void clear()
	{
		Node myNode = head.next;
		while (myNode != head && myNode.next != null) {
			Node nextNode = myNode.next;
			myNode.next = myNode.prev = null;
			myNode.data = null;
			myNode = nextNode;
		}
		head.next = tail;
		tail.prev = head;
		nelems = 0;
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
		Node myNode = head;
		for(int i = 0; i <= index; i ++){
			myNode = myNode.next;
		}
		return (Node) myNode;  // XXX-CHANGE-XXX
	}




	/*  UNCOMMENT the following when you believe your MyListIterator class is
   functioning correctly
   */
   public Iterator<E> iterator()
   {
   return new MyListIterator();
   }
   public ListIterator<E> listIterator()
   {
   return new MyListIterator();
   }
	 
}