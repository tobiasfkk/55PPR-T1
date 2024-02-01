package Relatorio;

import Model.Tarefa;

public class ExcelCorpo implements Corpo{
  
    @Override
    public String obterConteudo(Tarefa tarefa) {  
        return "\n" + tarefa.toString();
    }
    
}
