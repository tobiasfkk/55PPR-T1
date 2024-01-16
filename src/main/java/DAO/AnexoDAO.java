package DAO;

import Model.Anexo;
import interfaces.AnexoInterface;
import java.util.HashSet;
import java.util.Set;

public class AnexoDAO implements AnexoInterface {

    private static AnexoDAO instance;
    private static Set<Anexo> anexos;

    private AnexoDAO() {
        if (anexos == null) {
            anexos = new HashSet<>();
        }
    }

    public static synchronized AnexoDAO getInstance() {
        if (instance == null) {
            instance = new AnexoDAO();
        }
        return instance;
    }

    @Override
    public void gravar(Anexo anexo) {
        anexos.add(anexo);
    }

    @Override
    public Anexo buscar() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
