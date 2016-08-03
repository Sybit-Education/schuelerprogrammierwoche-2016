package com.sybit.education.taschengeldboerse.controller;

import com.sybit.education.taschengeldboerse.domain.Schueler;
import com.sybit.education.taschengeldboerse.domain.User;
import com.sybit.education.taschengeldboerse.model.SchuelerForm;
import com.sybit.education.taschengeldboerse.service.UserService;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class SchuelerController {
    
    @Autowired
    private UserService userService;



    /**
     * Lade das Formular für die Anlage eines Schülers.
     *
     * @param request needed to get the referring url
     * @return the logical view to be returned
     */
    @RequestMapping(value = "/registrieren/schueler", method = RequestMethod.GET)
    public ModelAndView registrierenFormular(final HttpServletRequest request) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("schuelerForm", new SchuelerForm());

        modelAndView.setViewName("registrieren-schueler");

        return modelAndView;
    }

    /**
     * Speichere neuen Schüler.
     *
     * @param schuelerForm
     * @param result
     * @return the logical view to be returned
     */
    @RequestMapping(value = "/registrieren/schueler", method = RequestMethod.POST)
    public ModelAndView saveForm(@Valid SchuelerForm schuelerForm, BindingResult result) {

        ModelAndView modelAndView = new ModelAndView();
        if (!result.hasErrors()) {
            
            User user = new User();
            user.setEmail(schuelerForm.getEmail());
            user.setPassword(schuelerForm.getPassword()); //TODO: Überprüfung einbauen
            user.setAuthority("ROLE_SCHUELER");
            userService.addUser(user);
            
            Schueler schueler = new Schueler();
            schueler.setAnrede(schuelerForm.getAnrede());
            schueler.setName(schuelerForm.getName());
            schueler.setVorname(schuelerForm.getVorname());
            schueler.setEmail(schuelerForm.getEmail());
            schueler.setGeburtsdatum(schuelerForm.getDOBDay() + "." + schuelerForm.getDOBMonth() + "." + schuelerForm.getDOBYear());
            schueler.setPlz(schuelerForm.getPlz());
            schueler.setWohnort(schuelerForm.getWohnort());
            userService.saveSchueler(schueler);

        }
        modelAndView.addObject("schuelerForm", schuelerForm);
        modelAndView.addObject("result", result);

        modelAndView.setViewName("registrieren-schueler");

        return modelAndView;
    }
}
