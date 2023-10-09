package com.training.petru.jsonParser;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.IOException;
import java.util.EmptyStackException;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Collages {

    private List<Collage> collageList;

    @JsonIgnore
    public long getTotalStudents() throws IOException {

        long studentsCount = collageList.size();

        if(collageList == null){
            throw new EmptyStackException();
        }
        else if(collageList.size() == 0){
            throw new IOException();
        }


        String name = null;
        try {
            name = collageList.get(0).getLocation().getAddress().getName();

        } catch (EmptyException e) {
            throw new RuntimeException(e);
        }

        if(!name.contains("null")){
            studentsCount--;
        }

        Location loc = new Location("location", new Address("Auburn, AL"));

        try {
            System.out.println("Default Address" + loc.getAddress().getName());
        } catch (EmptyException e) {
            throw new RuntimeException(e);
        }

        return studentsCount;
    }

    @JsonIgnore
    public long getLocationName() {

        Location loc = null;
        try {
            loc = new Location("location", new Address("Auburn, AL"));
            loc.setAddress(new Address("mmmm"));
            System.out.println("Default Address: " + loc.getAddress().getName());
        } catch (EmptyException e) {
            throw new RuntimeException("This is working");
        }

        return loc.getName().length();
    }
    @AllArgsConstructor
    @Setter
    @Getter
    public static class Collage {

        private String name;
        private Location location;
        private List<Student> students;

        public Collage() {

        }
    }
}
