package Personagem.Heroi;

import Personagem.CalculoDano;
import Personagem.Personagem;

import java.util.Random;

public class Barbaro extends Personagem implements CalculoDano {
    public Barbaro() {
        super("Bárbaro", 13, 6, 1, 3);
    }

    Random random = new Random();
    @Override
    public int calculaDano() {
        return (random.nextInt(6) + 1) + (random.nextInt(6) + 1) + this.getForca();
    }
}


