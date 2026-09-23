package lista;

public interface ListaTAD<T> {
    int size();
    boolean isEmpty();

    boolean isFirst(Position<T> n);
    boolean isLast(Position<T> n);

    Position<T> first();
    Position<T> last();
    Position<T> before(Position<T> p);
    Position<T> after(Position<T> p);

    T replaceElement(Position<T> n, T o);
    void swapElements(Position<T> n, Position<T> q);
    Position<T> insertBefore(Position<T> n, T o);
    Position<T> insertAfter(Position<T> n, T o);
    Position<T> insertFirst(T o);
    Position<T> insertLast(T o);
    T remove(Position<T> n);
}