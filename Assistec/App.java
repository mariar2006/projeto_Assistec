package br.com.loja.assistec;

import br.com.loja.assistec.view.LoginView;


public class App {
    public static void main(String[] args) {
    	LoginView view = new LoginView();
    	view.setLocationRelativeTo(null);
		view.setVisible(true);
    }
}
