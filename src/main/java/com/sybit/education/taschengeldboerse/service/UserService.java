package com.sybit.education.taschengeldboerse.service;


import com.sybit.education.taschengeldboerse.domain.Anbieter;
import com.sybit.education.taschengeldboerse.domain.Schueler;
import com.sybit.education.taschengeldboerse.domain.User;
import java.util.List;

/**
 * Created by stl on 15.06.2015.
 */
public interface UserService {

    List<User> getAllUser();

    User getUserByEmail(String email);
    
    Anbieter getAnbieterByEmail(String email);

    Schueler getSchuelerByEmail(String email);
    
    User addUser(User user);

    User updateAuthority(User user);
    
    Schueler saveSchueler(Schueler schueler);
    
    Anbieter saveAnbieter(Anbieter anbieter);

    public Schueler getSchuelerByEmail(String username);

}
