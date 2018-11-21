package cdl;

// Classe para armazenar a saída do compilador
public class Saida {
    
    private static String texto = "";
    
    public static void println(String txt) {
        texto += txt + "\n";
    }
    
    public static void print(String txt){
        texto += txt;
    }
    
    public static void clear() {
        texto = "";
    }
    
    public static String getTexto() {
        return texto;
    }
    
    public static boolean isEmpty(){
        return texto.isEmpty();
    }
    
}
