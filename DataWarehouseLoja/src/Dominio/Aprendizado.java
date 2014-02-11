package Dominio;

import eCommerce.LojaCommerce;
import java.io.IOException;

public class Aprendizado {
    
    private int campoTravado;
    private int campoInstanciado;
    private double pctCorrect;
    private String [] campos;
    private Relacao relacao = new Relacao();
    
    public Aprendizado (int campoTravado, int campoInstanciado, double pctCorrect, String [] campos) {
        this.campoTravado = campoTravado;
        this.campoInstanciado = campoInstanciado;
        this.pctCorrect = pctCorrect;
        this.campos = campos;
    }
    
    public boolean haveraAprendizado () {
        
        if (pctCorrect > 20.0) {
            
            buscaCampoInstanciado();
            
            try {
                Arquivo arquivo = new Arquivo();
                arquivo.atualizaArquivo("loja", "%n" +  campos[0] + "," + campos[1] + "," + campos[2] + "," +
                                                        campos[3] + "," + campos[4] + "," + campos[5]);
                
                LojaCommerce ecommerce = new LojaCommerce(campos[0], campos[1]);
                
                return true;
            }
            catch (IOException iOException) {
                System.out.print(iOException.getMessage());
            }
        }
        
        return false;
    }
    
    public void buscaCampoInstanciado() {
        if(campoTravado == 0) { campos[0] = relacao.retornaConsole(campoInstanciado); }
        else if (campoTravado == 1) { campos[1] = relacao.retornaTipoDeJogo(campoInstanciado); }
        else if (campoTravado == 2) { campos[2] = relacao.retornaIdade(campoInstanciado); }
        else if (campoTravado == 3) { campos[3] = relacao.retornaSexo(campoInstanciado); }
        else if (campoTravado == 4) { campos[4] = relacao.retornaEstadoCivil(campoInstanciado); }
        else { campos[5] = relacao.retornaDataEspecial(campoInstanciado); }
    }
    
    public String nomeCampoInstanciado () {
        if(campoTravado == 0) { return relacao.retornaConsole(campoInstanciado); }
        else if (campoTravado == 1) { return relacao.retornaTipoDeJogo(campoInstanciado); }
        else if (campoTravado == 2) { return relacao.retornaIdade(campoInstanciado); }
        else if (campoTravado == 3) { return relacao.retornaSexo(campoInstanciado); }
        else if (campoTravado == 4) { return relacao.retornaEstadoCivil(campoInstanciado); }
        else { return relacao.retornaDataEspecial(campoInstanciado); }
    }
    
}
