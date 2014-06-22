package DomainLayer.ServiceLocator;

public class ServiceLocator {
    private static ServiceLocator instance;
    
    public ServiceLocator getInstance() {
        if (instance == null)
            instance = new ServiceLocator();
        return instance;
    }
    
    public Object find(String serviceName) {
        switch(serviceName) {
            case "ServeiMissatgeria":
                return new ServeiMissatgeriaStub();
        }
        return null;
    }
   
}
