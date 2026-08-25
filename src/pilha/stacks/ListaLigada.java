package stacks;

public class ListaLigada implements Interface {

    private static class Node {
        Object value;
        Node next;
    }

    private Node top;
    private int size;

    public ListaLigada() {
        this.top = null;
        this.size = 0;
    }

    @Override
    public boolean isEmpty() {
        if (this.top == null && size == 0) {
            return true;
        }
        return false;
    }

    @Override
    public void push(Object o) {
        Node newNode = new Node();
        newNode.value = o;
        newNode.next = this.top;
        this.top = newNode;
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Object pop() throws PilhaVaziaExcecao {
        if (isEmpty()) {
            throw new PilhaVaziaExcecao("A Pilha está vazia");
        }
        Object toRemove = this.top.value;
        this.top = this.top.next;
        size--;
        return toRemove;
    }

    @Override
    public Object top() throws PilhaVaziaExcecao {
        if (isEmpty()) {
            throw new PilhaVaziaExcecao("A Pilha está vazia");
        }
        return this.top.value;
    }
}