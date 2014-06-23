package DomainLayer.DataInterface;

import DomainLayer.DomainModel.Categoria;
import DomainLayer.DomainModel.Paraula;
import java.util.List;

/**
 * Created by jedi on 10/06/14.
 */
public interface CtrlCategoria {
    public String[] obteNomCategories();
    public Categoria get(String s);
    public Paraula getParaulaRandom(String cat);
}
