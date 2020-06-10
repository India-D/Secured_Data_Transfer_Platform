package com.masterpiece.securedDataPlatform.dtos;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class DocumentViewDto {

    @NotEmpty
    @Size(max = 200)
    private String name;

    @NotEmpty
    @Size(max = 200)
    private String type;

    @NotNull
    @Positive
    private byte[] data;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
}
