package sequencia.stacks;

public interface Sequencia<E> {
    int size();
    boolean isEmpty();

    E elemAtRank(int r);
    E replaceAtRank(int r, E o);
    void insertAtRank(int r, E o);
    E removeAtRank(int r);

    Position<E> first();
    Position<E> last();
    Position<E> before(Position<E> p);
    Position<E> after(Position<E> p);
    Position<E> insertBefore(Position<E> p, E o);
    Position<E> insertAfter(Position<E> p, E o);
    Position<E> insertFirst(E o);
    Position<E> insertLast(E o);
    E remove(Position<E> p);
    E replaceElement(Position<E> p, E o);
    void swapElements(Position<E> p, Position<E> q);

    Position<E> atRank(int r);
    int rankOf(Position<E> p);
}