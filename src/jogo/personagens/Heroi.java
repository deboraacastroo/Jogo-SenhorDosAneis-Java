package jogo.personagens;

public abstract class Heroi extends Personagem{
    protected Heroi(String nome, int pontosVida, int armadura) {
        super(nome, pontosVida, armadura);
    }

    public abstract void ataque(Personagem pAtacada);

    @Override
    public int calcularAtaque() {
        double valorRandom = Math.random();
        int dado1 = (int) (valorRandom * 101);

        valorRandom = Math.random();
        int dado2 = (int) (valorRandom * 101);

        return dado1>dado2 ? dado1 : dado2;
    }

}
