package jogo.personagens.tipos;

import jogo.personagens.Besta;
import jogo.personagens.Personagem;

public class Troll extends Besta {
    public Troll(String nome, int pontosVida, int armadura) {
        super(nome, pontosVida, armadura);
    }

    public void ataque(Personagem pAtacada) {
        int valorMostrar = 0;

        int ataque = this.calcularAtaque();

        if(ataque > (pAtacada.getArmadura()*0.9)){
            pAtacada.setPontosVida((int) (pAtacada.getPontosVida()-(ataque-(pAtacada.getArmadura()*0.9))));
            valorMostrar = (int) (ataque-(pAtacada.getArmadura()*0.9));
        }

        System.out.println("      " + this.getNome() + " saca " + ataque + " e tira "
                + valorMostrar + " de vida a "
                + pAtacada.getNome());

    }
}
