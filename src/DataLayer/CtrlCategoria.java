package DataLayer;

import DomainLayer.DomainModel.Categoria;
import DomainLayer.DomainModel.Paraula;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;


/**
 * Created by joanbarroso on 14/06/14.
 */
public class CtrlCategoria implements DomainLayer.DataInterface.CtrlCategoria {
    @Override
    public String[] obteNomCategories() {       
        //creacion de la Session (?)
        
        SessionFactory sessionFactory;
        Session session;
        Configuration configuration = new Configuration();
        configuration.configure();
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        session = sessionFactory.openSession();
        
        String query = "SELECT nom FROM Categoria";
        SQLQuery q = session.createSQLQuery(query);
        List<Object[]> entities = q.list();
        String[] lista = new String[entities.size()];
        int i = 0;
        for (Object[] entity : entities) {
            lista[i] = entity[0].toString();
            ++i;
        }

        return lista;
    }
    
    @Override
    public Categoria get(String s) {
        
        //creacion de la Session (?)
        
        SessionFactory sessionFactory;
        Session session;
        Configuration configuration = new Configuration();
        configuration.configure();
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        session = sessionFactory.openSession();
        
        String query = "SELECT * FROM Categoria WHERE nom = " + s;
        SQLQuery q = session.createSQLQuery(query);
        Categoria c = q.addEntity(Categoria.class);
        session.close();
        sessionFactory.close();
        return c;
    }
    
    @Override
    public Paraula getParaulaRandom(String cat) {
        
        //creacion de la Session (?)
        
        SessionFactory sessionFactory;
        Session session;
        Configuration configuration = new Configuration();
        configuration.configure();
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        session = sessionFactory.openSession();
        
        String query = "SELECT * FROM Paraula WHERE categoria = cat ORDER BY RAND() LIMIT 1";       
        SQLQuery q = session.createSQLQuery(query);
        Paraula p = q.addEntity(Paraula.class);
        session.close();
        sessionFactory.close();
        return p;

    }
    
}
