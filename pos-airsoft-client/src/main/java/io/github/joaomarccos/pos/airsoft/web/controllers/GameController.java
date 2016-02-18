package io.github.joaomarccos.pos.airsoft.web.controllers;

import io.github.joaomarccos.pos.airsoft.entitys.Album;
import io.github.joaomarccos.pos.airsoft.entitys.Game;
import io.github.joaomarccos.pos.airsoft.entitys.Image;
import io.github.joaomarccos.pos.airsoft.provider.transferObject.ListOfGamesTO;
import io.github.joaomarccos.pos.airsoft.provider.transferObject.ListOfImagesTO;
import io.github.joaomarccos.pos.airsoft.web.facade.ServiceFacade;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

/**
 *
 * @author João Marcos <joaomarccos.github.io>
 */
@Controller
@RequestMapping("/game")
public class GameController {

    @Inject
    private ServiceFacade serviceFacade;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index() {
        return "newGame";
    }

    @RequestMapping("/new")
    public @ResponseBody
    String newGame(String goal, String plot, String mission, String site, String timeTable, MultipartFile thematicImage) {
        try {

            Game createdGame = serviceFacade.getGameManagerService().createNewGame(goal, plot, mission, site, timeTable, thematicImage.getBytes());
            if (createdGame == null) {
                return "" + HttpStatus.NOT_ACCEPTABLE;
            }
            return "" + HttpStatus.OK;
        } catch (Exception e) {
            java.util.logging.Logger.getLogger(GameController.class.getName()).log(Level.SEVERE, "Erro", e);
            return "" + HttpStatus.NOT_ACCEPTABLE;
        }
    }

    @RequestMapping("/confirm/{token}")
    public String confirm(@PathVariable("token") String token, HttpServletRequest request) {
        boolean result = serviceFacade.getGameConfirmService().confirmParticipation(token);
        request.setAttribute("confirmed", result ? "Sua participação foi confirmada!" : "Não foi possível confirmar sua participação!");
        return "index";
    }

    @RequestMapping("/cancel/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void cancelGame(@PathVariable("id") long id) {
        serviceFacade.getGameManagerService().cancelGame(id);
    }

    @RequestMapping("/finish/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void finishGame(@PathVariable("id") long id) {
        serviceFacade.getGameManagerService().finishGame(id);
    }

    @RequestMapping("/add/album")
    public String addAlbum(String name, long gameId, MultipartRequest files) {
        return null;
    }

    @RequestMapping("/games")
    public String gamePage() {
        return "gamePage";
    }

    @RequestMapping("/all")
    public String listAll(HttpServletRequest request) {
        ListOfGamesTO games = serviceFacade.getGamePageService().getGames();
        request.getSession().setAttribute("games", games.getGames());
        return "allGames";
    }

    @RequestMapping("/finished/page/{number}")
    public String listFinishedGames(@PathVariable("number") int page, HttpServletRequest request) {
        ListOfGamesTO games = serviceFacade.getGamePageService().getFinishedGames(page);
        if (games.getGames() != null) {
            request.setAttribute("currentPage", page);
            request.getSession().setAttribute("games", games.getGames());
        } else {
            request.setAttribute("currentPage", page - 1);
        }
        return "finishedGames";
    }

    @RequestMapping("/view/{id}")
    public String selectGame(@PathVariable("id") long id, HttpServletRequest request) {
        List<Game> games = (List<Game>) request.getSession().getAttribute("games");

        Game selected = null;
        for (Game game : games) {
            if (game.getId() == id) {
                selected = game;
            }
        }

        request.setAttribute("selected", selected);
        return "viewGameModal";
    }

    @RequestMapping(value = "/image/{id}", produces = {MediaType.IMAGE_GIF_VALUE, MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE})
    public void getImage(@PathVariable("id") long id, HttpServletRequest request, HttpServletResponse response) {
        List<Game> games = (List<Game>) request.getSession().getAttribute("games");
        for (Game game : games) {
            if (game.getId() == id) {
                try {
                    OutputStream out = response.getOutputStream();
                    out.write(game.getThematicImage());
                    out.flush();
                } catch (IOException ex) {
                    java.util.logging.Logger.getLogger(GameController.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
    }

    @RequestMapping("/album/send")
    public @ResponseBody
    String addAlbum(long gameId, String name, MultipartRequest request) {
        List<Image> images = new ArrayList<>();
        try {
            for (MultipartFile file : request.getFiles("files")) {
                images.add(new Image(file.getBytes()));
            }

            ListOfImagesTO imagesTO = new ListOfImagesTO(images);
            Album createNewAlbum = serviceFacade.getGameGaleryService().createNewAlbum(gameId, name, imagesTO);
            if (createNewAlbum == null) {
                return "" + HttpStatus.NOT_ACCEPTABLE;
            }
            return "" + HttpStatus.OK;

        } catch (IOException ex) {
            Logger.getLogger(GameController.class.getName()).log(Level.SEVERE, null, ex);
            return "" + HttpStatus.NOT_ACCEPTABLE;
        }
    }

    @RequestMapping(value = "/album/image/{album}/{image}", produces = {MediaType.IMAGE_GIF_VALUE, MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE})
    public void getAlbumImage(@PathVariable("album") long album, @PathVariable("image") long image,
            HttpServletResponse response) {
        List<Image> images = serviceFacade.getGameGaleryService().getAlbum(album).getImages();
        images.stream().filter((img) -> (img.getId() == image)).forEach((img) -> {
            try {
                OutputStream outputStream = response.getOutputStream();
                outputStream.write(img.getBytes());
                outputStream.flush();
            } catch (IOException ex) {
                Logger.getLogger(GameController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

}
