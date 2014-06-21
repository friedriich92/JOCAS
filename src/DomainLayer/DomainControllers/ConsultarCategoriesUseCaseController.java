package DomainLayer.DomainControllers;

import DomainLayer.DataInterface.*;
import DomainLayer.Excepcions.*;

public class ConsultarCategoriesUseCaseController {
    public String[] ConsultarCategories() throws ExcepcionsAS {
        FactoriaControllers f = FactoriaControllers.getInstance();
        CtrlCategoria cC = f.getCtrlCategoria();
        String[] res = cC.obteNomCategories(); // funcion que devuelve los nombres de todas las categorias
        if (res.length == 0) throw new ExcepcionsAS("No existeixen categories");
        return res;
    }
}
