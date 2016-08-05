package com.sybit.education.taschengeldboerse.controller;

import com.sybit.education.taschengeldboerse.domain.*;
import com.sybit.education.taschengeldboerse.service.JobbewerbungService;
import com.sybit.education.taschengeldboerse.service.JobsService;
import com.sybit.education.taschengeldboerse.service.SchuelerService;
import com.sybit.education.taschengeldboerse.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Handles requests for the application home page.
 */
@Controller
public class SchuelerJobController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SchuelerJobController.class);

    @Autowired
    private JobsService jobService;

    @Autowired
    private UserService userService;

    @Autowired
    private JobbewerbungService bewerbungService;
    
    @Autowired
    private SchuelerService schuelerService;

    /**
     * Listet für die Schüler alle offenen Jobs auf.
     *
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = "/schueler/jobs", method = RequestMethod.GET)
    public ModelAndView getJobListFree(final Model model, final HttpServletRequest request) {
        LOGGER.debug("jobList ---->");

        //TODO Liste der Jobs über den Service holen
        List jobList = jobService.getFreeJobs();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("jobList", jobList);
        modelAndView.addObject("seitenTitel", "Verfügbare Jobs");
        modelAndView.setViewName("job-liste");

        LOGGER.debug("jobList <------");
        return modelAndView;
    }

    /*//NOTE: Duplikat?!
    @RequestMapping(value = "/schueler/jobs/{id}/bewerben", method = RequestMethod.GET)
    public ModelAndView jobBewerben(final HttpServletRequest request, @PathVariable("id") Integer jobId) {
        LOGGER.debug("job-liste -----> job id=" + jobId);
        
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();

        //bewerben...
        jobService.bewerben(username, jobId);
        
        
        List getSchuelerJobListFree = jobService.getFreeJobs();
        
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("getSchuelerJobListFree", getSchuelerJobListFree);
        modelAndView.setViewName("job-liste");
        
        LOGGER.debug("job-liste <-----");
        return modelAndView;
    }*/
    /**
     * Speichert die Bewerbung ab.
     *
     * @param id des jobs
     * @param request
     * @return
     */
    @RequestMapping(value = "/schueler/jobs/{id}/bewerben", method = RequestMethod.GET)
    public ModelAndView sendRequestForJob(@PathVariable("id") final Integer id, final HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();

        Job job = jobService.findById(id);
        Schueler schueler = getSchueler(request);
        Jobbewerbung bewerbung = bewerbungService.findByJobidAndSchuelerid(job.getId(), schueler.getId());

        if (bewerbung == null) {
            if (job != null) {
                jobService.bewerben(request.getRemoteUser(), id);
                modelAndView.addObject("job", job);
                modelAndView.addObject("canRequest", false);
                modelAndView.addObject("message", "Deine Bewerbung wurde erfolgreich abgeschickt.");
            } else {
                modelAndView.addObject("message", "Deine Bewerbung konnte nicht abgeschickt werden.");
            }
        } else {
            modelAndView.addObject("job", job);
            modelAndView.addObject("canRequest", false);
            modelAndView.addObject("message", "Du hast dich auf diesen Job bereits beworben!");
        }

        modelAndView.addObject("redirect", request.getContextPath() + "/schueler/jobs/detail/" + id);

        modelAndView.setViewName("job-detail");
        return modelAndView;
    }

    /**
     * Zeigt die Details für den Job mit der gegebenen ID an.
     *
     * @param id des jobs
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = "/schueler/jobs/detail/{id}", method = RequestMethod.GET)
    public ModelAndView getJobDetail(@PathVariable("id") final Integer id, final Model model, final HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();

        Job job = jobService.findById(id);
        Schueler schueler = getSchueler(request);
        Jobbewerbung bewerbung = bewerbungService.findByJobidAndSchuelerid(job.getId(), schueler.getId());

        boolean canRequest = false;

        if (bewerbung == null) {
            canRequest = true;
        }

        modelAndView.addObject("job", job);
        modelAndView.addObject("canRequest", canRequest);
        modelAndView.setViewName("job-detail");

        return modelAndView;

    }

    @RequestMapping(value = "/schueler/offene-job-anfragen", method = RequestMethod.GET)
    public ModelAndView getJobListBeworben(final Model model, final HttpServletRequest request) {
        LOGGER.debug("jobList ---->");

        //TODO Liste der Jobs über den Service holen
        //Status: OPEN
        List<Jobbewerbung> offenebewerbungen = schuelerService.getPendingSchuelerJobs(userService.getSchuelerByEmail(request.getRemoteUser()).getId());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("seitenTitel", "Meine Bewerbungen");
        modelAndView.addObject("jobList", offenebewerbungen);
        modelAndView.setViewName("job-liste-offene-anfragen");
        

        LOGGER.debug("jobList <------");
        return modelAndView;
    }

  


    /* Listet für den Schüler seine angenommenen Jobs auf.
     *
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = "/schueler/angenommene-job-anfragen", method = RequestMethod.GET)
    public ModelAndView adoptedOfferList(final Model model, final HttpServletRequest request) {
        LOGGER.debug("jobList ---->");
        Schueler schueler = getSchueler(request);

        //TODO Liste der Jobs über den Service holen
        //Status: ACCEPTED
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("job-liste-angenommene-anfragen");

        LOGGER.debug("jobList <------");
        return modelAndView;
    }

    /**
     * Scuhueler anhand des request objets auslesen.
     *
     * @param request
     * @return
     */
    private Schueler getSchueler(final HttpServletRequest request) {
        User user = userService.getUserByEmail(request.getRemoteUser());
        Schueler schueler = userService.getSchuelerByEmail(user.getEmail());
        
        return schueler;
    }

    public JobsService getJobService() {
        return jobService;
    }

    public void setJobService(JobsService jobService) {
        this.jobService = jobService;
    }
}
