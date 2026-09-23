package lista;

public class Main {
    public static void main(String[] args) {
        ListaTAD<String> lista = new DuplamenteEncadeada<>();

        System.out.println("teste empty:  " + lista.isEmpty());
        System.out.println("teste size inicio: " + lista.size());

        Position<String> posB = lista.insertFirst("B");
        Position<String> posA = lista.insertFirst("A");
        Position<String> posD = lista.insertLast("D");
        Position<String> posC = lista.insertBefore(posD, "C");
        Position<String> posE = lista.insertAfter(posD, "E");

        System.out.println("\n DEPOIS ");
        System.out.println("teste empty: " + lista.isEmpty());
        System.out.println("teste size atual: " + lista.size());
        System.out.println("teste first element: " + lista.first().getElement());
        System.out.println("teste last element: " + lista.last().getElement());

        System.out.println("\n CHECAGEM ");
        System.out.println("posA primeiro? " + lista.isFirst(posA));
        System.out.println("posA último? " + lista.isLast(posA));
        System.out.println("posE último? " + lista.isLast(posE));
        System.out.println("elemento antes de posC: " + lista.before(posC).getElement());
        System.out.println("elemento depois de posC: " + lista.after(posC).getElement());

        System.out.println("\n ATUALIZAÇÃO ");
        String antigo = lista.replaceElement(posC, "C_modificado");
        System.out.println("Elemento substituído em posC: " + antigo);
        System.out.println("Novo valoR posC: " + posC.getElement());

        lista.swapElements(posA, posE);
        System.out.println("trocando posA e posE:");
        System.out.println("new first: " + lista.first().getElement());
        System.out.println("new last: " + lista.last().getElement());

        System.out.println("\n REMOVENDO ");
        String removed = lista.remove(posC);
        System.out.println("elemento removed: " + removed);
        System.out.println("size final: " + lista.size());
    }
}