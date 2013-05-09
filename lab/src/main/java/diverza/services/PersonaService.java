package diverza.services;

import diverza.model.Persona;


public interface PersonaService
{
  Persona findPersonaByName( String name );

  void sendPersona( Persona persona );


}