package controllers;

import util.Inputer;
import util.PswScanner;
import util.Ui;

public class AppController {

    public static void init() {
        Ui.menuInicial();
        String password = Inputer.pegarString();
        String nivelDaSenha = PswScanner.pswScanner(password);
        Ui.mostrarSeguranca(nivelDaSenha);
    }





}
