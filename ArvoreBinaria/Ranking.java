// RankingJogadores.java
public class Ranking {
    TreeNode raiz;
    private int contador;

    public Ranking() {
        this.raiz = null;
    }

    // 1. INSERIR PONTUAÇÃO (Mantendo a ordenação da BST)
    public void inserirPontuacao(int pontuacao, String nome) {
        // O retorno da recursão é fundamental para não "perder" a árvore[cite: 4]
        raiz = inserirRecursivo(raiz, pontuacao, nome);
    }

    private TreeNode inserirRecursivo(TreeNode atual, int pontuacao, String nome) {
        // Encontrou posição vazia: cria o novo nó[cite: 4]
        if (atual == null) {
            return new TreeNode(pontuacao, nome);
        }

        // Se for menor, vai para a subárvore esquerda[cite: 4]
        if (pontuacao < atual.pontuacao) {
            atual.esquerda = inserirRecursivo(atual.esquerda, pontuacao, nome);
        } 
        // Se for maior, vai para a subárvore direita[cite: 4]
        else if (pontuacao > atual.pontuacao) {
            atual.direita = inserirRecursivo(atual.direita, pontuacao, nome);
        }
        
        return atual; // Retorna o nó atualizado para não desconectar a árvore[cite: 4]
    }

    // 2. BUSCAR PONTUAÇÃO (Eficiência O(log n))[cite: 4]
    public boolean buscarPontuacao(int pontuacao) {
        TreeNode atual = raiz;
        
        while (atual != null) {
            if (pontuacao == atual.pontuacao) {
                return true; // Encontrou[cite: 4]
            } else if (pontuacao < atual.pontuacao) {
                atual = atual.esquerda; // Descarta metade direita[cite: 4]
            } else {
                atual = atual.direita;  // Descarta metade esquerda[cite: 4]
            }
        }
        return false; // Chegou em null, pontuação não existe
    }

    // 3. BUSCAR JOGADOR POR NOME[cite: 4]
    // Como a árvore é ordenada por PONTOS e não por NOME, precisamos percorrer toda a árvore
    public boolean buscarJogador(String nome) {
        return buscarJogadorRecursivo(raiz, nome);
    }

    private boolean buscarJogadorRecursivo(TreeNode atual, String nome) {
        if (atual == null) {
            return false;
        }
        // Usando .equals() para comparar Strings, conforme alerta de "Erros Comuns" no slide 41[cite: 4]
        if (atual.nomeJogador.equals(nome)) {
            return true;
        }
        // Busca nos filhos da esquerda e da direita
        return buscarJogadorRecursivo(atual.esquerda, nome) || buscarJogadorRecursivo(atual.direita, nome);
    }

    // 4. CONTAR JOGADORES[cite: 4]
    public int contarJogadores() {
        return contarRecursivo(raiz);
    }

    private int contarRecursivo(TreeNode atual) {
        if (atual == null) {
            return 0;
        }
        // Conta 1 (nó atual) + total da esquerda + total da direita
        return 1 + contarRecursivo(atual.esquerda) + contarRecursivo(atual.direita);
    }

    // MÉTODO EXTRA (Para visualização / Percurso em Ordem)
    // Percorre Direita -> Raiz -> Esquerda para exibir do MAIOR para o MENOR ponto
    public void exibirRanking() {
        System.out.println("=== RANKING DO TORNEIO ===");
        if (raiz == null) System.out.println("Nenhum jogador cadastrado.");
        exibirRankingRecursivo(raiz);
        System.out.println("==========================");
    }

    private void exibirRankingRecursivo(TreeNode atual) {
        if (atual != null) {
            exibirRankingRecursivo(atual.direita); // Visita maiores primeiro
            System.out.println(atual.pontuacao + " pts - " + atual.nomeJogador);
            exibirRankingRecursivo(atual.esquerda); // Visita menores depois
        }
    }

    public void exibirTop3() {
        this.contador = 0;
        System.out.println("Os Top3 são: ");
        exibirTop3Recursivo(raiz);
        System.out.println();
    }
    
    private void exibirTop3Recursivo(TreeNode atual) {
        if (atual == null || contador >= 3) {
            return;
        }
        exibirTop3Recursivo(atual.direita);
        if (contador < 3) {
            System.out.println(atual.pontuacao + " pts " + atual.nomeJogador);
            contador++;
        }
        exibirTop3Recursivo(atual.esquerda);
    }
}