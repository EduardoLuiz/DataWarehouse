package Dominio;

import java.util.Random;

public class GeradorRandomico {

    public static int getRandomico(Object[] arr) {
        int indice = GeradorRandomico.getRandomico(0, arr.length - 1);
        return (indice);
    }

    public static int getRandomico(int start, int end) {
        Random generator = new Random();
        long range = (long) end - (long) start + 1;
        long fraction = (long) (range * generator.nextDouble());
        return ((int) (fraction + start));
    }
}
