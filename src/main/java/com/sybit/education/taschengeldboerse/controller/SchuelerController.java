package com.sybit.education.taschengeldboerse.controller;

import com.sybit.education.taschengeldboerse.domain.Schueler;
import com.sybit.education.taschengeldboerse.domain.User;
import com.sybit.education.taschengeldboerse.model.SchuelerForm;
import com.sybit.education.taschengeldboerse.service.SchuelerService;
import com.sybit.education.taschengeldboerse.service.UserService;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Handles requests for the application home page.
 */
@Controller
public class SchuelerController {

    @Autowired
    private UserService userService;

    @Autowired
    private SchuelerService schuelerService;

    public static final String ROOT = "upload-dir";


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
     * @return the logical view to be returned
     */
    @RequestMapping(value = "/registrieren/schueler", method = RequestMethod.POST)
    public ModelAndView saveForm(@ModelAttribute("schueler") SchuelerForm schuelerForm, final HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        try {

            User user = new User();
            user.setEmail(schuelerForm.getEmail());
            user.setPassword(schuelerForm.getPassword()); //TODO: Überprüfung einbauen
            user.setAuthority("ROLE_SCHUELER");
            user.setEnabled(true);
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
            
            modelAndView.addObject("addSuccess", true);
            modelAndView.setViewName("registrieren-schueler");
            modelAndView.addObject("redirect", request.getContextPath() + "/login");
            
        } catch (IllegalArgumentException e) {
                modelAndView.addObject("addEmailFail", true);
                modelAndView.addObject("emailMessage", e.getMessage());
                modelAndView.setViewName("registrieren-schueler");
        } catch (ConstraintViolationException e) {
            modelAndView.addObject("schueler", schuelerForm);
            modelAndView.addObject("addFail", true);
            modelAndView.setViewName("registrieren-schueler");
        } 
        
        return modelAndView;
    }

    @RequestMapping(value = "schueler/profil", method = RequestMethod.GET)
    public ModelAndView schuelerProfil(@RequestParam("id") Integer schuelerId) {
        ModelAndView modelAndView =  new ModelAndView("schueler-detail");
        modelAndView.addObject("schueler", schuelerService.findSchuelerById(schuelerId));
        modelAndView.addObject("isUser", false);
        return modelAndView;
    }

    @RequestMapping(value = "schueler/profil/nav", method = RequestMethod.GET)
    public ModelAndView schuelerProfil(@RequestParam("username") String email) {
        ModelAndView modelAndView =  new ModelAndView("schueler-detail");
        modelAndView.addObject("schueler", userService.getSchuelerByEmail(email));
        modelAndView.addObject("isUser", true);
        return modelAndView;
    }

    @RequestMapping(value = "/schueler/profil/bearbeitet", method = RequestMethod.POST)
    public ModelAndView saveSchuelerProfil(@ModelAttribute("job") Schueler schueler, final Model model, final HttpServletRequest request) {
        schuelerService.updateSchueler(schueler);
        ModelAndView modelAndView =  new ModelAndView("schueler-detail");
        modelAndView.addObject("schueler", schuelerService.findSchuelerById(schueler.getId()));
        modelAndView.addObject("isUser", true);
        return modelAndView;
    }
}

