package Personagem.Monstro;

import Personagem.CalculoDano;
import Personagem.Personagem;

import java.util.Random;

public class Kobold extends Personagem implements CalculoDano {
    public Kobold() {
        super("Kobold", 20, 4, 2, 4);
    }

    Random random = new Random();
    @Override
    public int calculaDano() {
        return (random.nextInt(2) + 1) + (random.nextInt(2) + 1) + (random.nextInt(2) + 1) + this.getForca();
    }
}
