package util;

import Enums.NivelDeSeguranca;

public class PswScanner {


    public static String pswScanner(String password) {
    int qtDeNum = contadorDeNumeros(password);
    int qtDeLetrasMaiusculas = contadorDeLetrasMaiusculas(password);
    int qtDeLetrasMinusculas = contadorDeLetrasMinusculas(password);
    int qtDeCaracteresEspeciais = contadorDeCaracterEspecial(password);
    int qtDeCaracteres = password.length();
    if (
            qtDeCaracteres >= 8 && qtDeLetrasMaiusculas >= 1 && qtDeLetrasMinusculas >= 1 &&
            qtDeNum >= 1 && qtDeCaracteresEspeciais >= 1) {
        return NivelDeSeguranca.FORTE.getTexto();
    }
    else {
        return NivelDeSeguranca.FRACO.getTexto();
    }
    }



    private static int contadorDeLetrasMaiusculas(String password) {

        String[] letras = password.split("");
        int letrasMaiusculas = 0;
        for (int i = 0; letras.length > i; i++) {
            if (Character.isDigit(letras[i].charAt(0)) ) {
                continue;
            }
            if (letras[i] == letras[i].toUpperCase()) {
                letrasMaiusculas++;
            }
        }

        return letrasMaiusculas;
    }


    private static int contadorDeLetrasMinusculas(String password) {

        String[] letras = password.split("");
        int letrasMinusculas = 0;
        for (int i = 0; letras.length > i; i++) {
            if (Character.isDigit(letras[i].charAt(0)) ) {
                continue;
            }
            if (letras[i] == letras[i].toLowerCase()) { // da pra otimizar
                letrasMinusculas++;
            }
        }

        return letrasMinusculas;
    }

    private static int contadorDeNumeros(String password) {
        String[] letras = password.split("");
        int qtDeNumeros = 0;

        for (int i = 0; letras.length > i; i++) {

            try {
                Integer.parseInt(letras[i]);
                qtDeNumeros++;
            }
            catch (Exception e) {

            }
        }
        return qtDeNumeros;
    }

    private static int contadorDeCaracterEspecial(String password) {
        int qtDeCaracterEspecial = 0;

        for (int i = 0; i < password.length(); i++) {
            char caractere = password.charAt(i);

            if (!Character.isLetterOrDigit(caractere) && !Character.isWhitespace(caractere)) {
                qtDeCaracterEspecial++;
            }
        }
        return qtDeCaracterEspecial;
    }


}
