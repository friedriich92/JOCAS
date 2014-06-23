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
       SQLQuery q = session.createSQLQuery(query);
       List<Object[]> entities = q.list();
       Partida p = new Partida();
       for (Object[] entity : entities) {
           p.setIdPartida(Integer.parseInt(entity[0].toString()));
           boolean b;
           if (Integer.parseInt(entity[1].toString()) == 1) b = true;
           else b = false;
           p.setAcabada(b);
           if (Integer.parseInt(entity[2].toString()) == 1) b = true;
           else b = false;
           p.setGuanyada(b);
           p.setErrors(Integer.parseInt(entity[3].toString()));
           
           CtrlJugador cJ = new CtrlJugador();
           Jugador j = cJ.obteJugador(entity[4].toString());
           p.setJugador(j);
           
           CtrlParaula cP = new CtrlParaula();
           Paraula p2 = cP.getParaula(entity[5].toString());
           
           p.setTeParaula(p2);
       }
       session.close();
       sessionFactory.close();
       return p;
    }
    

    
    /*
    @Override
    public int[] crearPartida(Jugador jug, Paraula par) {
        return null;   
    }
    */
}
