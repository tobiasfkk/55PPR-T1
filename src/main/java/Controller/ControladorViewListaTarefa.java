package Controller;

import DAO.AtividadeDAO;
import Model.Tarefa;
import Observador.Observador;
import Relatorio.Cabecalho;
import Relatorio.Corpo;
import Relatorio.ExcelRelatorioFactory;
import Relatorio.PDFRelatorioFactory;
import Relatorio.RelatorioFactory;
import Relatorio.Rodape;
import View.ViewListaTarefa;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ControladorViewListaTarefa implements Observador {
    private ViewListaTarefa ViewListaTarefa = new ViewListaTarefa();
    private AtividadeDAO repositorioTarefa = new AtividadeDAO();
    
    public ControladorViewListaTarefa() {
//        abrirTela();
    }
    
    public void abrirTela(){
        ViewListaTarefa.exibir();
    }
    
    public void fecharTela(){
        ViewListaTarefa.fechar();
    }

    @Override
    public void atualizarListaTarefas() {
        List<Tarefa> todasTarefas = repositorioTarefa.buscarTodasTarefas();
        ViewListaTarefa.addTarefa(todasTarefas);
    }
    
    public void adicionarAcoes(){
        
        ViewListaTarefa.adicionarAcaoBotaoExcel(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ExportarExcel();
            }
        });
        
         ViewListaTarefa.adicionarAcaoBotaoPDF(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ExportarPDF();
            }
        });
    }
    
    public void ExportarExcel(){
        RelatorioFactory fabricaExcel = new ExcelRelatorioFactory();
        Cabecalho cabecalhoExcel = fabricaExcel.criarCabecalho();
        Corpo corpoExcel = fabricaExcel.criarCorpo();
        Rodape rodapeExcel = fabricaExcel.criarRodape();
        
//        String conteudoExcel = cabecalhoExcel.obterConteudo() +
//                               corpoExcel.obterConteudo() +
//                               rodapeExcel.obterConteudo();
//
//        // aqui fazer lógica para realmente exportar
//        System.out.println("Exportando para Excel:\n" + conteudoExcel);

//        Workbook workbook = new XSSFWorkbook();
//        Sheet sheet = workbook.createSheet("Relatorio");
//
//        Row headerRow = sheet.createRow(0);
//        Cell headerCell = headerRow.createCell(0);
//        headerCell.setCellValue(cabecalho);
//
//        Row bodyRow = sheet.createRow(1);
//        Cell bodyCell = bodyRow.createCell(0);
//        bodyCell.setCellValue(corpo);
//
//        Row footerRow = sheet.createRow(2);
//        Cell footerCell = footerRow.createCell(0);
//        footerCell.setCellValue(rodape);
//
//        try (FileOutputStream fileOut = new FileOutputStream("relatorio.xlsx")) {
//            workbook.write(fileOut);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        
    }
    
    public void ExportarPDF(){
        RelatorioFactory fabricaPDF = new PDFRelatorioFactory();
        Cabecalho cabecalhoPDF = fabricaPDF.criarCabecalho();
        Corpo corpoPDF = fabricaPDF.criarCorpo();
        Rodape rodapePDF = fabricaPDF.criarRodape();
        
//        try (PDDocument document = new PDDocument()) {
//            PDPage page = new PDPage();
//            document.addPage(page);
//
//            try (PDPageContentStream contentStream = new PDPageContentStream(document, page)) {
//                contentStream.beginText();
//                contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);
//                contentStream.newLineAtOffset(100, 700);
//                contentStream.showText(cabecalhoPDF);
//                contentStream.newLine();
//                contentStream.showText(corpoPDF);
//                contentStream.newLine();
//                contentStream.showText(rodapePDF);
//                contentStream.endText();
//            }
//
//            document.save("relatorio.pdf");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
