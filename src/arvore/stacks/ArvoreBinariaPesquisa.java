package arvore.stacks;

public class ArvoreBinariaPesquisa {

    class No {
        int valor;
        No esquerdo, direito;

        public No(int item) {
            valor = item;
            esquerdo = direito = null;
        }
    }

    No raiz;

    public ArvoreBinariaPesquisa() {
        raiz = null;
    }

    public void inserir(int valor) {
        raiz = inserirRecursivo(raiz, valor);
    }

    private No inserirRecursivo(No raiz, int valor) {
        if (raiz == null) {
            raiz = new No(valor);
            return raiz;
        }

        if (valor < raiz.valor) {
            raiz.esquerdo = inserirRecursivo(raiz.esquerdo, valor);
        } else if (valor > raiz.valor) {
            raiz.direito = inserirRecursivo(raiz.direito, valor);
        }

        return raiz;
    }

    public boolean buscar(int valor) {
        return buscarRecursivo(raiz, valor) != null;
    }

    private No buscarRecursivo(No raiz, int valor) {
        if (raiz == null || raiz.valor == valor) {
            return raiz;
        }

        if (raiz.valor > valor) {
            return buscarRecursivo(raiz.esquerdo, valor);
        }

        return buscarRecursivo(raiz.direito, valor);
    }

    public void remover(int valor) {
        raiz = removerRecursivo(raiz, valor);
    }

    private No removerRecursivo(No raiz, int valor) {
        if (raiz == null) return raiz;

        if (valor < raiz.valor) {
            raiz.esquerdo = removerRecursivo(raiz.esquerdo, valor);
        } else if (valor > raiz.valor) {
            raiz.direito = removerRecursivo(raiz.direito, valor);
        } else {
            if (raiz.esquerdo == null) {
                return raiz.direito;
            } else if (raiz.direito == null) {
                return raiz.esquerdo;
            }

            raiz.valor = valorMinimo(raiz.direito);
            raiz.direito = removerRecursivo(raiz.direito, raiz.valor);
        }

        return raiz;
    }

    private int valorMinimo(No raiz) {
        int minV = raiz.valor;
        while (raiz.esquerdo != null) {
            minV = raiz.esquerdo.valor;
            raiz = raiz.esquerdo;
        }
        return minV;
    }

public void mostrar() {
        mostrarRecursivo(raiz, 0);
    }

    private void mostrarRecursivo(No no, int espaco) {
        if (no == null) return;

        int DISTANCIA = 6;
        espaco += DISTANCIA;

        mostrarRecursivo(no.direito, espaco);

        System.out.print("\n");
        for (int i = DISTANCIA; i < espaco; i++) {
            System.out.print(" ");
        }
        System.out.print(no.valor + "\n");

        mostrarRecursivo(no.esquerdo, espaco);
    }
}