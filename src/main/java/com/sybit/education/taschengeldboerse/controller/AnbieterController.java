package com.sybit.education.taschengeldboerse.controller;

import com.sybit.education.taschengeldboerse.domain.Anbieter;
import com.sybit.education.taschengeldboerse.domain.User;
import com.sybit.education.taschengeldboerse.model.AnbieterForm;
import com.sybit.education.taschengeldboerse.service.AnbieterService;
import com.sybit.education.taschengeldboerse.service.SchuelerService;
import com.sybit.education.taschengeldboerse.service.UserService;
import org.hibernate.exception.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Handles requests for the application home page.
 */
@Controller
public class AnbieterController {

    private static final Logger logger = LoggerFactory.getLogger(AnbieterController.class);

    @Autowired
    private UserService userService;
    
    @Autowired
    private AnbieterService anbieterService;

    /**
     * Simply selects the home view to render by returning its name.
     *
     * @param request needed to get the referring url
     * @return the logical view to be returned
     */
    @RequestMapping(value = "/registrieren/anbieter", method = RequestMethod.GET)
    public ModelAndView registrierenFormular(final HttpServletRequest request) {

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("registrieren-anbieter");
        modelAndView.addObject("anbieter", new AnbieterForm());
        return modelAndView;
    }

    /**
     * Speichere neuen Anbieter.
     *
     * @param anbieterForm
     * @param request
     * @return the logical view to be returned
     */
    @RequestMapping(value = "/registrieren/anbieter", method = RequestMethod.POST)
    public ModelAndView saveForm(@ModelAttribute("anbieter") AnbieterForm anbieterForm, HttpServletRequest request) {

        ModelAndView modelAndView = new ModelAndView();

        try {
            User newUser = new User(anbieterForm.getEmail(), anbieterForm.getPassword());
            newUser.setAuthority("ROLE_ANBIETER");

            newUser = userService.addUser(newUser);

            Anbieter newAnbieter = new Anbieter(newUser);
            newAnbieter.setAnrede(anbieterForm.getAnrede());
            newAnbieter.setVorname(anbieterForm.getVorname());
            newAnbieter.setName(anbieterForm.getName());
            newAnbieter.setStrasse(anbieterForm.getStrasse());
            newAnbieter.setWohnort(anbieterForm.getWohnort());
            newAnbieter.setPlz(anbieterForm.getPlz());
            newAnbieter.setTelefon(anbieterForm.getTelefon());

            userService.saveAnbieter(newAnbieter);
            modelAndView.addObject("addSuccsess", true);
            modelAndView.setViewName("registrieren-anbieter");
            modelAndView.addObject("redirect", request.getContextPath());

        } catch (IllegalArgumentException e) {
            modelAndView.addObject("addEmailFail", true);
            modelAndView.addObject("emailMessage", e.getMessage());
            modelAndView.setViewName("registrieren-anbieter");

        } catch (ConstraintViolationException e) {
            modelAndView.addObject("addFail", true);
            modelAndView.addObject("anbieter", anbieterForm);
            modelAndView.setViewName("registrieren-anbieter");
        }

        return modelAndView;
    }
    
    @RequestMapping(value = "anbieter/profil", method = RequestMethod.GET)
    public ModelAndView anbieterProfil(@RequestParam("id") Integer anbieterId) {
        ModelAndView modelAndView =  new ModelAndView("anbieter-detail");
        modelAndView.addObject("anbieter", anbieterService.findAnbieterById(anbieterId));

        return modelAndView;
    }
}
