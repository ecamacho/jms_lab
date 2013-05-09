package diverza.model;

import java.io.Serializable;

public class Persona implements Serializable
{

  private String name;

  private String lastName;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  @Override
  public String toString() {
    return "Persona{" +
        "name='" + name + '\'' +
        ", lastName='" + lastName + '\'' +
        '}';
  }
}