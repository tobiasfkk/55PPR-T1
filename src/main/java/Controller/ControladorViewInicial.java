package Controller;

import View.ViewInicial;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorViewInicial {
    
    private ViewInicial viewInicial = new ViewInicial();;

    public ControladorViewInicial() {
        exibir();
        adicionarAcao();
    }
    
    public void adicionarAcao(){
        viewInicial.adicionarAcaoBotao(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirMenu();
            }
        });
    }
    
//    public void abrirMenu(){
//        fechar();
//        ControladorViewMenu controladorViewMenu = new ControladorViewMenu();
//        ControladorViewListaTarefa controladorViewListaTarefa = new ControladorViewListaTarefa();
//        ControladorViewCriarTarefa controladorViewCriarTarefa = new ControladorViewCriarTarefa();
//        controladorViewCriarTarefa.adicionarObservador(controladorViewListaTarefa);
//        controladorViewCriarTarefa.fecharTela();
//    }
    
    public void abrirMenu() {
        ControladorViewMenu controladorViewMenu = new ControladorViewMenu();
        ControladorViewListaTarefa controladorViewListaTarefa = new ControladorViewListaTarefa();
        ControladorViewCriarTarefa controladorViewCriarTarefa = new ControladorViewCriarTarefa();

        // Adiciona o ControladorViewListaTarefa como observador
        controladorViewCriarTarefa.adicionarObservador(controladorViewListaTarefa);

        // Fecha a tela do ControladorViewCriarTarefa somente após notificar os observadores
        controladorViewCriarTarefa.fecharTela();
    }

    
    public void exibir(){
        viewInicial.abrirTela();
    }
    
    public void fechar(){
        viewInicial.fechar();
    }
}
