package jogo.personagens.tipos;

import jogo.personagens.Heroi;
import jogo.personagens.Personagem;

public class Humano extends Heroi {
    public Humano(String nome, int pontosVida, int armadura) {
        super(nome, pontosVida, armadura);
    }

    public void ataque(Personagem pAtacada) {
        int valorMostrar = 0;

        int ataque = this.calcularAtaque();

        if(ataque > pAtacada.getArmadura()){
            pAtacada.setPontosVida(pAtacada.getPontosVida()-(ataque-pAtacada.getArmadura()));
            valorMostrar = ataque-pAtacada.getArmadura();
        }

        System.out.println("      " + this.getNome() + " saca " + ataque + " e tira "
                + valorMostrar + " de vida a "
                + pAtacada.getNome());

    }
}
