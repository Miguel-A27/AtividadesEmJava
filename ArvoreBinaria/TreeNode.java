// NoArvore.java
public class TreeNode {
    int pontuacao;
    String nomeJogador;
    TreeNode esquerda;
    TreeNode direita;

    public TreeNode(int pontuacao, String nomeJogador) {
        this.pontuacao = pontuacao;
        this.nomeJogador = nomeJogador;
        this.esquerda = null;
        this.direita = null;
    }
}