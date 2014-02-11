package eCommerce;

import Dominio.Arquivo;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LojaCommerce {
    
    private String ondeEstaImagem;
    private Arquivo arquivo;
    private String parteInicio;
    
    public LojaCommerce (String console, String tipo) {
        
        ondeEstaImagem = tipo + ondeEstaImagemComConsole(console);
        
        arquivo = new Arquivo();
        
        try {
            arquivo.gravaArquivoParaECommerce(getParteInico() + geraComponente(tipo) + getParteFim());
        } catch (IOException ex) {
            Logger.getLogger(LojaCommerce.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private String ondeEstaImagemComConsole(String console) {
        if(console.equals("pc")) { return "_p"; }
        else if(console.equals("xbox360")) { return "_x"; } 
        else if(console.equals("ps3")) { return "_3"; }
        else  { return "_w"; }
    }
    
    private String geraComponente (String tipo) {
        return "<div class=\"component\" style=\"background-image: url('../src/images/" + tipo + "/" + ondeEstaImagem +  ".jpg') \" > </div>";
    }
    
    public static void main (String [] ar) {
        LojaCommerce ecommerce = new LojaCommerce("xbox360", "shooter");
        System.out.println(ecommerce.geraComponente("adventure"));
        Arquivo arquivo = new Arquivo();
    }
    
    private String getParteInico () {
        return "<!DOCTYPE html>\n" +
"<html>\n" +
"    \n" +
"    <head>\n" +
"        <title>Wow Factor</title>\n" +
"                <link rel=\"stylesheet\" href=\"../src/eCommerce/eCommerce.css\" /> " +
"        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n" +
"    </head>\n" +
"    \n" +
"    <body>\n" +
"        <table>\n" +
"            <tr>\n" +
"                <td>\n" +
"                    <h1 style=\"margin-left: 100px; margin-top: 60px\">Wow Factor</h1>\n" +
"                    <img src=\"../src/images/awesome100_icon.png\" />\n" +
"                </td>\n" +
"                <td style=\"vertical-align: top; border-left: 1px solid #898989; padding-bottom: 30px\">\n" +
"                    \n" +
"                    <div style=\"margin-left: 60px; padding-top: 100px\">\n" +
"                        <h2>Jogo Recomendado: </h2>";
    }
    
    private String getParteFim () {
        return "</div>\n" +
"                </td> \n" +
"            </tr>\n" +
"        </table>   <div class='granLine'> </div>  \n" +
"    </body>\n" +
"</html>";
    }
}
