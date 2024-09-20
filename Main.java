public class Main {
    public static void main(String[] args) {
        
        ArvoreBinaria arvore = new ArvoreBinaria();

    
        System.out.println("Inserindo valores na árvore:");
        int[] valoresParaInserir = {50, 30, 20, 40, 70, 60, 80};
        for (int valor : valoresParaInserir) {
            System.out.println("Inserindo: " + valor);
            arvore.inserir(valor);
        }

        System.out.println("\nÁrvore em ordem após inserção:");
        arvore.emOrdem();

        System.out.println("\n\nRemovendo nós da árvore:");
        int[] valoresParaRemover = {20, 30, 50};
        for (int valor : valoresParaRemover) {
            System.out.println("Removendo: " + valor);
            arvore.remover(valor);
            System.out.println("Árvore em ordem após remoção:");
            arvore.emOrdem();
            System.out.println();  // Adiciona um espaço entre cada exibição
        }
    }
}
