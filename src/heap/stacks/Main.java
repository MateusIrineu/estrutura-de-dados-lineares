package heap.stacks;

public class Main {
    public static void main(String[] args) {
        
        System.out.println("--- Teste: FilaPrioridadeVetor ---");
        FilaPrioridadeVetor filaVetor = new FilaPrioridadeVetor(10);
        
        System.out.println("Esta vazia? " + filaVetor.isEmpty());
        
        filaVetor.insert(8);
        filaVetor.insert(3);
        filaVetor.insert(10);
        filaVetor.insert(1);
        filaVetor.insert(5);
        
        System.out.println("Tamanho atual: " + filaVetor.size());
        System.out.println("Menor elemento (min): " + filaVetor.min());
        System.out.println("Esta vazia? " + filaVetor.isEmpty());
        
        System.out.print("Removendo elementos (ordem esperada 1, 3, 5, 8, 10): ");
        while (!filaVetor.isEmpty()) {
            System.out.print(filaVetor.removeMin() + " ");
        }
        System.out.println("\n");

        System.out.println("--- Teste: FilaPrioridadeNos ---");
        FilaPrioridadeNos filaNos = new FilaPrioridadeNos();
        
        System.out.println("Esta vazia? " + filaNos.isEmpty());
        
        filaNos.insert(8);
        filaNos.insert(3);
        filaNos.insert(10);
        filaNos.insert(1);
        filaNos.insert(5);
        
        System.out.println("Tamanho atual: " + filaNos.size());
        System.out.println("Menor elemento (min): " + filaNos.min());
        System.out.println("Esta vazia? " + filaNos.isEmpty());
        
        System.out.print("Removendo elementos (ordem esperada 1, 3, 5, 8, 10): ");
        while (!filaNos.isEmpty()) {
            System.out.print(filaNos.removeMin() + " ");
        }
        System.out.println();
    }
}
