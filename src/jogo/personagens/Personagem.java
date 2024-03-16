package jogo.personagens;

public abstract class Personagem {
    private String nome;
    private int pontosVida;
    private int armadura;

    protected Personagem(String nome, int pontosVida, int armadura) {
        this.nome = nome;
        this.pontosVida = pontosVida;
        this.armadura = armadura;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPontosVida() {
        return pontosVida;
    }

    public void setPontosVida(int pontosVida) {
        this.pontosVida = pontosVida;
    }

    public int getArmadura() {
        return armadura;
    }

    public void setArmadura(int armadura) {
        this.armadura = armadura;
    }

    public abstract int calcularAtaque();

    public String descricaoPersonagem(){
        return this.getNome() + " (Vida=" + this.getPontosVida() + " Armadura=" + this.getArmadura() + ")";
    }

    public abstract String descricao();
}
