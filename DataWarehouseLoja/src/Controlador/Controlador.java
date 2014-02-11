package Controlador;

import Dominio.Aprendizado;
import Dominio.Arquivo;
import Dominio.Relacao;
import Dominio.Teste;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Controlador {

    Teste teste;
    Arquivo arquivo = new Arquivo();
    Relacao relacao = new Relacao();
    private boolean houveAprendizado;
    private String nomeCampoInstanciado;

    public Controlador() {
        try {
            arquivo.gravaArquivo("loja", new Relacao().retornaTextoArffDeAprendizado());
            arquivo.gravaArquivo("teste", new Relacao().retornaTextoArffDeTeste());
            
        } catch (IOException iOException) {
            System.out.printf(iOException.getMessage());
        }
    }
    
    public void recebeParametrosDaInterface (int campoTravado, int console, int tipo, int idade, int sexo, 
            int estadocivil, int data) 
    {
        try {
            arquivo.gravaArquivo("teste", new Relacao().retornaTextoArffDeTeste());
        } catch (IOException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            
            if (campoTravado == 0) { 
                arquivo.atualizaArquivo("teste",    "?" + "," + 
                                                    relacao.retornaTipoDeJogo(tipo)+ "," +
                                                    relacao.retornaIdade(idade) + "," +
                                                    relacao.retornaSexo(sexo) + "," + 
                                                    relacao.retornaEstadoCivil(estadocivil) + "," + 
                                                    relacao.retornaDataEspecial(data)); 
            }
            else if (campoTravado == 1) { 
                arquivo.atualizaArquivo("teste",    relacao.retornaConsole(console) + "," + 
                                                    "?" + "," +
                                                    relacao.retornaIdade(idade) + "," +
                                                    relacao.retornaSexo(sexo) + "," + 
                                                    relacao.retornaEstadoCivil(estadocivil) + "," + 
                                                    relacao.retornaDataEspecial(data)); 
            }
            else if (campoTravado == 2) {
                arquivo.atualizaArquivo("teste",    relacao.retornaConsole(console) + "," + 
                                                    relacao.retornaTipoDeJogo(tipo)+ "," +
                                                    "?" + "," +
                                                    relacao.retornaSexo(sexo) + "," + 
                                                    relacao.retornaEstadoCivil(estadocivil) + "," + 
                                                    relacao.retornaDataEspecial(data));
            }
            else if (campoTravado == 3) { 
                arquivo.atualizaArquivo("teste",    relacao.retornaConsole(console) + "," + 
                                                    relacao.retornaTipoDeJogo(tipo)+ "," +
                                                    relacao.retornaIdade(idade) + "," +
                                                    "?" + "," + 
                                                    relacao.retornaEstadoCivil(estadocivil) + "," + 
                                                    relacao.retornaDataEspecial(data));
            }
            else if (campoTravado == 4) { 
                arquivo.atualizaArquivo("teste",    relacao.retornaConsole(console) + "," + 
                                                    relacao.retornaTipoDeJogo(tipo)+ "," +
                                                    relacao.retornaIdade(idade) + "," +
                                                    relacao.retornaSexo(sexo) + "," + 
                                                    "?" + "," + 
                                                    relacao.retornaDataEspecial(data));
            }
            else if (campoTravado == 5) { 
                arquivo.atualizaArquivo("teste",    relacao.retornaConsole(console) + "," + 
                                                    relacao.retornaTipoDeJogo(tipo)+ "," +
                                                    relacao.retornaIdade(idade) + "," +
                                                    relacao.retornaSexo(sexo) + "," + 
                                                    relacao.retornaEstadoCivil(estadocivil) + "," + 
                                                    "?");
            }
            
            System.out.println("gravado com sucesso");
            
            teste = new Teste();
            teste.setIndexDaClasse(campoTravado);
            teste.Teste();
            teste.imprimeSumario();
            
            String [] campos = new String [] {relacao.retornaConsole(console), relacao.retornaTipoDeJogo(tipo),
                relacao.retornaIdade(idade), relacao.retornaSexo(sexo), relacao.retornaEstadoCivil(estadocivil),
                relacao.retornaDataEspecial(data)};
            
            Aprendizado aprendizado = new Aprendizado(campoTravado, teste.retornaInstanciaClassificada(), 
                    teste.getInstanciasCorretamenteClassificadas(), campos);
            
            houveAprendizado = aprendizado.haveraAprendizado();
            System.out.println("->>> Houve aprendizado: " + houveAprendizado);
            nomeCampoInstanciado = aprendizado.nomeCampoInstanciado();
            System.out.println("->>> nome campo instanciado: " + nomeCampoInstanciado);
            
        } catch (IOException iOException) {
            System.out.printf(iOException.getMessage());
        }
    }
    
    public boolean getHouveAprendizado () {
        return houveAprendizado;
    }
    
    public String getNomeCampoInstanciado () {
        return nomeCampoInstanciado;
    }
}
