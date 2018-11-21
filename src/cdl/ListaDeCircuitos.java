package cdl;

import java.util.ArrayList;

public class ListaDeCircuitos {
    
    private static ArrayList<Circuito> listaDeCircuitos = new ArrayList<Circuito>();
    
    public static void adicionarCircuito(Circuito circuito){
        listaDeCircuitos.add(circuito);
    }
    
    public static Circuito getCircuito(String nome){
        for(Circuito circuito : listaDeCircuitos){
            if(circuito.nome.equals(nome)) return circuito;
        }
        return null;
    }
}
