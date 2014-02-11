package Dominio;

public class Relacao {
    private String textoArffDeAprendizado;
    private String textoArffDeTeste;
    
    public Relacao () {
        textoArffDeAprendizado = "@RELATION loja%n%n";
        textoArffDeTeste = "@RELATION teste%n%n";
        
        String temp = "@attribute console {pc, xbox360, ps3, wiiu}"
                + "%n@attribute tipoJogo {adventure,beat,fighting,fps,platformer,shooter,survival,driving,puzzle,simulation,virtual_life,rpg,strategy,sports}"
                + "%n@attribute idadeComprador{18, 25, 40, 0}"
                + "%n@attribute sexoComprador {masculino,feminino}"
                + "%n@attribute estadoCivilComprador {solteiro,casado,viuvo,divorciado}"
                + "%n@attribute dataEspecialDeCompra {anonovo,maes,mulher,pais,namorados,natal,nenhuma}"
                + "%n%n@data%n";
        
        textoArffDeAprendizado += temp;
        textoArffDeTeste += temp;
        temp = "";
        
        for (int i = 0; i < 50; i++ ){
            temp+= gerarUmaDataDeAprendizado();
        }
        
        textoArffDeAprendizado += temp;
        
    }
    
    public String retornaTextoArffDeAprendizado () {
        return textoArffDeAprendizado;
    }
    
    public String retornaTextoArffDeTeste () {
        return textoArffDeTeste;
    }
    
    public String DataDeAprendizados () {
        return "";
    }
    
    public static String gerarUmaDataDeAprendizado () {
        
        String umaInstancia;
        String[] consoles = new String[] {"pc", "xbox360", "ps3", "wiiu", "pc"};        
        String[] genero = new String[] {"adventure", "beat", "fighting", "fps",
            "platformer", "shooter", "survival", "driving", "puzzle", 
            "simulation", "virtual_life", "rpg", "strategy", "sports"}; 
        String[] idade = new String[] {"18", "25", "40", "0"};
        String[] sexo = new String[] {"masculino", "feminino"};
        String[] civil = new String[] {"solteiro", "casado", "viuvo", "divorciado"};
        String[] dataEspecial = new String[] {"anonovo", "maes", "mulher", "pais",
            "namorados", "natal", "nenhuma"};
        
        umaInstancia = consoles[GeradorRandomico.getRandomico(consoles)];
        umaInstancia += "," + genero[GeradorRandomico.getRandomico(genero)];
        umaInstancia += "," + idade[GeradorRandomico.getRandomico(idade)];
        umaInstancia += "," + sexo[GeradorRandomico.getRandomico(sexo)];
        umaInstancia += "," + civil[GeradorRandomico.getRandomico(civil)];
        umaInstancia += "," + dataEspecial[GeradorRandomico.getRandomico(dataEspecial)] + "%n";
        
        
        return umaInstancia;
    }
    
    public String retornaConsole (int param) {
        if (param == 0) {return "pc";}
        else if (param == 1) {return "xbox360";}
        else if (param == 2) {return "ps3";}
        else {return "wiiu";}
    }
    
    public String retornaTipoDeJogo (int param) {
        if (param == 0) {return "adventure";}
        else if (param == 1) {return "beat";}
        else if (param == 2) {return "fighting";}
        else if (param == 3) {return "fps";}
        else if (param == 4) {return "platformer";}
        else if (param == 5) {return "shooter";}
        else if (param == 6) {return "survival";}
        else if (param == 7) {return "driving";}
        else if (param == 8) {return "puzzle";}
        else if (param == 9) {return "simulation";}
        else if (param == 10) {return "virtual_life";}
        else if (param == 11) {return "rpg";}
        else if (param == 12) {return "strategy";}
        else {return "sports";}
    }
    
    public String retornaIdade (int param) {
        if (param == 0) {return "18";}
        else if (param == 1) {return "25";}
        else if (param == 2) {return "40";}
        else {return "0";}
    }
    
    public String retornaSexo (int param) {
        if (param == 0) {return "masculino";}
        else {return "feminino";}
    }
    
    public String retornaEstadoCivil (int param) {
        if (param == 0) {return "solteiro";}
        else if (param == 1) {return "casado";}
        else if (param == 2) {return "viuvo";}
        else {return "divorciado";}
    }
    
    public String retornaDataEspecial (int param) {
        if (param == 0) {return "anonovo";}
        else if (param == 1) {return "maes";}
        else if (param == 2) {return "mulher";}
        else if (param == 3) {return "pais";}
        else if (param == 4) {return "namorados";}
        else if (param == 5) {return "natal";}
        else {return "nenhuma";}
    }

}
