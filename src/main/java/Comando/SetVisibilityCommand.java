package Comando;

import View.ViewCadastrarCategoria;
import View.ViewCriarTarefa;
import javax.swing.JFrame;

public class SetVisibilityCommand implements Command {
    private JFrame tela;

    public SetVisibilityCommand(JFrame tela) {
        this.tela = tela;
    }

    @Override
    public void execute() {
        tela.setVisible(true);
    }
}
