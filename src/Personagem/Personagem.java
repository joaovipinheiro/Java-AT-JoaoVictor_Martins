package Personagem;

import java.util.Random;

public abstract class Personagem {
    private String nome;
    private int pontosDeVida;
    private int forca;
    private int defesa;
    private int agilidade;

    public Personagem(String nome, int pontosDeVida, int forca, int defesa, int agilidade) {
        this.nome = nome;
        this.pontosDeVida = pontosDeVida;
        this.forca = forca;
        this.defesa = defesa;
        this.agilidade = agilidade;
    }

    public boolean estaVivo() {
        return pontosDeVida > 0;
    }

    public int calculaIniciativa() {
        Random random = new Random();
        return random.nextInt(10) + 1 + agilidade;
    }

    public int calculaFatorAtaque() {
        Random random = new Random();
        return random.nextInt(10) + 1 + agilidade + forca;
    }

    public int calculaFatorDefesa() {
        Random random = new Random();
        return random.nextInt(10) + 1 + agilidade + defesa;
    }

    public String getNome() {
        return nome;
    }

    public int getPontosDeVida() {
        return pontosDeVida;
    }

    public void setPontosDeVida(int pontosDeVida) {
        this.pontosDeVida = pontosDeVida;
    }

    public int getForca() {
        return forca;
    }

    public int getDefesa() {
        return defesa;
    }

    public int getAgilidade() {
        return agilidade;
    }

    public abstract int calculaDano();
}
