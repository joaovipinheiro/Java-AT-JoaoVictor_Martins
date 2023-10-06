package Personagem.Heroi;

import Personagem.CalculoDano;
import Personagem.Personagem;

import java.util.Random;

public class Guerreiro extends Personagem implements CalculoDano{

    public Guerreiro() {
        super("Guerreiro", 12, 4, 3, 3);
    }

    Random random = new Random();
    @Override
    public int calculaDano() {
        return (random.nextInt(4) + 1) + (random.nextInt(4) + 1) + this.getForca();
    }
}

