package br.com.devlab.dto;

/**
 *
 * @author rafael.fonseca
 */
public class ErrorMessageDTO {

    protected Boolean error;
    protected String message;

    /**
     * @param error the error to set
     */
    public void setError(Boolean error) {
        this.error = error;
    }

    /**
     * @return the error
     */
    public Boolean getError() {
        return error;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

}
