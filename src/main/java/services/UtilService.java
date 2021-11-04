package services;

import java.util.UUID;

public class UtilService {

    public String CreateId() {
        return UUID.randomUUID().toString();
    }

    public UtilService() {
    }
    
    
}
