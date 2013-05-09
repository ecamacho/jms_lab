package diverza.model;

import java.io.Serializable;

/**
 * User: ecamacho
 * Date: 09/05/13
 */
public class Validation<T> implements Serializable {

  private T validatedEntity;

  private boolean validationResult;

  private int validationCode;

  private String validationMessage;


  public T getValidatedEntity() {
    return validatedEntity;
  }

  public void setValidatedEntity(T validatedEntity) {
    this.validatedEntity = validatedEntity;
  }

  public boolean isValidationResult() {
    return validationResult;
  }

  public void setValidationResult(boolean validationResult) {
    this.validationResult = validationResult;
  }

  public int getValidationCode() {
    return validationCode;
  }

  public void setValidationCode(int validationCode) {
    this.validationCode = validationCode;
  }

  public String getValidationMessage() {
    return validationMessage;
  }

  public void setValidationMessage(String validationMessage) {
    this.validationMessage = validationMessage;
  }
}
