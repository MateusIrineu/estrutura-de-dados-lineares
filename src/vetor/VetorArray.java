public class VetorArray<E> implements Interface<E> {
    private E[] V;
    private int capacity;
    private int n;

    public VetorArray(int capacity) {
        this.capacity = capacity;
        this.V = (E[]) new Object[capacity];
        this.n = 0;
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    private void checkRank(int r, int maxRank) {
        if (r < 0 || r > maxRank) {
            throw new IndexOutOfBoundsException("Rank inválido: " + r);
        }
    }

    @Override
    public E elemAtRank(int r) {
        checkRank(r, n - 1);
        return V[r];
    }

    @Override
    public E replaceAtRank(int r, E o) {
        checkRank(r, n - 1);
        E temp = V[r];
        V[r] = o;
        return temp;
    }

    @Override
    public void insertAtRank(int r, E o) {
        checkRank(r, n);
        if (n == capacity) {
            resize();
        }
        for (int i = n - 1; i >= r; i--) {
            V[i + 1] = V[i];
        }
        V[r] = o;
        n++;
    }

    @Override
    public E removeAtRank(int r) {
        checkRank(r, n - 1);
        E temp = V[r];
        for (int i = r; i < n - 1; i++) {
            V[i] = V[i + 1];
        }
        V[n - 1] = null;
        n--;
        return temp;
    }

    private void resize() {
        capacity *= 2;
        E[] newV = (E[]) new Object[capacity];
        for (int i = 0; i < n; i++) {
            newV[i] = V[i];
        }
        V = newV;
    }
}