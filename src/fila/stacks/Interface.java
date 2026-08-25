package stacks;

public interface Interface {
    void enqueue(Object o);

    Object dequeue() throws EFilaVazia;

    Object first() throws EFilaVazia;

    int size();

    boolean isEmpty();
}