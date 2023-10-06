package Personagem;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Batalha {
    public static void simularBatalha(Personagem heroi, Personagem monstro, String nickname) {
        Random random = new Random();
        int rodadas = 0;

        while (heroi.estaVivo() && monstro.estaVivo()) {
            rodadas++;
            System.out.println("Rodada: " + rodadas);

            int iniciativaHeroi = heroi.calculaIniciativa();
            int iniciativaMonstro = monstro.calculaIniciativa();

            System.out.println("Iniciativa do Herói: " + iniciativaHeroi);
            System.out.println("Iniciativa do Monstro: " + iniciativaMonstro);

            if (iniciativaHeroi > iniciativaMonstro) {
                int danoHeroi = calcularDano(heroi, monstro);
                monstro.setPontosDeVida(monstro.getPontosDeVida() - danoHeroi);
                System.out.println("Herói causou " + danoHeroi + " de dano no Monstro.");
            } else if (iniciativaMonstro > iniciativaHeroi) {
                int danoMonstro = calcularDano(monstro, heroi);
                heroi.setPontosDeVida(heroi.getPontosDeVida() - danoMonstro);
                System.out.println("Monstro causou " + danoMonstro + " de dano no Herói.");
            } else {
                System.out.println("Empate! Ninguém causou dano nesta rodada.");
            }
        }

        System.out.println("Batalha encerrada em " + rodadas + " rodadas.");

        // Gravação do LOG
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String dataPartida = sdf.format(new Date());
        String resultado = heroi.estaVivo() ? "GANHOU" : "PERDEU";
        String monstroNome = monstro.getClass().getSimpleName();
        int quantidadeDeRodadas = rodadas;

        String log = dataPartida + ";" + heroi.getNome() + ";" + resultado + ";" + monstroNome + ";" + quantidadeDeRodadas;

        try (FileWriter fw = new FileWriter("temp/" + nickname + ".csv", true);
             PrintWriter pw = new PrintWriter(fw)) {
            pw.println(log);
        } catch (IOException e) {
            System.out.println("Erro ao gravar o arquivo de log.");
            e.printStackTrace();
        }
    }

    private static int calcularDano(Personagem atacante, Personagem defensor) {
        int fatorAtaque = atacante.calculaFatorAtaque();
        int fatorDefesa = defensor.calculaFatorDefesa();

        if (fatorAtaque > fatorDefesa) {
            int dano = atacante.calculaDano();
            return dano;
        } else {
            return 0;
        }
    }

}
