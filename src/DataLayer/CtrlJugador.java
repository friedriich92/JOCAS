package DataLayer;

import DomainLayer.DomainModel.Categoria;
import DomainLayer.DomainModel.Jugador;
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
        
        String query = "SELECT * FROM Jugador WHERE username = " + nomUsuari;
        return Session.createSQLQuery(query).addEntity(Jugador.class);
    }
    
    @Override
    public void aturarPartidaActual(String nomUsuari) {
        
        
    }

}
