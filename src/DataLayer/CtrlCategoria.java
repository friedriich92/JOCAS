package DataLayer;

import DomainLayer.DomainModel.Categoria;
import DomainLayer.DomainModel.Paraula;
import java.util.ArrayList;
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
        Object[] res = session.createSQLQuery(query);

        String[] lista = new String[res.length];
        for (int i = 0; i < res.length; ++i) 
            lista[i] = res[i].toString();

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
        return session.createSQLQuery(query).addEntity(Categoria.class);
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
        Paraula p = session.createSQLQuery(query).addEntity(Paraula.class);
        session.close();
        sessionFactory.close();
        return p;

    }
    
}
