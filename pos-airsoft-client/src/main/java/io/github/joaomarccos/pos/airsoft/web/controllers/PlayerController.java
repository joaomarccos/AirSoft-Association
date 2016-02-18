package io.github.joaomarccos.pos.airsoft.web.controllers;

import io.github.joaomarccos.pos.airsoft.entitys.Player;
import io.github.joaomarccos.pos.airsoft.web.facade.ServiceFacade;
import javax.inject.Inject;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author João Marcos <joaomarccos.github.io>
 */
@Controller
@RequestMapping("/player")
public class PlayerController {

    @Inject
    private ServiceFacade serviceFacade;

    @RequestMapping("/new")
    public @ResponseBody
    String newPlayer(String name, String email, String phone) {
        Player savedPlayer = serviceFacade.getPlayerManagerService().registerNewPlayer(name, email, phone);
        if (savedPlayer == null) {
            return "" + HttpStatus.NOT_ACCEPTABLE;
        }
        return "" + HttpStatus.OK;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index() {
        return "newPlayer";
    }
}
