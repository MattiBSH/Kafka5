package com.example.consumer;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CachedEntity {
    private int entityId;
    private String name;
    private String msg;

    public CachedEntity(@JsonProperty("entityId") int entityId, @JsonProperty("name") String name,@JsonProperty("entityId") String msg){
        this.entityId = entityId;
        this.name = name;
        this.msg = msg;

    }
    @Override
    public String toString() {
        return String.format("Cached Entity with id %d", entityId);
    }
}