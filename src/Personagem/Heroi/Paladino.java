package Personagem.Heroi;

import Personagem.CalculoDano;
import Personagem.Personagem;

import java.util.Random;

public class Paladino extends Personagem implements CalculoDano{
    public Paladino() {
        super("Paladino", 15, 2, 5, 1);
    }

    Random random = new Random();
    @Override
    public int calculaDano() {
        return (random.nextInt(4) + 1) + (random.nextInt(4) + 1) + this.getForca();
    }
}

