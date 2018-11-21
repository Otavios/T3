package cdl;

import java.util.ArrayList;
import java.util.List;
import java.lang.*;

public class CDLVisitorGerador {
    
    private TabelaDeSimbolos tabelaDeSimbolos = new TabelaDeSimbolos("global");
    
    int nivelY = 1; // nível vertical inicial
    int qtdIniciais = 0; // quantidade de fios iniciais
    int dx = 120; // distancia horizontal entre duas portas
    int dy = 55; // distancia vertical entre duas portas
    int auxCount = 0; // contador de portas auxiliares (resultados de subexpressões)
    int[][] qtdWires = new int[1000][1000]; // quantidade de fios verticais em cada nível (x, y)
    List<Simbolo> listaSimbolos = new ArrayList(); // lista de portas geradas
    double maxXSaida = 0; // coordenada x máxima que foi alcançada pelo circuito gerado
    
    // Cria uma porta lógica com as suas múltiplas entradas e sua saída
    public Simbolo criaDesenho(List<Simbolo> lista, String op){
        nivelY++;
        int nivelX = lista.get(0).nivelX;
        for(int i = 1; i < lista.size(); i++){
            nivelX = Math.max(nivelX, lista.get(i).nivelX);
        }
        nivelX++;
        int x = nivelX*dx;
        int y = nivelY*dy;
        Saida.println("createGate(" + x + ", " + y + ", '" + op + "');");
        int wireX = x - 20;
        int wireY = y - 12;
        for(int i = 0; i < lista.size(); i++){
            Simbolo simbolo = lista.get(i);
            simbolo.saida = false;
            int simboloX = simbolo.nivelX*dx;
            int simboloY = simbolo.nivelY*dy;
            int contX = qtdWires[simbolo.nivelY][simbolo.nivelX];
            for(int I = simbolo.nivelY+1; I <= nivelY; I++){
                contX = Math.max(contX, qtdWires[I][simbolo.nivelX]);
            }
            int distX = contX*8;
            if(!simbolo.inicial){
                for(int I = simbolo.nivelY; I <= nivelY; I++){
                    qtdWires[I][simbolo.nivelX] = contX+1;
                }
                // extensão horizontal
                Saida.println("createWire(" + (simboloX+dx/2.3-10) + ", " + simboloY + ", " + (simboloX+dx/2.3-10 + distX) + ", " + simboloY + ");");
                // fio vertical
                Saida.println("createWire(" + (simboloX+dx/2.3-10 + distX) + ", " + simboloY + ", " + (simboloX+dx/2.3-10 + distX) + ", " + wireY + ", true, true);");
            }
            else{
                Saida.println("createText('" + simbolo.nome + "', " + 155 + ", " + (wireY+4) + ", 'RIGHT');");
            }
            // fio horizontal
            Saida.println("createWire(" + (simboloX+dx/2.3-10 + distX) + ", " + wireY + ", " + wireX + ", " + wireY + ");");
            wireY += 24/(lista.size()-1);
        }
        // fio saida
        Saida.println("createWire(" + (x+20) + ", " + y + ", " + (x+dx/2.3-10) + ", " + y + ");");
        maxXSaida = Math.max(maxXSaida, (x+dx/2.3-10));
        auxCount++;
        Simbolo novoSimbolo = new Simbolo("aux"+auxCount, nivelX, nivelY, false, true, lista.size());
        listaSimbolos.add(novoSimbolo);
        return novoSimbolo;
    }
    
    // Cria uma porta lógica de entrada única (porta NOT)
    public Simbolo criaDesenho(Simbolo simbolo, String op){
        simbolo.saida = false;
        int nivelX = simbolo.nivelX + 1;
        nivelY++;
        int x = nivelX*dx;
        int y = nivelY*dy;
        Saida.println("createGate(" + x + ", " + y + ", '" + op + "');");
        int wireX = x - 20;
        int wireY = y;
        int simboloX = simbolo.nivelX*dx;
        int simboloY = simbolo.nivelY*dy;
        qtdWires[simboloX][simboloY]++;
        if(!simbolo.inicial){
            // extensão horizontal
            Saida.println("createWire(" + (simboloX+dx/2.3-10) + ", " + simboloY + ", " + (simboloX+dx/2.3-10) + ", " + simboloY + ");");
            // fio vertical
            Saida.println("createWire(" + (simboloX+dx/2.3-10) + ", " + simboloY + ", " + (simboloX+dx/2.3-10) + ", " + wireY + ", true, true);");
        }
        else{
            Saida.println("createText('" + simbolo.nome + "', " + 155 + ", " + (wireY+4) + ", 'RIGHT');");
        }
        // fio horizontal
        Saida.println("createWire(" + (simboloX+dx/2.3-10) + ", " + wireY + ", " + wireX + ", " + wireY + ");");
        Saida.println("createWire(" + (x+30) + ", " + y + ", " + (x+dx/2.3-10) + ", " + y + ");");
        maxXSaida = Math.max(maxXSaida, (x+dx/2.3-10));
        auxCount++;
        Simbolo novoSimbolo = new Simbolo("aux"+auxCount, nivelX, nivelY, false, true, 1);
        listaSimbolos.add(novoSimbolo);
        return novoSimbolo;
    }
    
    public void visitProgram(CDLParser.ProgramContext ctx){
        // Inicializa a matriz qtdWires
        for(int i = 0; i < 1000; i++){
            for(int j = 0; j < 1000; j++){
                qtdWires[i][j] = 0;
            }
        }
        for(CDLParser.CmdContext cmd : ctx.cmd()){
            visitCmd(cmd);
        }
        // Extende as saídas para a coordenada em x máxima alcançada pelo circuito total gerado e coloca os seus nomes
        for(int i = 0; i < listaSimbolos.size(); i++){
            Simbolo simbolo = listaSimbolos.get(i);
            if(simbolo.saida){
                Saida.println("createWire(" + (simbolo.nivelX*dx+dx/2.3-10) + ", " + simbolo.nivelY*dy + ", " + maxXSaida + ", " + simbolo.nivelY*dy + ");");
                Saida.println("createText('" + simbolo.nome + "', " + (maxXSaida+9) + ", " + (simbolo.nivelY*dy+4) + ", 'LEFT');");
            }
        }
    }
    
    public void visitCmd(CDLParser.CmdContext ctx){
        if(ctx.circuit_assignment() != null){
            visitCircuit_assignment(ctx.circuit_assignment());
        }
        else if(ctx.exp_assignment() != null){
            visitExp_assignment(ctx.exp_assignment(), null, null, null);
        }
    }
    
    public void visitExp_assignment(CDLParser.Exp_assignmentContext ctx, Circuito circuito, List<String> entradas, String id){
        Simbolo simbolo = visitExp(ctx.exp(), circuito, entradas);
        simbolo.nome = ctx.ID().getText();
        if(circuito != null) simbolo.nome = id + "." + simbolo.nome;
        tabelaDeSimbolos.adicionarSimbolo(simbolo);
    }
    
    public void visitCircuit_assignment(CDLParser.Circuit_assignmentContext ctx){
        String nomeCircuito = ctx.ID(0).getText();
        String tipoCircuito = ctx.ID(1).getText();
        Circuito circuito = ListaDeCircuitos.getCircuito(tipoCircuito);
        ArrayList<String> entradas = new ArrayList<String>();
        for(int i = 0; i < ctx.var_list().ID().size(); i++){
            entradas.add(ctx.var_list().ID(i).getText());
        }
        for(int i = 0; i < circuito.atribuicoes.size(); i++){
            visitExp_assignment(circuito.atribuicoes.get(i), circuito, entradas, nomeCircuito);
        }
    }
    
    public Simbolo visitExp(CDLParser.ExpContext ctx, Circuito circuito, List<String> entradas){
        if(ctx.term_or().size() == 1){
            return visitTerm_or(ctx.term_or(0), circuito, entradas);
        }
        List<Simbolo> simbolos = new ArrayList();
        for(int i = 0; i < ctx.term_or().size(); i++){
            simbolos.add(visitTerm_or(ctx.term_or(i), circuito, entradas));
        }
        return criaDesenho(simbolos, "or");
    }
    
    public Simbolo visitTerm_or(CDLParser.Term_orContext ctx, Circuito circuito, List<String> entradas){
        if(ctx.term_xor().size() == 1){
            return visitTerm_xor(ctx.term_xor(0), circuito, entradas);
        }
        List<Simbolo> simbolos = new ArrayList();
        for(int i = 0; i < ctx.term_xor().size(); i++){
            simbolos.add(visitTerm_xor(ctx.term_xor(i), circuito, entradas));
        }
        return criaDesenho(simbolos, "xor");
    }
    
    public Simbolo visitTerm_xor(CDLParser.Term_xorContext ctx, Circuito circuito, List<String> entradas){
        if(ctx.term_and().size() == 1){
            return visitTerm_and(ctx.term_and(0), circuito, entradas);
        }
        List<Simbolo> simbolos = new ArrayList();
        for(int i = 0; i < ctx.term_and().size(); i++){
            simbolos.add(visitTerm_and(ctx.term_and(i), circuito, entradas));
        }
        return criaDesenho(simbolos, "and");
    }
    
    public Simbolo visitTerm_and(CDLParser.Term_andContext ctx, Circuito circuito, List<String> entradas){
        Simbolo simbolo = visitTerm_not(ctx.term_not(), circuito, entradas);
        if(ctx.not.size() > 0){
            Simbolo aux = criaDesenho(simbolo, "not");
            for(int i = 1; i < ctx.not.size(); i++){
                aux = criaDesenho(aux, "not");
            }
            return aux;
        }
        return simbolo;
    }
    
    public Simbolo visitTerm_not(CDLParser.Term_notContext ctx, Circuito circuito, List<String> entradas){
        if(ctx.ID().size() > 0){
            String id = ctx.getText();
            if(circuito != null && circuito.entradas.indexOf(id) != -1){
                int i = circuito.entradas.indexOf(id);
                id = entradas.get(i);
            }
            if(!tabelaDeSimbolos.existeSimbolo(id)){
                Simbolo simbolo = new Simbolo(id, 1, nivelY, true, true, 0);
                tabelaDeSimbolos.adicionarSimbolo(simbolo);
                listaSimbolos.add(simbolo);
                return simbolo;
            }
            return tabelaDeSimbolos.getSimbolo(id);
        }
        else if(ctx.exp() != null){
            return visitExp(ctx.exp(), circuito, entradas);
        }
        return null;
    }
    
}
