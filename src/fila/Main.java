import stacks.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("        SUÍTE DE TESTES EXCLUSIVA DO TAD FILA     ");
        System.out.println("==================================================\n");

        // Utilizando o tipo 'Interface' que você declarou no projeto
        Interface fila = new FilaListaLigada();

        // -------------------------------------------------------------
        // TESTE 1: Estado Inicial
        // -------------------------------------------------------------
        System.out.println(">>> Teste 1: Estado Inicial da Fila");
        System.out.println("A fila está vazia? " + fila.isEmpty()); // Esperado: true
        System.out.println("Tamanho inicial: " + fila.size());     // Esperado: 0
        System.out.println();

        // -------------------------------------------------------------
        // TESTE 2: Comportamento FIFO (First-In, First-Out)
        // -------------------------------------------------------------
        System.out.println(">>> Teste 2: Inserção e Ordem de Saída (FIFO)");
        System.out.println("Enfileirando: 'Primeiro', 'Segundo', 'Terceiro'");
        fila.enqueue("Primeiro");
        fila.enqueue("Segundo");
        fila.enqueue("Terceiro");

        System.out.println("Tamanho após inserções: " + fila.size()); // Esperado: 3
        
        try {
            System.out.println("Primeiro da fila (first): " + fila.first()); // Esperado: Primeiro

            System.out.println("\nRemovendo elementos um a um:");
            System.out.println("  1º a sair: " + fila.dequeue()); // Esperado: Primeiro
            System.out.println("  2º a sair: " + fila.dequeue()); // Esperado: Segundo
            System.out.println("  3º a sair: " + fila.dequeue()); // Esperado: Terceiro

        } catch (EFilaVazia e) {
            System.out.println("Erro inesperado: " + e.getMessage());
        }

        System.out.println("A fila está vazia após desenfileirar tudo? " + fila.isEmpty()); // Esperado: true
        System.out.println();

        // -------------------------------------------------------------
        // TESTE 3: Caso de Borda - Reutilização após Esvaziar
        // -------------------------------------------------------------
        System.out.println(">>> Teste 3: Reutilização da Fila após Esvaziamento");
        System.out.println("Enfileirando novos itens: 'Novo 1', 'Novo 2'");
        fila.enqueue("Novo 1");
        fila.enqueue("Novo 2");

        System.out.println("Tamanho atual: " + fila.size()); // Esperado: 2
        
        try {
            System.out.println("Primeiro da fila atual: " + fila.first()); // Esperado: Novo 1
            System.out.println("Removido: " + fila.dequeue());              // Esperado: Novo 1
            System.out.println("Removido: " + fila.dequeue());              // Esperado: Novo 2
        } catch (EFilaVazia e) {
            System.out.println("Erro inesperado: " + e.getMessage());
        }
        System.out.println();

        // -------------------------------------------------------------
        // TESTE 4: Disparo de Exceções
        // -------------------------------------------------------------
        System.out.println(">>> Teste 4: Tratamento de Exceção (EFilaVazia)");
        
        try {
            System.out.println("Tentando consultar first() em fila vazia...");
            fila.first();
        } catch (EFilaVazia e) {
            System.out.println("  [SUCESSO - EXCEÇÃO CAPTURADA no first()]: " + e.getMessage());
        }

        try {
            System.out.println("Tentando executar dequeue() em fila vazia...");
            fila.dequeue();
        } catch (EFilaVazia e) {
            System.out.println("  [SUCESSO - EXCEÇÃO CAPTURADA no dequeue()]: " + e.getMessage());
        }

        System.out.println("\n==================================================");
        System.out.println("       TODOS OS TESTES DE FILA FINALIZADOS!       ");
        System.out.println("==================================================");
    }
}