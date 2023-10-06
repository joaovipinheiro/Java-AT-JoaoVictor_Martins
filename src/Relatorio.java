import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class DadosPartida {
    private String data;
    private String heroi;
    private String resultado;
    private String monstro;
    private int quantidadeDeRodadas;

    public DadosPartida(String data, String heroi, String resultado, String monstro, int quantidadeDeRodadas) {
        this.data = data;
        this.heroi = heroi;
        this.resultado = resultado;
        this.monstro = monstro;
        this.quantidadeDeRodadas = quantidadeDeRodadas;
    }

    public String getHeroi() {
        return heroi;
    }

    public String getMonstro() {
        return monstro;
    }

    public int getPontos() {
        return 100 - quantidadeDeRodadas;
    }
}

public class Relatorio {
    public static void gerarRelatorio(String nickname) {
        List<DadosPartida> dadosPartidas = lerDadosDoArquivo(nickname + ".csv");

        if (dadosPartidas.isEmpty()) {
            System.out.println("Nenhum dado encontrado para o jogador " + nickname);
            return;
        }

        Map<String, Integer> heroiFrequencia = new HashMap<>();
        Map<String, Integer> monstroFrequencia = new HashMap<>();
        int totalPontos = 0;

        for (DadosPartida partida : dadosPartidas) {
            totalPontos += partida.getPontos();
            heroiFrequencia.put(partida.getHeroi(), heroiFrequencia.getOrDefault(partida.getHeroi(), 0) + 1);
            monstroFrequencia.put(partida.getMonstro(), monstroFrequencia.getOrDefault(partida.getMonstro(), 0) + 1);
        }

        String heroiMaisJogado = encontrarMaximoFrequencia(heroiFrequencia);
        String monstroMaisEnfrentado = encontrarMaximoFrequencia(monstroFrequencia);

        System.out.println("Relatório para o jogador " + nickname + ":");
        System.out.println("Herói mais jogado: " + heroiMaisJogado);
        System.out.println("Monstro mais enfrentado: " + monstroMaisEnfrentado);
        System.out.println("Quantidade total de pontos: " + totalPontos);
    }

    private static List<DadosPartida> lerDadosDoArquivo(String nomeArquivo) {
        List<DadosPartida> dadosPartidas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("temp/" + nomeArquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(";");
                String data = partes[0];
                String heroi = partes[1];
                String resultado = partes[2];
                String monstro = partes[3];
                int quantidadeDeRodadas = Integer.parseInt(partes[4]);
                DadosPartida partida = new DadosPartida(data, heroi, resultado, monstro, quantidadeDeRodadas);
                dadosPartidas.add(partida);
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo de dados.");
            e.printStackTrace();
        }
        return dadosPartidas;
    }

    private static String encontrarMaximoFrequencia(Map<String, Integer> frequenciaMap) {
        String maximoChave = null;
        int maximoFrequencia = -1;
        for (Map.Entry<String, Integer> entry : frequenciaMap.entrySet()) {
            if (entry.getValue() > maximoFrequencia) {
                maximoFrequencia = entry.getValue();
                maximoChave = entry.getKey();
            }
        }
        return maximoChave;
    }
}
