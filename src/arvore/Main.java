package arvore;
import arvore.stacks.ArvoreBinariaPesquisa;;


public class Main {
    public static void main(String[] args) {
        ArvoreBinariaPesquisa arvore = new ArvoreBinariaPesquisa();

        System.out.println("inicio: ");
        arvore.inserir(10);
        arvore.inserir(5);
        arvore.inserir(15);
        arvore.inserir(2);
        arvore.inserir(8);
        arvore.inserir(22);
        
        arvore.mostrar();
        System.out.println();

        System.out.println("add 25: ");
        arvore.inserir(25);
        
        arvore.mostrar();
        System.out.println();

        System.out.println("removeendo 5: ");
        arvore.remover(5);
        
        arvore.mostrar();
        System.out.println();
    }
}