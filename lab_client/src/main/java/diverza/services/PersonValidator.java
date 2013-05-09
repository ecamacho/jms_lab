package diverza.services;

import diverza.model.Persona;
import diverza.model.Validation;

interface PersonValidator
{
	Validation<Persona> validatePerson( Persona person );
}