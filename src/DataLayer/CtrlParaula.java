package DataLayer;

import DomainLayer.DomainModel.*;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Created by joanbarroso on 14/06/14.
 */

public class CtrlParaula implements DomainLayer.DataInterface.CtrlParaula {
    
    @Override
    public Paraula[] getParaulesByCategoria(String cat) {
        
        //creacion de la Session (?)
        
        SessionFactory sessionFactory;
        Session session;
        Configuration configuration = new Configuration();
        configuration.configure();
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        session = sessionFactory.openSession();
        String query = "SELECT * FROM Paraula WHERE categoria = " + cat;
        SQLQuery q = session.createSQLQuery(query);
        List<Object[]> entities = q.list();
        Paraula p[] = new Paraula[entities.size()];
        int i = 0;
        for (Object[] entity : entities) {
            p[i].setNom(entity[0].toString());
            p[i].setNombreDeLletres(Integer.parseInt(entity[1].toString()));
            Categoria c = new Categoria();
            c.setNom(entity[2].toString());
            p[i].setCategoria(c);
        }
        session.close();
        sessionFactory.close();
        return p;
    }
    
    @Override
    public Paraula getParaula(String s) {
        
       //creacion de la Session (?)
        
       SessionFactory sessionFactory;
       Session session;
       Configuration configuration = new Configuration();
       configuration.configure();
       ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
       sessionFactory = configuration.buildSessionFactory(serviceRegistry);
       session = sessionFactory.openSession();
        String query = "SELECT * FROM Paraula WHERE nom = " + s;
        SQLQuery q = session.createSQLQuery(query);
        List<Object[]> entities = q.list();
        Paraula p = new Paraula();
        for (Object[] entity : entities) {
            p.setNom(entity[0].toString());
            p.setNombreDeLletres(Integer.parseInt(entity[1].toString()));
            
            CtrlCategoria cC = new CtrlCategoria();
            Categoria c = cC.get(entity[2].toString());
            p.setCategoria(c);
        }
        session.close();
        sessionFactory.close();
        return p;

    }
}
