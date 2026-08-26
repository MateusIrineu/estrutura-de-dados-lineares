package atividades.RubroNegra;

public class Main {
    public static void main(String[] args) {
        // 1. Criamos a pilha com capacidade inicial bem pequena (4) para testar os aumentos
        RubroNegra pilha = new RubroNegra(4);

        System.out.println("=== 1. TESTANDO INSERÇÕES (PUSH) ===");
        pilha.pushRed(10);
        pilha.pushRed(20);
        pilha.pushBlack(99);
        pilha.pushBlack(88);

        // O vetor está cheio (4/4). Ao inserir o 5º elemento, ele deve duplicar para capacidade 8
        pilha.pushRed(30);

        System.out.println("Topo da Vermelha (esperado 30): " + pilha.topRed());
        System.out.println("Topo da Preta (esperado 88): " + pilha.topBlack());
        System.out.println("Tamanho da Vermelha (esperado 3): " + pilha.sizeRed_());
        System.out.println("Tamanho da Preta (esperado 2): " + pilha.sizeBlack_());

        System.out.println("\n=== 2. TESTANDO REMOÇÕES (POP) ===");
        System.out.println("Removendo da Vermelha: " + pilha.popRed()); // Remove 30
        System.out.println("Removendo da Preta: " + pilha.popBlack());    // Remove 88

        // Aqui restam apenas 3 elementos (20, 10 na vermelha e 99 na preta).
        // Se removermos mais 1, a ocupação cai para <= 1/3 e o vetor deve encolher
        System.out.println("Removendo da Preta: " + pilha.popBlack());    // Remove 99

        System.out.println("\n=== 3. ESTADO FINAL ===");
        System.out.println("Novo Topo da Vermelha (esperado 20): " + pilha.topRed());
        System.out.println("A pilha preta está vazia? (esperado true): " + pilha.isEmptyBlack());
    }
}