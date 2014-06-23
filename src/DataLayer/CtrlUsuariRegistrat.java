package DataLayer;

import DomainLayer.DomainModel.Categoria;
import DomainLayer.DomainModel.Jugador;
import DomainLayer.DomainModel.Paraula;
import DomainLayer.DomainModel.UsuariRegistrat;
import java.util.List;
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
        SQLQuery q = session.createSQLQuery(query);
        List<Object[]> entities = q.list();
        UsuariRegistrat uR = new UsuariRegistrat();
        for (Object[] entity : entities) {
            uR.setUsername(entity[0].toString());
            uR.setPwd(entity[1].toString());
            uR.setNom(entity[2].toString());
            uR.setCognom(entity[3].toString());
                    }
        session.close();
        sessionFactory.close();
        return uR;

    }


}
