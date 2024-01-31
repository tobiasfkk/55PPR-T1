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
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

public class ControladorViewListaTarefa implements Observador {
    private ViewListaTarefa ViewListaTarefa = new ViewListaTarefa();
    private AtividadeDAO repositorioTarefa = new AtividadeDAO();
    List<Tarefa> tarefas = repositorioTarefa.buscarTodasTarefas();
//    private int i;
    
    public ControladorViewListaTarefa() {
        adicionarAcoes();
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
                try {
                    ExportarPDF();
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(ControladorViewListaTarefa.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    public void ExportarExcel(){
        RelatorioFactory fabricaExcel = new ExcelRelatorioFactory();
        Cabecalho cabecalhoExcel = fabricaExcel.criarCabecalho();
        Corpo corpoExcel = fabricaExcel.criarCorpo();
        Rodape rodapeExcel = fabricaExcel.criarRodape();

        String caminho = (System.getProperty("user.dir") + "\\src\\main\\java\\arquivos\\arquivo_excel.xlsx");

        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Relatorio");

            // Criar uma linha (linha de cabeçalho)
            Row headerRow = sheet.createRow(0);

            // Adicionar cabeçalhos (substitua pelos cabeçalhos reais)
            Cell headerCell = headerRow.createCell(0);
            headerCell.setCellValue(cabecalhoExcel.obterConteudo());

            
            int i = 1;
            for (Tarefa tarefa : tarefas) {
                Row dataRow = sheet.createRow(i);
                i++;
                Cell dataCell = dataRow.createCell(0);
                dataCell.setCellValue(corpoExcel.obterConteudo(tarefa));
            }

            // Salvar o arquivo Excel
            try (FileOutputStream fileOut = new FileOutputStream(caminho)) {
                workbook.write(fileOut);
                ViewListaTarefa.exibirMensagem("Relatório Excel gerado no caminho .../src/main/java/arquivos");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void ExportarPDF() throws FileNotFoundException{
        RelatorioFactory fabricaPDF = new PDFRelatorioFactory();
        Cabecalho cabecalhoPDF = fabricaPDF.criarCabecalho();
        Corpo corpoPDF = fabricaPDF.criarCorpo();
        Rodape rodapePDF = fabricaPDF.criarRodape();
        String caminho = (System.getProperty("user.dir")+"\\src\\main\\java\\arquivos\\arquivo_pdf.pdf");
        Document documento = new Document();
        
        try {
            PdfWriter.getInstance(documento, new FileOutputStream(caminho));
            documento.open();
            
            documento.add(new Paragraph(cabecalhoPDF.obterConteudo()));
            for (Tarefa tarefa : tarefas) {
                documento.add(new Paragraph(corpoPDF.obterConteudo(tarefa)));
            }
            
            documento.add(new Paragraph(rodapePDF.obterConteudo()));

            documento.close();
            
            ViewListaTarefa.exibirMensagem("Relatório PDF gerado no caminho .../src/main/java/arquivos");
            
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        
    }
}
