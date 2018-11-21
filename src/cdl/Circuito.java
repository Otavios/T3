package cdl;

import java.util.ArrayList;

public class Circuito {
    
    public String nome;
    public ArrayList<CDLParser.Exp_assignmentContext> atribuicoes;
    public ArrayList<String> entradas, saidas;
    
    public Circuito(String nome){
        this.nome = nome;
        atribuicoes = new ArrayList<CDLParser.Exp_assignmentContext>();
        entradas = new ArrayList<String>();
        saidas = new ArrayList<String>();
    }
    
    public void adicionarEntrada(String nome){
        entradas.add(nome);
    }
    
    public void adicionarSaida(String nome){
        saidas.add(nome);
    } 
    
    public void adicionarAtribuicao(CDLParser.Exp_assignmentContext atribuicao){
        atribuicoes.add(atribuicao);
    }
    
}
