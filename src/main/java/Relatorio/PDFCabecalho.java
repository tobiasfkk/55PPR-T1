package Relatorio;

public class PDFCabecalho implements Cabecalho{

    @Override
    public String obterConteudo() {
        return "Cabeçalho do relatório PDF";
    }
    
}
