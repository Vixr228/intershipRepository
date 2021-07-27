package entities.orgstuff;

import java.util.UUID;

public abstract class Staff {

    private UUID id;

    public Staff(){
        this.id = UUID.randomUUID();
    }


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
