package com.tfr.scli.controller;

import com.tfr.scli.config.Routes;
import com.tfr.scli.config.Views;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Erik on 8/30/2016.
 */

@Controller
public class HomeController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value= Routes.INDEX)
    @ResponseStatus(HttpStatus.OK)
    public String index() {
        logger.debug("hitting endpoint: " + Routes.INDEX);
        return Views.INDEX;
    }


}
