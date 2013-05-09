package diverza.services;

import diverza.model.Persona;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@ContextConfiguration(locations = {"classpath:application-context.xml",
    "classpath:application-context-infrastructure-test.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class PersonaServiceTest
{

  private static final String EXPECTED_NAME_1 = "Juan";
  private static final String EXPECTED_NAME_2 = "Maria";
  private static final String EXPECTED_NAME_3 = "Pedro";
  private static final String EXPECTED_NAME_4 = "Martha";

  @Autowired
  @Qualifier("personaService")
  private PersonaService personaService;

  @Autowired
  private PersonaProcessor personaProcessor;


  @Test
  public void testFindPersonaByName() {
    Persona persona = personaService.findPersonaByName( EXPECTED_NAME_1 );

    assertNotNull( persona );
    assertEquals( EXPECTED_NAME_1, persona.getName());
  }

  @Test
  public void testSendPersona() throws Exception {

    personaService.sendPersona( personaService.findPersonaByName( EXPECTED_NAME_1 ) );
    personaService.sendPersona( personaService.findPersonaByName( EXPECTED_NAME_2 ) );
    personaService.sendPersona( personaService.findPersonaByName( EXPECTED_NAME_3 ) );
    personaService.sendPersona( personaService.findPersonaByName( EXPECTED_NAME_4 ) );
    int personsProcessed = waitForPersonsProcess( 4, 1000);
    assertTrue( personsProcessed == 4);

  }

  private int waitForPersonsProcess( int batchSize, int timeout ) throws InterruptedException {
    int sleepTime = 100;
    while (personaProcessor.getPersonsProcessed().size() < batchSize && timeout > 0) {
      Thread.sleep(sleepTime);
      timeout -= sleepTime;
    }
    return personaProcessor.getPersonsProcessed().size();
  }
}