import Personagem.*;
import Personagem.Heroi.*;
import Personagem.Monstro.*;

import java.util.Scanner;
import java.util.Random;
import java.awt.Color;


public class Main {
    public static void main(String[] args) {
        System.out.println("Iniciando Medieval Battle...");
        System.out.print("Digite seu nickname: ");
        Scanner scanner = new Scanner(System.in);
        String nickname = scanner.nextLine();

        System.out.println("Escolha sua classe de herói: ");
        System.out.println("1. Guerreiro");
        System.out.println("2. Bárbaro");
        System.out.println("3. Paladino");
        System.out.print("Escreva o número da classe: ");
        int heroiClasse = scanner.nextInt();

        Personagem heroi = null;
        switch (heroiClasse) {
            case 1:
                heroi = new Guerreiro();
                break;
            case 2:
                heroi = new Barbaro();
                break;
            case 3:
                heroi = new Paladino();
                break;
            default:
                System.out.println("Classe inválida. Finalizando Medieval Battle...");
                return;
        }

        Personagem[] monstros = {
                new MortoVivo(),
                new Orc(),
                new Kobold()
        };

        Personagem monstro = monstros[new Random().nextInt(monstros.length)];

        // Simulando a batalha
        Batalha.simularBatalha(heroi, monstro, nickname);
        Relatorio.gerarRelatorio(nickname);

    }
}