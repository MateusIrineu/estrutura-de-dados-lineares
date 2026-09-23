package vetor;

public interface Interface<E> {
    int size();
    boolean isEmpty();
    E elemAtRank(int r);
    E replaceAtRank(int r, E o);
    void insertAtRank(int r, E o);
    E removeAtRank(int r);
}