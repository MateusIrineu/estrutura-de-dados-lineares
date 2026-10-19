package sequencia.stacks;

public class ListaDuplaSequencia<E> implements Sequencia<E> {

    private static class No<E> implements Position<E> {
        E elemento;
        No<E> anterior;
        No<E> proximo;

        No(E elemento, No<E> anterior, No<E> proximo) {
            this.elemento = elemento;
            this.anterior = anterior;
            this.proximo = proximo;
        }

        public E getElemento() {
            return elemento;
        }
    }

    private No<E> header;
    private No<E> trailer;
    private int tamanho;

    public ListaDuplaSequencia() {
        header = new No<>(null, null, null);
        trailer = new No<>(null, header, null);
        header.proximo = trailer;
        tamanho = 0;
    }

    public int size() { return tamanho; }
    public boolean isEmpty() { return tamanho == 0; }

    public Position<E> atRank(int rank) {
        No<E> node;
        if (rank <= size() / 2) {
            node = header.proximo;
            for (int i = 0; i < rank; i++) {
                node = node.proximo;
            }
        } else {
            node = trailer.anterior;
            for (int i = 0; i < size() - rank - 1; i++) {
                node = node.anterior;
            }
        }
        return node;
    }

    public int rankOf(Position<E> p) {
        No<E> no = (No<E>) p;
        No<E> n = header.proximo;
        int r = 0;
        while (n != no && n != trailer) {
            n = n.proximo;
            r++;
        }
        return r;
    }

    public E elemAtRank(int r) {
        return atRank(r).getElemento();
    }

    public E replaceAtRank(int r, E o) {
        No<E> no = (No<E>) atRank(r);
        E antigo = no.elemento;
        no.elemento = o;
        return antigo;
    }

    public void insertAtRank(int r, E o) {
        if (r == tamanho) {
            insertLast(o);
        } else {
            insertBefore(atRank(r), o);
        }
    }

    public E removeAtRank(int r) {
        return remove(atRank(r));
    }

    public Position<E> first() { return header.proximo; }
    public Position<E> last() { return trailer.anterior; }
    
    public Position<E> before(Position<E> p) {
        return ((No<E>) p).anterior;
    }
    
    public Position<E> after(Position<E> p) {
        return ((No<E>) p).proximo;
    }

    public Position<E> insertBefore(Position<E> p, E o) {
        No<E> noAtual = (No<E>) p;
        No<E> novoNo = new No<>(o, noAtual.anterior, noAtual);
        noAtual.anterior.proximo = novoNo;
        noAtual.anterior = novoNo;
        tamanho++;
        return novoNo;
    }

    public Position<E> insertAfter(Position<E> p, E o) {
        No<E> noAtual = (No<E>) p;
        No<E> novoNo = new No<>(o, noAtual, noAtual.proximo);
        noAtual.proximo.anterior = novoNo;
        noAtual.proximo = novoNo;
        tamanho++;
        return novoNo;
    }

    public Position<E> insertFirst(E o) { return insertAfter(header, o); }
    public Position<E> insertLast(E o) { return insertBefore(trailer, o); }

    public E remove(Position<E> p) {
        No<E> no = (No<E>) p;
        no.anterior.proximo = no.proximo;
        no.proximo.anterior = no.anterior;
        tamanho--;
        return no.elemento;
    }

    public E replaceElement(Position<E> p, E o) {
        No<E> no = (No<E>) p;
        E antigo = no.elemento;
        no.elemento = o;
        return antigo;
    }

    public void swapElements(Position<E> p, Position<E> q) {
        No<E> noP = (No<E>) p;
        No<E> noQ = (No<E>) q;
        E temp = noP.elemento;
        noP.elemento = noQ.elemento;
        noQ.elemento = temp;
    }
}