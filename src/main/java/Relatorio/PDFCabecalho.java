package Relatorio;

public class PDFCabecalho implements Cabecalho{

    @Override
    public String obterConteudo() {
        return "Relatório de Tarefas ------------------------------------------------------------------------------------------------------\n"
                + "\n"
                + "Título - Descrição - Data criação - Prioridade - Status";
    }
    
}
