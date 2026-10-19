package sequencia.stacks;

public class Main {

    public static void main(String[] args) {
        System.out.println("listra dupla SEQUENCIA");
        testarSequencia(new ListaDuplaSequencia<>());

        System.out.println("\narray SEQUENCIA");
        testarSequencia(new ArraySequencia<>(20));
    }

    private static void testarSequencia(Sequencia<String> seq) {
        System.out.println("isEmpty inicial: " + seq.isEmpty());
        System.out.println("size inicial: " + seq.size());

        Position<String> pA = seq.insertFirst("A");
        Position<String> pC = seq.insertLast("C");
        Position<String> pB = seq.insertAfter(pA, "B");
        Position<String> pX = seq.insertBefore(pC, "X");
        seq.insertAtRank(4, "E");

        System.out.println("Tamanho apos insercoes: " + seq.size());

        System.out.println("first: " + seq.first().getElemento());
        System.out.println("last: " + seq.last().getElemento());
        System.out.println("antes pB: " + seq.before(pB).getElemento());
        System.out.println("depois pB: " + seq.after(pB).getElemento());

        System.out.println("elemAtRank 2: " + seq.elemAtRank(2));
        System.out.println("atRank 2: " + seq.atRank(2).getElemento());
        System.out.println("rankOf pX: " + seq.rankOf(pX));

        seq.replaceElement(pX, "Y");
        System.out.println("replaceAtRank (antigo): " + seq.replaceAtRank(4, "Z"));
        seq.swapElements(pA, pC);

        System.out.println("Removido por Position pB: " + seq.remove(pB));
        System.out.println("Removido por rank 2: " + seq.removeAtRank(2));

        System.out.print("Elementos restantes no rank: ");
        for (int i = 0; i < seq.size(); i++) {
            System.out.print(seq.elemAtRank(i) + " ");
        }
        System.out.println();
    }
}