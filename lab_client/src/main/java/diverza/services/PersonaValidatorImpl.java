package diverza.services;

import diverza.model.Persona;
import diverza.model.Validation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * User: ecamacho
 * Date: 09/05/13
 */
@Service("personaValidator")
public class PersonaValidatorImpl implements PersonValidator {

  private static final Logger log = LoggerFactory.getLogger( PersonaValidatorImpl.class );


  @Override
  public Validation<Persona> validatePerson(Persona person) {
    log.debug("Validating persona " + person);
    Validation<Persona> validation = new Validation<Persona>();
    validation.setValidatedEntity( person );

    if ( person.getName() == null || person.getName().trim().isEmpty()) {
      validation.setValidationResult( false );
      validation.setValidationCode( 502 );
      validation.setValidationMessage("Name must not be null");
    } else {
      validation.setValidationResult( true );
      validation.setValidationCode( 200 );

    }
    return validation;
  }

}
