package Personagem.Monstro;

import Personagem.CalculoDano;
import Personagem.Personagem;

import java.util.Random;

public class Orc extends Personagem implements CalculoDano {
    public Orc() {
        super("Orc", 20, 6, 2, 2);
    }

    Random random = new Random();
    @Override
    public int calculaDano() {
        return (random.nextInt(8) + 1) + this.getForca();
    }
}
