package jogo.personagens;

import jogo.personagens.tipos.Elfo;
import jogo.personagens.tipos.Troll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class AtaqueTest {

    @Test
    void randomNumeroAte100(){
        Elfo elfo = new Elfo("dfff", 30, 23);

        for (int i=0; i<=500; i++){
            int num = elfo.calcularAtaque();
            //System.out.println(num);
            assertTrue(0<=num && num <=100);
        }

    }

    @Test
    void randomNumeroAte90(){
        Troll troll = new Troll("dfff", 30, 23);

        for (int i=0; i<=500; i++){
            int num = troll.calcularAtaque();
            //System.out.println(num);
            assertTrue(0<=num && num <=90);
        }

    }

}