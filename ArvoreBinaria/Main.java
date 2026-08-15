// Main.java
public class Main {
    public static void main(String[] args) {
        Ranking ranking = new Ranking();

        // 1. Inserindo 6 jogadores no torneio (Testando Checklist)[cite: 4]
        // Vamos usar a mesma árvore de exemplo do slide 17 para testar a estrutura:
        // Raiz: 1500, Esq: 900, 400, 1200 | Dir: 2100, 1800, 2600[cite: 4]
        
        ranking.inserirPontuacao(1500, "Jogador Alfa");
        ranking.inserirPontuacao(900, "Jogador Beta");
        ranking.inserirPontuacao(2100, "Jogador Gama");
        ranking.inserirPontuacao(400, "Jogador Delta");
        ranking.inserirPontuacao(1200, "Jogador Eco");
        ranking.inserirPontuacao(1800, "Jogador Fox");
        ranking.inserirPontuacao(2600, "Jogador Boto (Pro Player)"); // 7º jogador
        ranking.inserirPontuacao(1934,"Jogador Zeta");
        ranking.inserirPontuacao(2150,"Jogador Bravo");
        ranking.inserirPontuacao(2300,"Jogador Epsilon");

        // 2. Imprimindo a Árvore para garantir integridade (Visualização)[cite: 4]
        // Esperado: Ordem decrescente (2600, 2100, 1800, 1500, 1200, 900, 400)
        ranking.exibirRanking();

        // 3. Testando Contagem
        System.out.println("\nTotal de jogadores cadastrados: " + ranking.contarJogadores());

        // 4. Testando Busca Rápida O(log n) por Pontuação[cite: 4]
        System.out.println("\n--- Buscas por Pontuação ---");
        System.out.println("Existe alguém com 1800 pontos? " + ranking.buscarPontuacao(1800)); // true
        System.out.println("Existe alguém com 1000 pontos? " + ranking.buscarPontuacao(1000)); // false

        // 5. Testando Busca por Nome[cite: 4]
        System.out.println("\n--- Buscas por Nome ---");
        System.out.println("O 'Jogador Gama' participou? " + ranking.buscarJogador("Jogador Gama")); // true
        System.out.println("O 'Jogador Zeus' participou? " + ranking.buscarJogador("Jogador Zeus")); // false

        //6. Imprimindo Placar Top3
        System.out.println("\n--- TOP 3 ---");
        ranking.exibirTop3();
    }
}