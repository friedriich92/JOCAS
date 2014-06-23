package DataLayer;

import DomainLayer.DomainModel.Categoria;
import DomainLayer.DomainModel.Jugador;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Created by joanbarroso on 14/06/14.
 */

public class CtrlJugador implements DomainLayer.DataInterface.CtrlJugador{
    @Override
    public Jugador obteJugador(String nomUsuari) {
        
       //creacion de la Session (?)
        
       SessionFactory sessionFactory;
       Session session;
       Configuration configuration = new Configuration();
       configuration.configure();
       ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
       sessionFactory = configuration.buildSessionFactory(serviceRegistry);
       session = sessionFactory.openSession();
        
        String query = "SELECT * FROM UsuariRegistrat WHERE username = " + nomUsuari;
        SQLQuery q = session.createSQLQuery(query);
        List<Object[]> entities = q.list();
        Jugador j = new Jugador();
        for (Object[] entity : entities) {
            j.setUsername(entity[0].toString());
            j.setEmail(entity[1].toString());
            j.setNom(entity[2].toString());
            j.setCognom(entity[3].toSting());
        }
        session.close();
        sessionFactory.close();
        return j;
    }
    
    @Override
    public void aturarPartidaActual(String nomUsuari) {
        
        
    }

}
