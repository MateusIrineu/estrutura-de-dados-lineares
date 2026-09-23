public class VetorListaDupla<E> implements Interface<E> {

    private static class Node<E> {
        E element;
        Node<E> prev;
        Node<E> next;

        Node(E element, Node<E> prev, Node<E> next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }
    }

    private final Node<E> header;
    private final Node<E> trailer;
    private int n;

    public VetorListaDupla() {
        header = new Node<>(null, null, null);
        trailer = new Node<>(null, header, null);
        header.next = trailer;
        n = 0;
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

    private Node<E> nodeAtRank(int r) {
        Node<E> node;
        if (r <= n / 2) {
            node = header.next;
            for (int i = 0; i < r; i++) {
                node = node.next;
            }
        } else {
            node = trailer.prev;
            for (int i = 0; i < n - r - 1; i++) {
                node = node.prev;
            }
        }
        return node;
    }

    @Override
    public E elemAtRank(int r) {
        checkRank(r, n - 1);
        return nodeAtRank(r).element;
    }

    @Override
    public E replaceAtRank(int r, E o) {
        checkRank(r, n - 1);
        Node<E> node = nodeAtRank(r);
        E temp = node.element;
        node.element = o;
        return temp;
    }

    @Override
    public void insertAtRank(int r, E o) {
        checkRank(r, n);
        Node<E> successor = (r == n) ? trailer : nodeAtRank(r);
        Node<E> predecessor = successor.prev;
        Node<E> newNode = new Node<>(o, predecessor, successor);
        predecessor.next = newNode;
        successor.prev = newNode;
        n++;
    }

    @Override
    public E removeAtRank(int r) {
        checkRank(r, n - 1);
        Node<E> node = nodeAtRank(r);
        Node<E> predecessor = node.prev;
        Node<E> successor = node.next;

        predecessor.next = successor;
        successor.prev = predecessor;

        E temp = node.element;
        node.prev = null;
        node.next = null;
        n--;
        return temp;
    }
}