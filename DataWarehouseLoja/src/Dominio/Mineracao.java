package Dominio;

public interface Mineracao {
    void AbrirArquivoDeTreinamento();
    void AbrirArquivoDeTeste(String nomeArquivoDeTeste);
    boolean ConferirSeArquivosSãoIguais();
}
