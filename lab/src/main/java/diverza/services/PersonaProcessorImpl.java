package diverza.services;

import diverza.model.Persona;
import diverza.model.Validation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * User: ecamacho
 * Date: 09/05/13
 */
@Service("personaProcessor")
public class PersonaProcessorImpl implements PersonaProcessor {

  private static final Logger log = LoggerFactory.getLogger( PersonaProcessorImpl.class);

  private List<Persona> personsProcessed;

  public List<Persona> getPersonsProcessed()
  {
    return personsProcessed;
  }

  public PersonaProcessorImpl() {
    super();
    personsProcessed = new ArrayList<Persona>();
  }

  public void processPersona(Persona persona) {
    log.debug("Processing person " + persona);
    Assert.notNull(persona);
    personsProcessed.add( persona );
  }

  public void processPersonaValidated(Validation<Persona> validation)
  {
    log.debug("Process persona validation " + validation);
    if (validation.isValidationResult()) {
      log.debug("Person is valid, processing");
      processPersona( validation.getValidatedEntity() );
    } else {
      log.debug("Person is invalid, not processing it");
    }
  }
}
