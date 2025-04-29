package Interfaces;

public interface StackInterface<E> {
    /**
     * Pushes an item onto the top of the stack and returns the item
     * pushed.
     *
     * @param element The object to be inserted
     * @return The object inserted
     */
    E push(E element);

    /**
     * Returns the object at the top of the stack without removing it.
     *
     * @return The object at the top of the stack
     * @throws NoSuchElementException if stack is empty
     * @post The stack remains unchanged.
     */
    E peek();
    /** Returns the object at the top of the stack and removes it.
     @post The stack is one item smaller.
     @return The object at the top of the stack
     @throws NoSuchElementException if stack is empty
     */
    E pop();
    /** Returns true if the stack is empty; otherwise, returns false.
     @return true (false) if the stack is empty (not empty)
     */
    boolean isEmpty();

    /** Returns the size of the stack
     * @return the total size of the stack
     */
    public int size();
}

