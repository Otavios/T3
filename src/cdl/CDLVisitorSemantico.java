package cdl;

import java.util.ArrayList;
import java.util.List;
import org.antlr.v4.runtime.Token;

public class CDLVisitorSemantico {
    
    /* 
        Erros semânticos:
        1: atribuição a uma variável/circuito que já tem valor
        2: atribuição a uma variável de entrada
        3: template de circuito sem atribuição de valor a uma variável de saída
        4: instanciação de circuito cujo template não existe
        5: número de entradas incompatível na instanciação de um circuito
        6: variavel usada no circuito não foi declarada na entrada
    */
    
    private PilhaDeTabelas pilhaDeTabelas = new PilhaDeTabelas();
    
    public void visitProgram(CDLParser.ProgramContext ctx){
        pilhaDeTabelas.empilhar(new TabelaDeSimbolos("global"));
        for(CDLParser.CmdContext cmd : ctx.cmd()){
            visitCmd(cmd);
        }
    }
    
    public void visitCmd(CDLParser.CmdContext ctx){
        if(ctx.circuit_definition() != null){
            visitCircuit_definition(ctx.circuit_definition());
        }
        else if(ctx.circuit_assignment() != null){
            visitCircuit_assignment(ctx.circuit_assignment());
        }
        else{
            visitExp_assignment(ctx.exp_assignment());
        }
    }

    public void visitCircuit_definition(CDLParser.Circuit_definitionContext ctx){
        String id = ctx.ID().getText();
        if(!pilhaDeTabelas.topo().existeSimbolo(id)){
            pilhaDeTabelas.topo().adicionarSimbolo(new Simbolo(id, "circuit"));
            Circuito circuito = new Circuito(id);
            for(int i = 0; i < ctx.entradas.ID().size(); i++){
                circuito.adicionarEntrada(ctx.entradas.ID(i).getText());
            }
            for(int i = 0; i < ctx.saidas.ID().size(); i++){
                circuito.adicionarSaida(ctx.saidas.ID(i).getText());
            }
            ListaDeCircuitos.adicionarCircuito(circuito);
            pilhaDeTabelas.empilhar(new TabelaDeSimbolos(circuito.nome));
            ArrayList<String> variaveisAtribuidas = new ArrayList<String>();
            for(int i = 0; i < ctx.exp_assignment().size(); i++){
                visitExp_assignment(ctx.exp_assignment(i));
                variaveisAtribuidas.add(ctx.exp_assignment(i).ID().getText());
            }
            // verifica se todas as saídas do circuito recebem algum valor
            for(int i = 0; i < circuito.saidas.size(); i++){
                if(variaveisAtribuidas.indexOf(circuito.saidas.get(i)) == -1){
                    Saida.println("Erro semântico na linha " + ctx.start.getLine() + ": saída " + circuito.saidas.get(i) + " não possui valor atribuído.");
                }
            }
            pilhaDeTabelas.desempilhar();
            
        }
        else{ // erro caso a variável já exista (e consequentemente já possui valor)
            Saida.println("Erro semântico na linha " + ctx.start.getLine() + ": variável " + id + " já possui um valor.");
        }
    }
    
    public void visitExp_assignment(CDLParser.Exp_assignmentContext ctx){
        String id = ctx.ID().getText();
        if(!pilhaDeTabelas.topo().existeSimbolo(id)){
            pilhaDeTabelas.topo().adicionarSimbolo(new Simbolo(id, "var"));
            String escopo = pilhaDeTabelas.topo().getEscopo();
            Circuito circuito = ListaDeCircuitos.getCircuito(escopo);
            if(circuito != null){
                if(circuito.entradas.indexOf(id) != -1){ // erro caso a variável atribuída pertença a lista de variáveis de entrada
                    Saida.println("Erro semântico na linha " + ctx.start.getLine() + ": variável " + id + " é de entrada e não pode receber uma atribuição.");
                }
                else{
                    circuito.adicionarAtribuicao(ctx);
                }
            }
        }
        else{ // erro caso a variável já exista (e consequentemente já possui valor)
            Saida.println("Erro semântico na linha " + ctx.start.getLine() + ": variável " + id + " já possui um valor.");
        }
        visitExp(ctx.exp());
    }
    
    public void visitCircuit_assignment(CDLParser.Circuit_assignmentContext ctx){
        String tipoCircuito = ctx.ID(1).getText();
        Circuito circuito = ListaDeCircuitos.getCircuito(tipoCircuito);
        if(circuito == null){
            Saida.println("Erro semântico na linha " + ctx.start.getLine() + ": circuito do tipo " + tipoCircuito + " não foi criado previamente.");
        }
        else{
            if(ctx.var_list().ID().size() != circuito.entradas.size()){
                Saida.println("Erro semântico na linha " + ctx.start.getLine() + ": número de variáveis incompatível para circuito " + tipoCircuito + ".");
            }
            if(pilhaDeTabelas.topo().existeSimbolo(ctx.ID(0).getText())){
                Saida.println("Erro semântico na linha " + ctx.start.getLine() + ": circuito " + ctx.ID(0).getText() + " já possui um valor.");
            }
            else{
                pilhaDeTabelas.topo().adicionarSimbolo(new Simbolo(ctx.ID(0).getText(), "circuito"));
            }
        }
    }
    
    public void visitExp(CDLParser.ExpContext ctx){
        for(int i = 0; i < ctx.term_or().size(); i++){
            visitTerm_or(ctx.term_or(i));
        }
    }
    
    public void visitTerm_or(CDLParser.Term_orContext ctx){
        for(int i = 0; i < ctx.term_xor().size(); i++){
            visitTerm_xor(ctx.term_xor(i));
        }
    }
    
    public void visitTerm_xor(CDLParser.Term_xorContext ctx){
        for(int i = 0; i < ctx.term_and().size(); i++){
            visitTerm_and(ctx.term_and(i));
        }
    }
    
    public void visitTerm_and(CDLParser.Term_andContext ctx){
        visitTerm_not(ctx.term_not());
    }
    
    public void visitTerm_not(CDLParser.Term_notContext ctx){
        if(ctx.ID().size() > 0){
            String id = ctx.getText();
            if(!pilhaDeTabelas.topo().existeSimbolo(id)){
                pilhaDeTabelas.topo().adicionarSimbolo(new Simbolo(id, "var"));
            }
            Circuito circuito = ListaDeCircuitos.getCircuito(pilhaDeTabelas.topo().getEscopo());
            // Erro caso a variavel pertença a um circuito e não foi declarada na lista de entradas do circuito
            if(circuito != null && circuito.entradas.indexOf(id) == -1){
                Saida.println("Erro semântico na linha " + ctx.start.getLine() + ": variavel " + ctx.ID(0).getText() + " não existe como entrada do circuito.");
            }
        }
        else if(ctx.exp() != null){
            visitExp(ctx.exp());
        }
    }
    
}