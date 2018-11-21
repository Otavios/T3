package cdl;

import java.util.ArrayList;
import java.util.List;

public class TabelaDeSimbolos {
    private String escopo;
    private List<Simbolo> simbolos;
    
    public TabelaDeSimbolos(String escopo) {
        this.simbolos = new ArrayList<Simbolo>();
        this.escopo = escopo;
    }
    
    public void adicionarSimbolo(Simbolo simbolo) {
        simbolos.add(simbolo);
    }
    
    public boolean existeSimbolo(String nome) {
        for(Simbolo simbolo : simbolos) {
            if(simbolo.getNome().equals(nome)) {
                return true;
            }
        }
        return false;
    }
    
    public String getEscopo(){
        return escopo;
    }
    
    public Simbolo getSimbolo(String nome){
        for(Simbolo simbolo : simbolos) {
            if(simbolo.getNome().equals(nome)) {
                return simbolo;
            }
        }
        return null;
    }
    
    public List<Simbolo> getListaSimbolos(){
        return simbolos;
    }
}
