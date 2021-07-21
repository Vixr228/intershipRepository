package Entities;

import java.util.UUID;

public abstract class Staff {

    private UUID id;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
