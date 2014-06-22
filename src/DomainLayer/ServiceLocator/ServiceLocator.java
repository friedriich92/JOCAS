package DomainLayer.ServiceLocator;

public class ServiceLocator {
    private static ServiceLocator instance;
    
    public ServiceLocator getInstance() {
        if (instance == null)
            instance = new ServiceLocator();
        return instance;
    }
   
}
