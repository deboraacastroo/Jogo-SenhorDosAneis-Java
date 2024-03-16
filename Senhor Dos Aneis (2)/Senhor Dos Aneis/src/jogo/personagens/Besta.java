package jogo.personagens;

import java.util.Arrays;
import java.util.List;

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

    public static List<String> listaBestas(){
        return Arrays.asList("Orque", "Troll");
    }

    @Override
    public String descricao(){
        return this.getNome() + " - " + this.getClass().getSimpleName() + " (" + this.getPontosVida() + ", " + this.getArmadura() + ")";
    }
}
