package Relatorio;

public class PDFRodape implements Rodape{

    @Override
    public String obterConteudo() {
        return "Rodapé do relatório PDF";
    }
    
}
