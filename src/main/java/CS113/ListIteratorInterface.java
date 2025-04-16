package CS113;

public interface ListIteratorInterface<E> {
    /**
     * Adding an element after the current
     * @param element
     */
    void add(E element);

    /**
     * Is there a next element?
     * @return
     */
    boolean hasNext();

    /**
     * Is there a previous element?
     * @return
     */
    boolean hasPrevious();

    /**
     * The next element in the list
     * @return
     */
    E next();

    /**
     * The previous element in the list
     * @return
     */
    E previous();

    /**
     * Removes the 'current' element
     */
    void remove();

    /**
     * Replaces the 'current' element
     * @param element the new element data
     */
    void set(E element);

    /**
     * Return the index of the next element
     * @return index value of next
     */
    int nextIndex();

    /**
     * Returns the index of the previous element
     * @return index value of previous
     */
    int previousIndex();
}