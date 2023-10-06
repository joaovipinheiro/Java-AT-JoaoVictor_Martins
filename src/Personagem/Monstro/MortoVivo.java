package Personagem.Monstro;

import Personagem.CalculoDano;
import Personagem.Personagem;

import java.util.Random;


public class MortoVivo extends Personagem implements CalculoDano {
    public MortoVivo() {
        super("Morto-Vivo", 25, 4, 0, 1);
    }

    Random random = new Random();
    @Override
    public int calculaDano() {
        return (random.nextInt(4) + 1) + (random.nextInt(4) + 1) + this.getForca();
    }
}
