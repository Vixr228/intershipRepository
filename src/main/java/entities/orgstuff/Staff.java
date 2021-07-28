package entities.orgstuff;

import utils.Randomizer;

import java.util.UUID;

public abstract class Staff {

    private UUID id;

    Randomizer rand = new Randomizer();

    public Staff(){
        this.id = rand.randomId();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
