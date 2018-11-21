package cdl;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

public class CDL{

    public static void main(String[] args) throws Exception{
        
        boolean DEBUG = false;
        
        // Verifica os argumentos recebidos
        if(!DEBUG && args.length != 1){
            System.out.println("Compilador CDL");
            System.out.println("Deve ser passado o nome do arquivo de entrada!");
            System.exit(0);
        }
        
        String nomeArquivoEntrada;
        
        int n = 1;
        String tipoTeste = "semantico";
        
        if(!DEBUG) nomeArquivoEntrada = args[0];
        else nomeArquivoEntrada = "C:\\Users\\otavi\\Desktop\\Compilers_2\\CDL\\src\\cdl\\testes\\" + tipoTeste + "\\teste" + n + ".cdl";       
        
        // Converte o arquivo de entrada para um input do ANTLR
        ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(nomeArquivoEntrada));
        
        // Análise léxica
        CDLLexer lexer = new CDLLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        
        // Análise sintática
        CDLParser parser = new CDLParser(tokens);
        parser.removeErrorListeners();
        CDLErrorListener errorListener = new CDLErrorListener();
        parser.addErrorListener(errorListener);
        CDLParser.ProgramContext arvore = parser.program();
        
        // Análise semântica
        if(Saida.isEmpty()){ // apenas se não houve erro na análise sintática
            CDLVisitorSemantico visitorSemantico = new CDLVisitorSemantico();
            visitorSemantico.visitProgram(arvore);
        }
        
        // Geração de código C
        if(Saida.isEmpty()){ // apenas se não houve erro na análise semântica
            CDLVisitorGerador visitorGerador = new CDLVisitorGerador();
            visitorGerador.visitProgram(arvore);
            
            FileOutputStream arquivoSaida;
            
            if(!DEBUG) arquivoSaida = new FileOutputStream(nomeArquivoEntrada.substring(0, nomeArquivoEntrada.length()-4) + ".html");
            else arquivoSaida = new FileOutputStream("C:\\Users\\otavi\\Desktop\\Compilers_2\\CDL\\src\\cdl\\codigos_gerados\\CDL.html");
            
            PrintWriter p = new PrintWriter(arquivoSaida);
            
            Codigos.printInicioHTML(p); // Escreve o início do html
            Codigos.printP5_js(p); // Escreve o script p5.js
            Codigos.printAPI_CDL(p); // Escreve as classes dos objetos
            p.write(Saida.getTexto()); // *** Escreve o código gerado ***
            Codigos.printFimHTML(p); // Escreve o fim do html
            
            // Fecha o arquivo
            p.close();
            arquivoSaida.close();
        }
        else{
            System.out.println(Saida.getTexto());
            Saida.println("Fim da compilacao");
        }

        if(DEBUG) System.out.println(Saida.getTexto());
        
    }
    
}
