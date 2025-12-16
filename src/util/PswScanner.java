package util;

import enums.NivelDeSeguranca;

public class PswScanner {


    /**
     * Metodo principal da classe
     *
     * @param password Ele pede senha para poder verificar o nivel de segurança
     * @return retorna uma String dizendo o nivel de segurança
     */
    public static String pswScanner(String password) {
    // aq ele vai vendo a quantidade de cada item
    int qtDeNum = contadorDeNumeros(password);
    int qtDeLetrasMaiusculas = contadorDeLetrasMaiusculas(password);
    int qtDeLetrasMinusculas = contadorDeLetrasMinusculas(password);
    int qtDeCaracteresEspeciais = contadorDeCaracterEspecial(password);
    int qtDeCaracteres = password.length();

    if (password == null || password.isEmpty()) return NivelDeSeguranca.FRACO.getTexto();

    if ( /* Logica para ser senha forte
        - mais que 8 caracteres
        - Pelo menos 1 maiúscula
        - Pelo menos 1 minúscula
        - Pelo menos 1 número
        - Pelo menos 1 caractere especial
        */
            qtDeCaracteres >= 8 && qtDeLetrasMaiusculas >= 1 && qtDeLetrasMinusculas >= 1 &&
            qtDeNum >= 1 && qtDeCaracteresEspeciais >= 1) {

        return NivelDeSeguranca.FORTE.getTexto();
    }
    else {
        return NivelDeSeguranca.FRACO.getTexto();
    }
    }

    // forma simplificada, não fiz assim pq queria treinar uma logica diferente, e o
    // desafio que eu tinha pedido pro gpt dessa maneira não era a mais eficiente
    // porem adaptei algumas coisas
    /*
    public static String pswScanner(String password) {
    if (password == null || password.length() < 8) {
        return NivelDeSeguranca.FRACO.getTexto();
    }

    boolean temMaiuscula = false, temMinuscula = false, temNum = false, temEspecial = false;

    for (char c : password.toCharArray()) {
        if (Character.isUpperCase(c)) temMaiuscula = true;
        else if (Character.isLowerCase(c)) temMinuscula = true;
        else if (Character.isDigit(c)) temNum = true;
        else if (!Character.isWhitespace(c)) temEspecial = true;
    }

    if (temMaiuscula && temMinuscula && temNum && temEspecial) {
        return NivelDeSeguranca.FORTE.getTexto();
    }

    // Aqui você poderia adicionar a lógica para o nível MÉDIO
    return NivelDeSeguranca.FRACO.getTexto();
}
     */



    private static int contadorDeLetrasMaiusculas(String password) {
        char[] letras = password.toCharArray();

        int letrasMaiusculas = 0;
        for (int i = 0; letras.length > i; i++) {
            if (Character.isDigit(letras[i]) ) {
                continue;
            }
            if (Character.isUpperCase(letras[i])) {
                letrasMaiusculas++;
            }
        }

        return letrasMaiusculas;
    }


    private static int contadorDeLetrasMinusculas(String password) {
        char[] letras = password.toCharArray();
        int letrasMinusculas = 0;
        for (int i = 0; letras.length > i; i++) {
            if (Character.isDigit(letras[i]) ) {
                continue;
            }
            if (Character.isLowerCase(letras[i])) {
                letrasMinusculas++;
            }
        }

        return letrasMinusculas;
    }

    private static int contadorDeNumeros(String password) {
        char[] letras = password.toCharArray();
        int qtDeNumeros = 0;

        for (int i = 0; letras.length > i; i++) {
            if (Character.isDigit(letras[i])) {
                qtDeNumeros++;
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
