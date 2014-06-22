package DataLayer;

import DomainLayer.DomainModel.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;


/**
 * Created by joanbarroso on 14/06/14.
 */
public class CtrlPartida implements DomainLayer.DataInterface.CtrlPartida {
    @Override
    public Partida getPartida(int idP) {
        
       //creacion de la Session (?)
        
       SessionFactory sessionFactory;
       Session session;
       Configuration configuration = new Configuration();
       configuration.configure();
       ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
       sessionFactory = configuration.buildSessionFactory(serviceRegistry);
       session = sessionFactory.openSession();
        
        String query = "SELECT * FROM Partida WHERE idPartida = " + idP;
        return session.createSQLQuery(query).addEntity(Partida.class);
    }
    
    @Override
    public int[] ferJugada(int idP, int pos, String lletra) {
        return new int[]{0,1,2,3,4};
    }
    
    @Override
    public int[] crearPartida(Jugador jug, Paraula par) {
        return null;   
    }
}
