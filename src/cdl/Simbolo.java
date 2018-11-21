package cdl;

public class Simbolo {
    public String nome;
    public int nivelX, nivelY, qtdEntradas;
    boolean inicial, saida;
    String tipo;
    
    public Simbolo(String nome, String tipo){
        this.nome = nome;
        this.tipo = tipo;
    }
    
    public Simbolo(String nome, int nivelX, int nivelY, boolean inicial, boolean saida, int qtdEntradas){
        this.nome = nome;
        this.nivelX = nivelX;
        this.nivelY = nivelY;
        this.inicial = inicial;
        this.saida = saida;
        this.qtdEntradas = qtdEntradas;
    }
    
    public String getNome(){
        return nome;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
}
