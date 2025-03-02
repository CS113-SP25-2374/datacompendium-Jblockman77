package CS113;

public interface QueueInterface<E> {
    /**
     * Pushes an item onto the top of the queue and returns the item
     * pushed.
     *
     * @param element The object to be inserted
     * @return The object inserted
     */
    E push(E element);

    /**
     * Returns the object at the top of the queue without removing it.
     *
     * @return The object at the top of the Queue
     */
    E peek();
    /** Returns the object at the top of the Queue and removes it.
     @post The stack is one item smaller.
     @return The object at the top of the Queue
     */
    E pop();
    /** Returns true if the queue is empty; otherwise, returns false.
     @return true (false) if the queue is empty (not empty)
     */
    boolean isEmpty();

    /** Returns the size of the queue
     * @return the total size of the queue
     */
    public int size();
}

