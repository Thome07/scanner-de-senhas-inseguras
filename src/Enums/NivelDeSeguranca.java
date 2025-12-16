package Enums;

public enum NivelDeSeguranca {

    FORTE("Forte"),
    FRACO("Fraco");

    private final String texto;

    NivelDeSeguranca(String texto) {
        this.texto = texto;
    }

    public String getTexto() {
        return texto;
    }

}