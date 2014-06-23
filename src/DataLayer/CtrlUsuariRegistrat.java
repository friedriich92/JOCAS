package DataLayer;

import DomainLayer.DomainModel.Jugador;
import DomainLayer.DomainModel.UsuariRegistrat;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Created by joanbarroso on 14/06/14.
 */
public class CtrlUsuariRegistrat implements DomainLayer.DataInterface.CtrlUsuariRegistrat {
    @Override
    public UsuariRegistrat obtenirUsuariRegistrat(String userN) {
        
       //creacion de la Session (?)
        
       SessionFactory sessionFactory;
       Session session;
       Configuration configuration = new Configuration();
       configuration.configure();
       ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
       sessionFactory = configuration.buildSessionFactory(serviceRegistry);
       session = sessionFactory.openSession();
       String query = "SELECT * FROM UsuariRegistrat WHERE username = " + userN;
       UsuariRegistrat UR = session.createSQLQuery(query).addEntity(UsuariRegistrat.class);
       session.close();
       sessionFactory.close();
       return UR;

    }


}
