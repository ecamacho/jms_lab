package diverza.services;

import diverza.model.Persona;
import diverza.model.Validation;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * User: ecamacho
 * Date: 09/05/13
 */
@ContextConfiguration(locations = {"classpath:application-context.xml",
"classpath:application-context-infrastructure-test.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class PersonaValidatorTest {

  @Autowired
  private PersonValidator validator;

  @Test
  public void testValidationSuccessful() {
    Persona persona = getValidPerson();
    Validation<Persona> validation = validator.validatePerson( persona );
    assertEquals(validation.isValidationResult(), true);
    assertEquals(validation.getValidatedEntity(), persona);
  }

  @Test
  public void testValidationUnsuccessful() {
    Persona persona = getInvalidPerson();
    Validation<Persona> validation = validator.validatePerson( persona );
    assertEquals(validation.isValidationResult(), false);
    assertEquals(validation.getValidatedEntity(), persona);


    persona = getInvalidPersonWithBlankName();
    validation = validator.validatePerson( persona );
    assertEquals(validation.isValidationResult(), false);
    assertEquals(validation.getValidatedEntity(), persona);
  }

  private Persona getValidPerson() {
    Persona persona = new Persona();
    persona.setName("Carlos");
    persona.setLastName("Martinez");
    return persona;
  }

  private Persona getInvalidPerson() {
    Persona persona = new Persona();
    persona.setLastName("Martinez");
    return persona;
  }

  private Persona getInvalidPersonWithBlankName() {
    Persona persona = new Persona();
    persona.setName(" ");
    persona.setLastName("Martinez");
    return persona;
  }

}
