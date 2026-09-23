package lista;

public class DuplamenteEncadeada<T> implements ListaTAD<T> {

    private static class Node<T> implements Position<T> {
        T element;
        Node<T> prev;
        Node<T> next;

        Node(T element, Node<T> prev, Node<T> next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }

        @Override
        public T getElement() {
            return this.element;
        }
    }

    private Node<T> header_sentinela;
    private Node<T> tail_sentinela;
    private int size;

    public DuplamenteEncadeada() {
        header_sentinela = new Node<>(null, null, null);
        tail_sentinela = new Node<>(null, header_sentinela, null);
        header_sentinela.next = tail_sentinela;
        size = 0;
    }

    private Node<T> checkPosition(Position<T> p) {
        if (p == null) {
            throw new IllegalArgumentException("Posição inválida.");
        }
        return (Node<T>) p;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFirst(Position<T> p) {
        return checkPosition(p).prev == header_sentinela;
    }

    @Override
    public boolean isLast(Position<T> p) {
        return checkPosition(p).next == tail_sentinela;
    }

    @Override
    public Position<T> first() {
        if (isEmpty()) return null;
        return header_sentinela.next;
    }

    @Override
    public Position<T> last() {
        if (isEmpty()) return null;
        return tail_sentinela.prev;
    }

    @Override
    public Position<T> before(Position<T> p) {
        Node<T> node = checkPosition(p);
        if (node.prev == header_sentinela) {
            return null;
        }
        return node.prev;
    }

    @Override
    public Position<T> after(Position<T> p) {
        Node<T> node = checkPosition(p);
        if (node.next == tail_sentinela) {
            return null;
        }
        return node.next;
    }

    @Override
    public T replaceElement(Position<T> p, T element) {
        Node<T> node = checkPosition(p);
        T antigo = node.element;
        node.element = element;
        return antigo;
    }

    @Override
    public void swapElements(Position<T> p, Position<T> q) {
        Node<T> nodeP = checkPosition(p);
        Node<T> nodeQ = checkPosition(q);
        T temp = nodeP.element;
        nodeP.element = nodeQ.element;
        nodeQ.element = temp;
    }

    @Override
    public Position<T> insertBefore(Position<T> p, T element) {
        Node<T> node = checkPosition(p);
        Node<T> novo = new Node<>(element, node.prev, node);
        node.prev.next = novo;
        node.prev = novo;
        size++;
        return novo;
    }

    @Override
    public Position<T> insertAfter(Position<T> p, T element) {
        Node<T> node = checkPosition(p);
        Node<T> novo = new Node<>(element, node, node.next);
        node.next.prev = novo;
        node.next = novo;
        size++;
        return novo;
    }

    @Override
    public Position<T> insertFirst(T element) {
        Node<T> novo = new Node<>(element, header_sentinela, header_sentinela.next);
        header_sentinela.next.prev = novo;
        header_sentinela.next = novo;
        size++;
        return novo;
    }

    @Override
    public Position<T> insertLast(T element) {
        Node<T> novo = new Node<>(element, tail_sentinela.prev, tail_sentinela);
        tail_sentinela.prev.next = novo;
        tail_sentinela.prev = novo;
        size++;
        return novo;
    }

    @Override
    public T remove(Position<T> p) {
        Node<T> node = checkPosition(p);
        T removido = node.element;

        node.prev.next = node.next;
        node.next.prev = node.prev;

        size--;
        return removido;
    }
}
