package com.emissystem.www.home.model;

import java.util.*;
import java.util.stream.*;

public class UserDao {
    private User defaultUser = new User("default@gmail.com","$2a$10$h.dl5J86rGH7I8bD9bZeZe","password",9999, "Default", "ADM");

    private List<User> users = Arrays.asList(
            new User("p0@gmail.com","$2a$10$h.dl5J86rGH7I8bD9bZeZe","password",1000, "Jon Paul", "PAT"),
            new User("p1@gmail.com","$2a$10$h.dl5J86rGH7I8bD9bZeZe","password",1001,"Yu Testa","PAT"),
            new User("p2@gmail.com","$2a$10$h.dl5J86rGH7I8bD9bZeZe","password",1002,"Medicine Man","PAT"),
            new User("p3@gmail.com","$2a$10$h.dl5J86rGH7I8bD9bZeZe","password",1003,"Gabriel Sotelo-Rosa","PAT"),
            new User("p4@gmail.com","$2a$10$h.dl5J86rGH7I8bD9bZeZe","password",1004,"Forrest Gump","PAT"),
            new User("p5@gmail.com","$2a$10$h.dl5J86rGH7I8bD9bZeZe","password",1005,"Captain Sparrow","PAT"),
            new User("p6@gmail.com","$2a$10$h.dl5J86rGH7I8bD9bZeZe","password",1006,"Chase Bool","PAT"),
            new User("p7@gmail.com","$2a$10$h.dl5J86rGH7I8bD9bZeZe","password",1007,"Sarah Connor","PAT"),
            new User("p8@gmail.com","$2a$10$h.dl5J86rGH7I8bD9bZeZe","password",1008,"Ashley Smith","PAT"),
            new User("p9@gmail.com","$2a$10$h.dl5J86rGH7I8bD9bZeZe","password",1009,"Tristan Scallion","PAT"),
            new User("r0@gmail.com","$2a$10$h.dl5J86rGH7I8bD9bZeZe","password",2000,"America","REC"),
            new User("r1@gmail.com","$2a$10$h.dl5J86rGH7I8bD9bZeZe","password",2000,"Triston Zamboni","REC"),
            new User("n0@gmail.com","$2a$10$h.dl5J86rGH7I8bD9bZeZe","password",3000,"Alldos Ramires","NUR"),
            new User("n1@gmail.com","$2a$10$h.dl5J86rGH7I8bD9bZeZe","password",3000,"Grace McGraceFace","NUR"),
            new User("d0@gmail.com","$2a$10$h.dl5J86rGH7I8bD9bZeZe","password",4001,"Doctor Mann","DOC"),
            new User("d1@gmail.com","$2a$10$h.dl5J86rGH7I8bD9bZeZe","password",4002,"James Paceface","DOC"),
            new User("d2@gmail.com","$2a$10$h.dl5J86rGH7I8bD9bZeZe","password",4003,"Captain America","DOC"),
            new User("d3@gmail.com","$2a$10$h.dl5J86rGH7I8bD9bZeZe","password",4004,"Clown Reject","DOC"),
            new User("d4@gmail.com","$2a$10$h.dl5J86rGH7I8bD9bZeZe","password",4005,"Nohta Narc","DOC"),
            new User("d5@gmail.com","$2a$10$h.dl5J86rGH7I8bD9bZeZe","password",4006,"Serial Kaller","DOC"),
            new User("d6@gmail.com","$2a$10$h.dl5J86rGH7I8bD9bZeZe","password",4007,"Nota Liecensed","DOC"),
            new User("d7@gmail.com","$2a$10$h.dl5J86rGH7I8bD9bZeZe","password",4008,"Doctoral Immunuh","DOC")
            );

    public User getUserByUsername(String email) {
        return users.stream().filter(b -> b.getEMAIL().equals(email)).findFirst().orElse(defaultUser);
    }

    public User getUserByUID(int UID) {
        return users.stream().filter(b -> (b.getUID() == UID)).findFirst().orElse(defaultUser);
    }

    public Iterable<String> getAllNames() {
        return users.stream().map(User::getNAME).collect(Collectors.toList());
    }

    public Iterable<Integer> getAllUID() {
        return users.stream().map(User::getUID).collect(Collectors.toList());
    }

}
