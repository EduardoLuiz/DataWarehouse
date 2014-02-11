package Dominio;

public class Teste extends Classificador {
    
    @SuppressWarnings("OverridableMethodCallInConstructor")
    public void Teste () {
        
        AbrirArquivoDeTreinamento();
        AbrirArquivoDeTeste("./dist/teste.arff");
        
        if(ConferirSeArquivosSãoIguais()) {
            System.out.print("\nArquivos são iguais!!");
        }
        else {
            System.out.print("\nArquivos não são iguais!!");
        }
        
    }
    
    public int retornaInstanciaClassificada () {
        
        int itemRetornado = 0;
        
        if (classificador != null && ConferirSeArquivosSãoIguais()) {
            System.out.println("\n2. Apresentando os resultados dos testes de classificacao ");
            System.out.println("=============================================================================");
            try {
                for (int i = 0; i < entradasTeste.numInstances(); i++) {
                    System.out.println(classificador.classifyInstance(entradasTeste.instance(i)));
                    itemRetornado =(int) classificador.classifyInstance(entradasTeste.instance(i));
                }
            } catch (Exception erro) {
                System.out.println("Mensagem de Erro: " + erro.getMessage());
            }
            System.out.println("=============================================================================");
        }
        else {
            return -1;
        }
        
        return itemRetornado;
    }
    
    public void imprimeSumario () {
        if (avaliador != null && ConferirSeArquivosSãoIguais()) {
            System.out.println("\n1. Apresentando os resultados da treinamento da classificacao e validacao ");
            System.out.println("=============================================================================");
            System.out.println(avaliador.toSummaryString());
            System.out.println("=============================================================================");
        }
    }
    
    public double getInstanciasCorretamenteClassificadas () {
        return avaliador.pctCorrect();
    }
    
}
