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
        Paraula[] p = session.createSQLQuery(query).addEntity(Paraula.class);
        session.close();
        sessionFactory.close();
        return p;
    }
}
