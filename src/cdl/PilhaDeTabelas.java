package cdl;

import java.util.LinkedList;
import java.util.List;

// A pilha de tabelas é a pilha de escopos, com cada tabela representando um escopo
public class PilhaDeTabelas {
    private LinkedList<TabelaDeSimbolos> pilha;

    public PilhaDeTabelas() {
        pilha = new LinkedList<TabelaDeSimbolos>();
    }

    public void empilhar(TabelaDeSimbolos ts) {
        pilha.push(ts);
    }

    public TabelaDeSimbolos topo() {
        return pilha.peek();
    }

    public boolean existeSimbolo(String nome) {
        for(TabelaDeSimbolos ts : pilha) {
            if(ts.existeSimbolo(nome)) {
                return true;
            }
        }
        return false;
    }

    public void desempilhar() {
        pilha.pop();
    }
    
}
