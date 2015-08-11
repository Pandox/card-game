package br.com.pandox.cg.server.view.endpoint.matchmaking;

import br.com.pandox.cg.server.domain.matchmaking.MatchMaking;
import br.com.pandox.cg.server.domain.player.Player;
import br.com.pandox.cg.server.service.matchmaking.MatchmakingService;
import br.com.pandox.cg.server.service.player.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class MatchmakingEndpoint {

    @Autowired
    private MatchmakingService service;

    @Autowired
    private PlayerService playerService;

    @RequestMapping(value = "/matchmaking", method = RequestMethod.POST)
    public ResponseEntity enqueue(@RequestBody(required = false) MatchmakingDTO dto) {

        Player player = playerService.find(dto.getPlayer());

        MatchMaking matchMaking = service.enqueue(player);

        return parseToResponse(matchMaking, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/matchmaking/{id}", method = RequestMethod.GET)
    public ResponseEntity get(@PathVariable("id") Long id) {

        MatchMaking matchMaking = service.find(id);

        return parseToResponse(matchMaking, HttpStatus.OK);
    }

//    @RequestMapping(value = "/matchmaking/{id}/ready", method = RequestMethod.PUT)
//    public ResponseEntity read(@PathVariable("id") Long id, @RequestBody(required = false) MatchmakingDTO dto) {
//
//        MatchMaking matchMaking = service.find(id);
//
//        return parseToResponse(matchMaking, HttpStatus.OK);
//    }

//    @ExceptionHandler(InvalidCEP.class)
//    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
//    @ResponseBody
//    public ErroDTO invalidCepHandler(InvalidCEP ex, HttpServletResponse response) {
//        return new ErroDTO("cep_invalid", "CEP invalido");
//    }
//
//    @ExceptionHandler(PostalAddressNotFound.class)
//    @ResponseStatus(value = HttpStatus.NO_CONTENT)
//    @ResponseBody
//    public ErroDTO postalAddressNotFoundHandler(PostalAddressNotFound ex, HttpServletResponse response) {
//        return new ErroDTO("postal_address_not_found", "CEP nao encontrado");
//    }

    private ResponseEntity parseToResponse(MatchMaking matchMaking, HttpStatus status) {
        return new ResponseEntity<>(new MatchmakingDTO(matchMaking), status);
    }
}
