package com.training.petru.jsonParser;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Setter
@Getter
public class Location {


    @NonNull
    private String name;

    @NonNull
    private Address address;

    public Address getAddress() throws EmptyException {
        if(address.getName() == null || address.getName().length() < 1)
            throw new EmptyException();

        return address;
    }

    public void setAddress(Address address) throws EmptyException {
        if(address.getName() == null || address.getName().contains("a"))
            throw new EmptyException();

        this.address = address;
    }
}
