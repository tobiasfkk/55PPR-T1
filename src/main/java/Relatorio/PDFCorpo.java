package Relatorio;

import Model.Tarefa;

public class PDFCorpo implements Corpo{
    
    @Override
    public String obterConteudo(Tarefa tarefa) {
        return "\n" + tarefa.toString();
    }
    
}
