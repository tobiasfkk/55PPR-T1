package Relatorio;

public class PDFRelatorioFactory implements RelatorioFactory {

    @Override
    public Cabecalho criarCabecalho() {
        return new PDFCabecalho();
    }

    @Override
    public Corpo criarCorpo() {
        return new PDFCorpo();
    }

    @Override
    public Rodape criarRodape() {
        return new PDFRodape();
    }
    
}
