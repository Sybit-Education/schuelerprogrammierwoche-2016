package com.sybit.education.taschengeldboerse.controller;

import com.sybit.education.taschengeldboerse.domain.Job;
import com.sybit.education.taschengeldboerse.service.JobsService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class JobController {

    private static final Logger LOGGER = LoggerFactory.getLogger(JobController.class);

    @Autowired
    private JobsService jobService;

    /**
     * Liste für die Schüler alle offenen Jobs auf.
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
        Job job = jobService.findById(id);

        //TODO job mit der id laden.
        
        
        
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

        LOGGER.debug("Jobbezeichnung: " + job.getBezeichnung());

        //TODO neuen Job in der Datenbak abspeichern und wieder anzeigen.
        
        
        
        
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("job", job);
        modelAndView.setViewName("job-neu");

        return modelAndView;
    }

    
    public JobsService getJobService() {
        return jobService;
    }

    public void setJobService(JobsService jobService) {
        this.jobService = jobService;
    }
}
