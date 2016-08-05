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
import org.springframework.web.client.HttpClientErrorException;

/**
 * Handles requests for the application home page.
 */
@Controller
public class AnbieterJobController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AnbieterJobController.class);

    @Autowired
    private JobsService jobService;

    @Autowired
    private UserService userService;

    @Autowired
    private JobbewerbungService bewerbungService;

    /**
     * Zeigt die Details für den Job mit der gegebenen ID an.
     *
     * @param id des jobs
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = "/anbieter/jobs/detail/{id}", method = RequestMethod.GET)
    public ModelAndView getJobDetail(@PathVariable("id") final Integer id, final Model model, final HttpServletRequest request) {

        ModelAndView modelAndView = new ModelAndView();

        Anbieter anbieter = getAnbieter(request);

        Job job = jobService.findById(id);

        if (job != null && job.getAnbieter().equals(anbieter.getId())) {

            modelAndView.addObject("job", job);

            modelAndView.setViewName("job-detail");
        } else {
            //den Job gibt es nicht oder gehört nicht dem Anbieter!
            modelAndView.setViewName("home");
        }

        return modelAndView;

    }

    /**
     * Ruft Seite für das Anlegen eines neuen Jobs auf.
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/anbieter/jobs/neu", method = RequestMethod.GET)
    public ModelAndView getJobNeu(final HttpServletRequest request) {

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
    public ModelAndView saveJob(@ModelAttribute("job") Job job, final Model model, final HttpServletRequest request) {
        LOGGER.debug("Jobbezeichnung: " + request.getParameter("bezeichnung"));

        Anbieter anbieter = getAnbieter(request);

        job.setBezeichnung(request.getParameter("bezeichnung"));
        job.setAnbieter(anbieter.getId());
        job.setAnforderungen(request.getParameter("anforderungen"));
        job.setDatum(request.getParameter("DOBDay") + "." + request.getParameter("DOBMonth") + "." + request.getParameter("DOBYear"));
        job.setEntlohnung(request.getParameter("entlohnung"));
        job.setZeitaufwand(request.getParameter("zeitaufwand"));
        job.setUhrzeit(request.getParameter("uhrzeit"));
        job.setZusaetzliche_infos(request.getParameter("zusaetzliche_infos"));

        job.setTurnus(Boolean.parseBoolean(request.getParameter("turnus")));

        Job result = jobService.addJob(job);

        ModelAndView modelAndView = new ModelAndView();

        if (result != null) {
            modelAndView.addObject("job", result);
        }

        String msg = "Speichern fehlgeschlagen";

        if (result != null) {
            msg = "Job erfolgreich gespeichert.";
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
    @RequestMapping(value = "/anbieter/jobs", method = RequestMethod.GET)
    public ModelAndView getJobListOpen(final HttpServletRequest request) {

        Anbieter anbieter = getAnbieter(request);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("jobs", jobService.getFreeJobsOfAnbieter(anbieter));
        modelAndView.addObject("seitenTitel", "Meine offenen Jobs");

        modelAndView.setViewName("anbieter-bewerbungen");

        return modelAndView;
    }
    
    /**
     * Zeigt dem Anbieter seine Job mit den Bewerbungen
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/anbieter/bewerbungen", method = RequestMethod.GET)
    public ModelAndView getJobListBewerbungen(final HttpServletRequest request) {

        Anbieter anbieter = getAnbieter(request);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("jobs", jobService.getFreeJobsOfAnbieter(anbieter));
        modelAndView.addObject("seitenTitel", "Meine offenen Jobs");

        modelAndView.setViewName("anbieter-bewerbungen");

        return modelAndView;
    }

    /**
     * Der Anbieter Akzeptiert Bewerbungen auf seine Jobs TODO: Bewerbugen
     * akzeptieren
     *
     * @param jobId
     * @param schuerlerId
     * @param request
     * @return
     */
    @RequestMapping(value = "/anbieter/bewerbungen/{jobId}/{schuelrId}", method = RequestMethod.POST)
    public ModelAndView acceptJobRequest(@PathVariable("jobId") Integer jobId, @PathVariable("schuelerId") Integer schuerlerId, final HttpServletRequest request) {
        
        //der eingeloggte Anbieter
        Anbieter anbieter = getAnbieter(request);
        
        //ausgewählter Job
        Job job = jobService.findById(jobId);

        //Was wird nun angezeigt? die offenen Jobs?
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("jobs", jobService.getFreeJobsOfAnbieter(anbieter));
        jobService.bewerbungAnnehmen(jobId, schuerlerId);
        modelAndView.addObject("seitenTitel", "Meine offenen Jobs");

        modelAndView.setViewName("anbieter-bewerbungen");

        return modelAndView;
    }

    /**
     * Anbieter anhand des request objets auslesen.
     *
     * @param request
     * @return
     */
    private Anbieter getAnbieter(final HttpServletRequest request) {
        User user = userService.getUserByEmail(request.getRemoteUser());
        Anbieter anbieter = userService.getAnbieterByEmail(user.getEmail());
        return anbieter;
    }

    public JobsService getJobService() {
        return jobService;
    }

    public void setJobService(JobsService jobService) {
        this.jobService = jobService;
    }
}
