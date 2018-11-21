package cdl;

import java.util.BitSet;
import org.antlr.v4.runtime.ANTLRErrorListener;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.dfa.DFA;

// Error Listener criado para o tratamento dos erros sintáticos
public class CDLErrorListener implements ANTLRErrorListener{
    
    // Quando o parser detecta um erro sintático é chamado o método syntaxError, o qual foi sobrescrito para imprimir as mensagens do nosso compilador
    // Erros léxicos também serão capturados pelo parser por causa do token CARACTERE_ERRADO adicionado no final da gramática
    @Override
    public void syntaxError(Recognizer<?, ?> rcgnzr, Object o, int i, int i1, String string, RecognitionException re) {
        if(Saida.isEmpty() && o instanceof Token){ // Para imprimir apenas o primeiro erro
            Token token = (Token)o;
            String texto = token.getText();
            // Erro léxico
            if(token.getType() == CDLLexer.WRONG_CHAR){
                Saida.println("Linha " + i + ": " + texto + " - simbolo nao identificado");
            }
            // Erro sintático
            else{
                Saida.println("Linha " + i + ": erro sintatico proximo a " + texto);
            }
        }
    }

    @Override
    public void reportAmbiguity(Parser parser, DFA dfa, int i, int i1, boolean bln, BitSet bitset, ATNConfigSet atncs) {}

    @Override
    public void reportAttemptingFullContext(Parser parser, DFA dfa, int i, int i1, BitSet bitset, ATNConfigSet atncs) {}

    @Override
    public void reportContextSensitivity(Parser parser, DFA dfa, int i, int i1, int i2, ATNConfigSet atncs) {}
    
}
