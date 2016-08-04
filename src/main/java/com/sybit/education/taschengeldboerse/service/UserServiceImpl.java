package com.sybit.education.taschengeldboerse.service;

import com.sybit.education.taschengeldboerse.domain.Anbieter;
import com.sybit.education.taschengeldboerse.domain.Schueler;
import com.sybit.education.taschengeldboerse.domain.User;
import com.sybit.education.taschengeldboerse.repository.AnbieterRepository;
import com.sybit.education.taschengeldboerse.repository.SchuelerRepository;
import com.sybit.education.taschengeldboerse.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service für die Benutzerverwaltung.
 */
@Service
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SchuelerRepository schuelerRepository;

    @Autowired
    private AnbieterRepository anbieterRepository;

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    /**
     * Benutzer anhand der E-Mail suchen und laden.
     *
     * @param email
     * @return unique user
     */
    @Override
    public User getUserByEmail(String email) {
        List<User> users = userRepository.findByEmail(email);

        if (users.size() > 0) {
            return users.get(0);
        } else {
            return null;
        }
    }

    /**
     * Neuen Benutzer speichern.
     *
     * @param user
     * @return 
     */
    @Override
    public User addUser(User user) {
        
        if (getUserByEmail(user.getEmail()) != null) {
            throw new IllegalArgumentException("Die E-Mail ist schon vergeben.");
        }
        /*
        if (user.getEmail().length() < 5) {
            throw new IllegalArgumentException("Die E-Mail ist zu kurz.");
        }
        
        if (!user.getEmail().contains("@") && (!user.getEmail().contains("."))) {
            throw new IllegalArgumentException("Unbekannte E-Mail.");
        }
        */
        if (user.getAuthority() == null) {
            user.setAuthority("unknown");
            user.setEnabled(false);
        }
        userRepository.save(user);

        return user;
    }

    @Override
    public User updateAuthority(User user) {

        if (user.getEmail() == null) {
            throw new IllegalArgumentException("E-Mail muss gesetzt sein!");
        }

        User currentUser = getUserByEmail(user.getEmail());
        currentUser.setAuthority(user.getAuthority());
        userRepository.save(currentUser);

        return currentUser;
    }

    @Override
    public Schueler saveSchueler(Schueler schueler) {

        schueler = schuelerRepository.save(schueler);
        
        //jetzt benutzer aktivieren, wenn alles geklappt hat
        User user = getUserByEmail(schueler.getEmail());        
        user.setEnabled(true);
        userRepository.save(user);
        
        
        return schueler;
    }

    @Override
    public Anbieter getAnbieterByEmail(String emailadresse) {
        List<Anbieter> anbieter = anbieterRepository.findByEmail(emailadresse);

        if (anbieter.size() > 0) {
            return anbieter.get(0);
        } else {
            return null;
        }
    }

    @Override
    public Schueler getSchuelerByEmail(String emailadresse) {
        return schuelerRepository.findByEmail(emailadresse);
    }

    @Override
    public Anbieter saveAnbieter(Anbieter anbieter) {
        anbieter = anbieterRepository.save(anbieter);
        
        //jetzt benutzer aktivieren, wenn alles geklappt hat
        User user = getUserByEmail(anbieter.getEmail());        
        user.setEnabled(true);       
        userRepository.save(user);
        
        return anbieter;
    }

}
