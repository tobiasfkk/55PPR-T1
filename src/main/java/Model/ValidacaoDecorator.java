/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import interfaces.TarefaDecorator;

/**
 *
 * @author Joao
 */
public class ValidacaoDecorator implements TarefaDecorator {
    private ComponenteTarefa tarefa;

    public ValidacaoDecorator(ComponenteTarefa tarefa) {
        this.tarefa = tarefa;
    }

    @Override
    public void operacao() {
    
        tarefa.operacao();

        if (validacaoBemSucedida()) {
            System.out.println("Validação bem-sucedida!");
        } else {
            System.out.println("Validação falhou!");
        }
    }

    private boolean validacaoBemSucedida() {
        // Lógica de validação
        // Retorna true se a validação for bem-sucedida, false caso contrário
        if (!((Atividade) tarefa).getTitulo().isEmpty()) {
        return true;
    } else {
        return false;
    } 
    }

    @Override
    public void metodoComum() {
       System.out.println("Executando método comum a todos os decorators.");
 
    }

    @Override
    public void visit(Tarefa tarefa) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
