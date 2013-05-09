package diverza.services;

import diverza.model.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;



/**
 * User: ecamacho
 * Date: 08/05/13
 */
@Service("personaService")
public class PersonaServiceImpl implements PersonaService
{

  @Autowired
  private JmsTemplate jmsTemplate;


  public Persona findPersonaByName( String name ) {
    Persona persona = personaMock( name );

    return persona;
  }

  public void sendPersona( Persona persona ) {
    jmsTemplate.convertAndSend( persona );
  }



  private Persona personaMock(String name) {
    Persona persona = new Persona();
    persona.setName( name );
    persona.setLastName( "Apellido" );
    return persona;
  }

}
