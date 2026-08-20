import stacks.*;

public class Main {
    public static void main(String[] args) {
        Interface pilha = new ListaLigada();

        pilha.push("Primeiro");
        pilha.push("Segundo");

        System.out.println("Topo atual: " + pilha.top());
        System.out.println("Removido: " + pilha.pop());   
        System.out.println("Novo topo: " + pilha.top());   
}