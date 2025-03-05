package CS113;

public interface DequeInterface <E> {
    /**
     * Inserts at the beginning of the collection
     *
     * @param element
     */
    void addFirst(E element);

    /**
     * Inserts at the end of the collection
     *
     * @param element
     */
    void addLast(E element);

    /**
     * Removes the first element of the collection
     *
     * @return
     */
    E removeFirst();

    /**
     * Removes the last element of the collection
     *
     * @return
     */
    E removeLast();   // Remove from the back

    /**
     * Looks at the first element of the collection
     *
     * @return
     */
    E peekFirst();

    /**
     * Looks at the last element of the collection
     *
     * @return
     */
    E peekLast();

    /**
     * Removes and returns the first element of the collection
     *
     * @return
     */
    E pollFirst();

    /**
     * Removes and returns the last element of the collection
     *
     * @return
     */
    E pollLast();

    /**
     * Checks to see if the collection is empty
     *
     * @return true if empty
     */
    boolean isEmpty();

    /**
     * Returns the size of the collection
     *
     * @return number of elements
     */
    int size();
}