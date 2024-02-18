package jogo.personagens;

public abstract class Besta extends Personagem{
    protected Besta(String nome, int pontosVida, int armadura) {
        super(nome, pontosVida, armadura);
    }

    public abstract void ataque(Personagem pAtacada);

    @Override
    public int calcularAtaque() {
        double valorRandom = Math.random();
        return (int) (valorRandom * 91);
    }
}
