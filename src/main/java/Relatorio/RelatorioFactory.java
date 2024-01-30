package Relatorio;

public interface RelatorioFactory {
    Cabecalho criarCabecalho();
    Corpo criarCorpo();
    Rodape criarRodape();
}
