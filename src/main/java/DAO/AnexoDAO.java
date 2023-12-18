package DAO;

import Model.Anexo;
import interfaces.AnexoInterface;
import java.util.HashSet;
import java.util.List;

public class AnexoDAO implements AnexoInterface{
    
    private static List<Anexo>anexos;
    
    public AnexoDAO(){
        if(anexos == null){
            anexos = (List<Anexo>) new HashSet<Anexo>();
        }
  
    }

    @Override
    public void gravar(Anexo anexo) {
        anexos.add(anexo);
    }

    @Override
    public Anexo buscar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
