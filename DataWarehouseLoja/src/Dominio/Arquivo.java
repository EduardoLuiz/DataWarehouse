package Dominio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Arquivo {
    
    FileWriter fileWriter;
    PrintWriter printWriter;
    FileReader fileReader;
    BufferedReader bufferedReader;
    
    public Arquivo () {}
    
    public boolean gravaArquivo (String nomeArquivo, String conteudoArquivo) throws IOException {
        
        fileWriter = new FileWriter("./dist/" + nomeArquivo + ".arff");
        printWriter = new PrintWriter(fileWriter);
        printWriter.printf(conteudoArquivo);
        
        fileWriter.flush();
        fileWriter.close();
        
        return true;
    }
    
    public boolean atualizaArquivo (String nomeArquivo, String conteudoArquivo) throws IOException {
        
        fileWriter = new FileWriter("./dist/" + nomeArquivo + ".arff", true);
        printWriter = new PrintWriter(fileWriter);
        printWriter.printf(conteudoArquivo);
        
        fileWriter.flush();
        fileWriter.close();
        
        return true;
    }
    
    public boolean gravaArquivoParaECommerce (String conteudoArquivo) throws IOException {
        
        fileWriter = new FileWriter("./dist/index.html");
        printWriter = new PrintWriter(fileWriter);
        printWriter.printf(conteudoArquivo);
        
        fileWriter.flush();
        fileWriter.close();
        
        return true;
    }
    
}
