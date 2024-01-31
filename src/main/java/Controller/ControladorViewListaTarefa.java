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

public class ControladorViewListaTarefa implements Observador {
    private ViewListaTarefa ViewListaTarefa = new ViewListaTarefa();
    private AtividadeDAO repositorioTarefa = new AtividadeDAO();
    
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
//        RelatorioFactory fabricaExcel = new ExcelRelatorioFactory();
//        Cabecalho cabecalhoExcel = fabricaExcel.criarCabecalho();
//        Corpo corpoExcel = fabricaExcel.criarCorpo();
//        Rodape rodapeExcel = fabricaExcel.criarRodape();    
    }
    
    public void ExportarPDF() throws FileNotFoundException{
        RelatorioFactory fabricaPDF = new PDFRelatorioFactory();
        Cabecalho cabecalhoPDF = fabricaPDF.criarCabecalho();
        Corpo corpoPDF = fabricaPDF.criarCorpo();
        Rodape rodapePDF = fabricaPDF.criarRodape();
        String caminho = (System.getProperty("user.dir")+"\\src\\main\\java\\arquivos\\arquivo.pdf");
        Document documento = new Document();
        
        try {
            PdfWriter.getInstance(documento, new FileOutputStream(caminho));
            documento.open();
            
            documento.add(new Paragraph(cabecalhoPDF.obterConteudo()));
            documento.add(new Paragraph(corpoPDF.obterConteudo()));
            documento.add(new Paragraph(rodapePDF.obterConteudo()));

            documento.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        
    }
}
