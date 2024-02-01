package Relatorio;

public class ExcelRelatorioFactory implements RelatorioFactory {

    @Override
    public Cabecalho criarCabecalho() {
        return new ExcelCabecalho();
    }

    @Override
    public Corpo criarCorpo() {
        return new ExcelCorpo();
    }

    @Override
    public Rodape criarRodape() {
       return new ExcelRodape();
    }
    
}
