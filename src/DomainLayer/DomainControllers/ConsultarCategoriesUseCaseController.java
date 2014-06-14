package DomainLayer.DomainControllers;

import DomainLayer.DataInterface.*;
import DomainLayer.Excepcions.*;
import java.util.List;

public class ConsultarCategoriesUseCaseController {
    public List<String> ConsultarCategories() throws ExcepcionsAS {
        FactoriaControllers f = FactoriaControllers.getInstance();
        CtrlCategoria cC = f.getCtrlCat();
        List<String> res = cC.obteNomCategories(); // funcion que devuelve los nombres de todas las categorias
        if (res.isEmpty()) throw new ExcepcionsAS("No existeixen categories");
        return res;
    }
}
