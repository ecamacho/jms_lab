package diverza.services;

import diverza.model.Persona;
import diverza.model.Validation;

import java.util.List;

/**
 * User: ecamacho
 * Date: 09/05/13
 */
public interface PersonaProcessor {

  void processPersona(Persona persona);

  void processPersonaValidated(Validation<Persona> persona);

  List<Persona> getPersonsProcessed();

}
