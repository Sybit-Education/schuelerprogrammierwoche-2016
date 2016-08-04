package com.sybit.education.taschengeldboerse.controller;

import com.sybit.education.taschengeldboerse.domain.*;
import com.sybit.education.taschengeldboerse.service.JobbewerbungService;
import com.sybit.education.taschengeldboerse.service.JobsService;
import com.sybit.education.taschengeldboerse.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
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
public class JobController {

    private static final Logger LOGGER = LoggerFactory.getLogger(JobController.class);

    @Autowired
    private JobsService jobService;
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private JobbewerbungService bewerbungService;

    /**
     * Listet für die Schüler alle offenen Jobs auf.
     *
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = "/schueler/jobs", method = RequestMethod.GET)
    public ModelAndView jobList(final Model model, final HttpServletRequest request) {
        LOGGER.debug("jobList ---->");

        //TODO Liste der Jobs über den Service holen
 
        List jobList = jobService.getFreeJobs();
        
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("jobList", jobList );
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
        
        
        List jobList = jobService.getFreeJobs();
        
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("jobList", jobList);
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
        Schueler schueler = userService.getSchuelerByEmail(request.getRemoteUser());
        Jobbewerbung bewerbung = bewerbungService.findByJobidAndSchuelerid(job.getId(), schueler.getId());
        
        if(bewerbung == null) {
            if(job != null) {
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
        
        modelAndView.addObject("redirect", request.getContextPath() + "/schueler/jobs/detail/"+id);
        
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
    public ModelAndView getJobSchuelerDetail(@PathVariable("id") final Integer id, final Model model, final HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();

        Job job = jobService.findById(id);
        Schueler schueler = userService.getSchuelerByEmail(request.getRemoteUser());
        Jobbewerbung bewerbung = bewerbungService.findByJobidAndSchuelerid(job.getId(), schueler.getId());
        
        boolean canRequest = false;
        
        if(bewerbung == null) {
            canRequest = true;
        }
        
        modelAndView.addObject("job", job);
        modelAndView.addObject("canRequest", canRequest);
        modelAndView.setViewName("job-detail");

        return modelAndView;

    }
    
    @RequestMapping(value = "/schueler/offene-job-anfragen", method = RequestMethod.GET)
    public ModelAndView openOfferList(final Model model, final HttpServletRequest request) {
        LOGGER.debug("jobList ---->");

        //TODO Liste der Jobs über den Service holen
        //Status: OPEN
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("job-liste-offene-anfragen");

        LOGGER.debug("jobList <------");
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
    @RequestMapping(value = "/anbieter/jobs/detail/{id}", method = RequestMethod.GET)
    public ModelAndView getJobAnbieterDetail(@PathVariable("id") final Integer id, final Model model, final HttpServletRequest request) {
        Job job = jobService.findById(id);
        
        
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("job", job);

        modelAndView.setViewName("job-detail");

        return modelAndView;

    }
    
    /**
     * Ruft Seite für das Anlegen eines neuen Jobs auf.
     * 
     * @param request
     * @return 
     */
    @RequestMapping(value = "/anbieter/jobs/neu", method = RequestMethod.GET)
    public ModelAndView jobFormular(final HttpServletRequest request) {
        
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("job", new Job());

        modelAndView.setViewName("job-neu");

        return modelAndView;
    }

    /**
     * Speichert einen neuen Job.
     * 
     * @param job 
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = "/anbieter/jobs/neu", method = RequestMethod.POST)
    public ModelAndView saveForm(@ModelAttribute("job") Job job, final Model model, final HttpServletRequest request) {
        LOGGER.debug("Jobbezeichnung: " + request.getParameter("bezeichnung"));

        User user = userService.getUserByEmail(request.getRemoteUser());
        job.setBezeichnung(request.getParameter("bezeichnung"));
        job.setAnbieter(userService.getAnbieterByEmail(user.getEmail()).getId());
        job.setAnforderungen(request.getParameter("anforderungen"));
        job.setDatum(request.getParameter("DOBDay") + "." + request.getParameter("DOBMonth") + "." + request.getParameter("DOBYear"));
        job.setEntlohnung(request.getParameter("entlohnung"));
        job.setZeitaufwand(request.getParameter("zeitaufwand"));
        job.setUhrzeit(request.getParameter("uhrzeit"));
        job.setZusaetzliche_infos(request.getParameter("zusaetzliche_infos"));
        
        job.setTurnus(Boolean.parseBoolean(request.getParameter("turnus")));     
        
        Job result = jobService.addJob(job);
        
        ModelAndView modelAndView = new ModelAndView();
        
        if(result != null) {
            modelAndView.addObject("job", result);
        }
        
        String msg = "Speichern fehlgeschlagen";
        
        if(result != null) {
            msg ="Job erfolgreich gespeichert.";
        }
        
        modelAndView.addObject("message", msg);
        modelAndView.setViewName("job-neu");

        return modelAndView;
    }

    /**
     * Zeigt dem Anbieter seine Job mit den Bewerbungen
     * 
     * @param request
     * @return 
     */
    @RequestMapping(value = "/anbieter/bewerbungen", method = RequestMethod.GET)
    public ModelAndView meineJobs(final HttpServletRequest request) {
        
        Anbieter anbieter = userService.getAnbieterByEmail(request.getRemoteUser());

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("jobs", jobService.getFreeJobsOfAnbieter(anbieter));

        modelAndView.setViewName("anbieter-bewerbungen");

        return modelAndView;
    }
    
    /**
     * Der Anbieter Akzeptiert Bewerbungen auf seine Jobs
     * TODO: Bewerbugen akzeptieren
     * @param request
     * @return 
     */
    @RequestMapping(value = "/anbieter/bewerbungen", method = RequestMethod.POST)
    public ModelAndView meineJobsAccept(final HttpServletRequest request) {
        Anbieter anbieter = userService.getAnbieterByEmail(request.getRemoteUser());

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("jobs", jobService.getFreeJobsOfAnbieter(anbieter));

        modelAndView.setViewName("anbieter-bewerbungen");
        
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

        //TODO Liste der Jobs über den Service holen
        //Status: ACCEPTED
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("job-liste-angenommene-anfragen");     
        
        LOGGER.debug("jobList <------");
        return modelAndView;
    }
    
    public JobsService getJobService() {
        return jobService;
    }

    public void setJobService(JobsService jobService) {
        this.jobService = jobService;
    }
}
