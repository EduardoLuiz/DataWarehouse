package Dominio;

import java.io.File;
import java.io.FileReader;
import java.util.Random;
import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.classifiers.bayes.NaiveBayes;
import weka.core.Instances;

public class Classificador implements Mineracao {
    
    protected String nomeArquivoDeTeste;
    private File arquivoTreinamento, arquivoTeste;
    private FileReader leitorTreinamento, leitorTeste;
    protected Instances entradasTreinamento, entradasTeste;
    protected static Classifier classificador;
    protected Evaluation avaliador;
    protected int indexDeClasse;

    public void AbrirArquivoDeTreinamento() {
        try {
            arquivoTreinamento = new File("./dist/loja.arff");
            leitorTreinamento = new FileReader(arquivoTreinamento);
            entradasTreinamento = new Instances(leitorTreinamento);
            entradasTreinamento.setClassIndex(indexDeClasse); //entradasTreinamento.numAttributes() - 1);
            classificador = new NaiveBayes();
            classificador.buildClassifier(entradasTreinamento);
            avaliador = new Evaluation(entradasTreinamento);
            avaliador.crossValidateModel(classificador, entradasTreinamento, 8, new Random(1));
        }
        catch (Exception ex) { System.out.print("\nErro para abrir arquivo de treinamento " + ex.toString()); }
    }

    public void AbrirArquivoDeTeste(String nomeArquivoDeTeste) {
        this.nomeArquivoDeTeste = nomeArquivoDeTeste;
        try {
            arquivoTeste = new File(nomeArquivoDeTeste);
            leitorTeste = new FileReader(arquivoTeste);
            entradasTeste = new Instances(leitorTeste);
            entradasTeste.setClassIndex(indexDeClasse); //entradasTeste.numAttributes() - 1);
        }
        catch (Exception ex) { System.out.print("\nErro para abrir arquivo de teste" + ex.toString()); }
    }
    
    public boolean ConferirSeArquivosSãoIguais() {
        if (!entradasTreinamento.equalHeaders(entradasTeste)) {
                return false;
        }
        return true;
    }
    
    public void setIndexDaClasse (int indexDeClasse) {
        this.indexDeClasse = indexDeClasse;
    }
    
    public int getIndexDaClasse () {
        return indexDeClasse;
    }
    
}
