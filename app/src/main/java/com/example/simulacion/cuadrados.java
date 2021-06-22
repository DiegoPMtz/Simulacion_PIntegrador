package com.example.simulacion;

public class cuadrados {

    int semilla, semilla2;

    cuadrados(int semilla) {
        this.semilla = semilla;
    }

    cuadrados(int semilla, int semilla2) {
        this.semilla = semilla;
        this.semilla2 = semilla2;
    }

    public float cuadrados() {
        int resultado = semilla * semilla;
        String resultado1 = Integer.toString(resultado);
        int longitud = Integer.toString(resultado).length();
        if (longitud == 2) {
            float numero = Integer.valueOf(resultado1.substring(0, longitud - 1));
            numero = (float) (numero / Math.pow(10, longitud - 1));
            System.out.println("cuadrados perfectos: " + numero);
            return numero;
        }else if(longitud == 1){
            float numero = Integer.valueOf(resultado1.substring(0));
            numero = (float) (numero / Math.pow(10, longitud));
            System.out.println("cuadrados perfectos: " + numero);
            return numero;
        }
        float numero = Integer.valueOf(resultado1.substring(1, longitud - 1));
        numero = (float) (numero / Math.pow(10, longitud - 2));
        System.out.println("cuadrados perfectos: " + numero);
        return numero;
    }

    public float punto() {
        int resultado = semilla * semilla2;
        String resultado1 = Integer.toString(resultado);
        int longitud = Integer.toString(resultado).length();
        if (longitud <= 2) {
            float numero = Integer.valueOf(resultado1.substring(0));
            numero = (float) (numero / Math.pow(10, longitud));
            System.out.println("punto medio: " + numero);
            return numero;
        }
        float numero = Integer.valueOf(resultado1.substring(1, longitud - 1));
        numero = (float) (numero / Math.pow(10, longitud - 2));
        System.out.println("punto medio: " + numero);
        return numero;
    }
}
