package diverza.web;


import diverza.model.Persona;
import diverza.services.PersonaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * User: ecamacho
 * Date: 09/05/13
 */
@Controller
public class PersonaController {

  @Autowired
  private PersonaService personaService;

  private static final Logger logger = LoggerFactory.getLogger( PersonaService.class );

  @RequestMapping(value = "/persona", method = RequestMethod.GET)
  public void persona()
  {

  }


  @RequestMapping(value = "/persona", method = RequestMethod.POST)
  public void sendPersona( @RequestParam("nombre") String name) {
    logger.debug("controller sendpersona");
    Persona persona = personaService.findPersonaByName( name );
    personaService.sendPersona( persona );
  }
}
