package jogo.batalha;

import jogo.personagens.Besta;
import jogo.personagens.Heroi;
import jogo.personagens.Personagem;
import jogo.personagens.tipos.*;

import java.util.ArrayList;

public class Batalha {
    private ArrayList<Heroi> listaHerois = new ArrayList<>();
    private ArrayList<Besta> listaBesta = new ArrayList<>();

    public Batalha() {
        /*
        listaHerois.add(new Elfo("Legolas", 150, 30));
        listaHerois.add(new Humano("Aragorn", 150, 50));
        listaHerois.add(new Humano("Boromir", 100, 20));
        listaHerois.add(new Humano("Gandalf", 300, 30));
        listaHerois.add(new Humano("Frodo", 20, 10));
        listaHerois.add(new Hobbit("Abito", 200, 35));

        listaBesta.add(new Orque("Lurtz", 200, 60));
        listaBesta.add(new Orque("Shagrat", 220, 50));
        listaBesta.add(new Troll("Uglúk", 120, 30));
        listaBesta.add(new Troll("Mauhúr", 100, 30));

         */

    }

    public void turnos() {
        int contador = 1;

        while (!listaHerois.isEmpty() && !listaBesta.isEmpty()) {
            System.out.println("Turno " + contador + ":");

            for (int i = 0; i < listaHerois.size(); i++) {

                if (!listaHerois.isEmpty() && !listaBesta.isEmpty()) {

                    if (i < listaBesta.size()) {

                        System.out.println("  Luta entre " + listaHerois.get(i).descricaoPersonagem()
                                + " e " + listaBesta.get(i).descricaoPersonagem());

                        listaHerois.get(i).ataque(listaBesta.get(i));
                        listaBesta.get(i).ataque(listaHerois.get(i));

                        if(listaHerois.get(i).getPontosVida()<=0){
                            System.out.println("   Morre o " + listaHerois.get(i).getClass().getSimpleName() + " " + listaHerois.get(i).getNome());
                            listaHerois.remove(i);
                        }
                        if(listaBesta.get(i).getPontosVida()<=0){
                            System.out.println("   Morre o " + listaBesta.get(i).getClass().getSimpleName() + " " + listaBesta.get(i).getNome());
                            listaBesta.remove(i);
                        }
                    }
                }
            }
            contador++;
        }
        if(listaBesta.isEmpty() && listaHerois.isEmpty()){
            System.out.println("Insira elementos!");
        }else if (listaHerois.isEmpty() && !listaBesta.isEmpty()) {
            System.out.println("Vitória das Bestas");
        } else {
            System.out.println("Vitória dos Heróis");
        }
    }


    public ArrayList<Heroi> getListaHerois() {
        return listaHerois;
    }

    public ArrayList<Besta> getListaBesta() {
        return listaBesta;
    }

    public void addListaHerois(Heroi heroi){
        listaHerois.add(heroi);
    }

    public void addListaBestas(Besta besta){
        listaBesta.add(besta);
    }

    public void resetListaHerois() {
        this.listaHerois = new ArrayList<>();
    }

    public void resetListaBestas() {
        this.listaBesta = new ArrayList<>();
    }
}
