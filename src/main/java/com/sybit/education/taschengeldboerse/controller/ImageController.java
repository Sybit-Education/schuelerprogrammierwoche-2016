package com.sybit.education.taschengeldboerse.controller;

import com.sybit.education.taschengeldboerse.domain.Schueler;
import com.sybit.education.taschengeldboerse.service.SchuelerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

/**
 * Created by kkr on 04.08.2016.
 */
@Controller
public class ImageController {

    @Autowired
    SchuelerService schuelerService;

    @ResponseBody
    @RequestMapping(value = "schueler/profil/image", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] getProfilImage(@RequestParam("id") Integer id) throws IOException {
        Schueler schueler = schuelerService.findSchuelerById(id);
        return schueler.getImage();
    }
}
