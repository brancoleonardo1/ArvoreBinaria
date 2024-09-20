public class ArvoreBinaria {

    // Raiz da árvore
    Node raiz;

    // Construtor da árvore
    public ArvoreBinaria() {
        raiz = null;
    }

    // Método para inserir um novo nó na árvore
    public void inserir(int valor) {
        raiz = inserirRec(raiz, valor);
    }

    // Função recursiva para inserir um novo nó na árvore
    private Node inserirRec(Node raiz, int valor) {
        if (raiz == null) {
            raiz = new Node(valor);
            return raiz;
        }

        if (valor < raiz.valor) {
            raiz.esquerda = inserirRec(raiz.esquerda, valor);
        } else if (valor > raiz.valor) {
            raiz.direita = inserirRec(raiz.direita, valor);
        }

        return raiz;
    }

    // Método para realizar uma busca em ordem (inorder traversal)
    public void emOrdem() {
        emOrdemRec(raiz);
    }

    // Função recursiva para a busca em ordem
    private void emOrdemRec(Node raiz) {
        if (raiz != null) {
            emOrdemRec(raiz.esquerda);
            System.out.print(raiz.valor + " ");
            emOrdemRec(raiz.direita);
        }
    }

    // Método para remover um nó da árvore
    public void remover(int valor) {
        raiz = removerRec(raiz, valor);
    }

    // Função recursiva para remover um nó
    private Node removerRec(Node raiz, int valor) {
        if (raiz == null) {
            return raiz;
        }

        if (valor < raiz.valor) {
            raiz.esquerda = removerRec(raiz.esquerda, valor);
        } else if (valor > raiz.valor) {
            raiz.direita = removerRec(raiz.direita, valor);
        } else {
            // Nó com apenas um filho ou nenhum
            if (raiz.esquerda == null) {
                return raiz.direita;
            } else if (raiz.direita == null) {
                return raiz.esquerda;
            }

            // Nó com dois filhos: obtenha o sucessor em ordem
            raiz.valor = minValor(raiz.direita);

            // Remove o sucessor
            raiz.direita = removerRec(raiz.direita, raiz.valor);
        }

        return raiz;
    }

    // Método para encontrar o valor mínimo
    private int minValor(Node raiz) {
        int minv = raiz.valor;
        while (raiz.esquerda != null) {
            minv = raiz.esquerda.valor;
            raiz = raiz.esquerda;
        }
        return minv;
    }

    public static void main(String[] args) {
        ArvoreBinaria arvore = new ArvoreBinaria();

        arvore.inserir(50);
        arvore.inserir(30);
        arvore.inserir(20);
        arvore.inserir(40);
        arvore.inserir(70);
        arvore.inserir(60);
        arvore.inserir(80);

        // Mostra a árvore em ordem
        System.out.println("Árvore em ordem:");
        arvore.emOrdem();

        // Remoção de um nó
        System.out.println("\n\nRemovendo o nó com valor 20");
        arvore.remover(20);
        System.out.println("Árvore em ordem:");
        arvore.emOrdem();
    }
}