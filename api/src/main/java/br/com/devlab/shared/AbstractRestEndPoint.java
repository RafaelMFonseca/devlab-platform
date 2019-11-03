package br.com.devlab.shared;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.devlab.dto.ErrorMessageDTO;

/**
 * Base abstraction of a JAX-RS service.
 *
 * Examples:
 * https://github.com/opennetworkinglab/onos/blob/master/utils/rest/src/main/java/org/onlab/rest/BaseResource.java
 * https://github.com/mbharanya/InComb/blob/master/src/main/java/com/incomb/server/services/AService.java
 * https://programcreek.com/java-api-examples/?code=gauravrmazra/gauravbytes/gauravbytes-master/spring-boot-rest-jersey/src/main/java/com/gauravbytes/hellogb/controller/BookController.java#
 *
 * @author rafael.fonseca
 */
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON })
public abstract class AbstractRestEndPoint {

    /**
     * Response charset.
     */
    private static final String DEFAULT_CHARSET = "utf-8";

    /**
     * Returns a HTTP 200 Response object and serializes the bean as message body.
     *
     * @param bean
     * @return the created Response
     */
    protected static Response ok(Object entity) {
        return Response.ok().entity(entity).encoding(DEFAULT_CHARSET).build();
    }

    /**
     * Returns an empty HTTP 200 Response object.
     *
     * @param bean
     * @return the created Response
     */
    protected static Response ok() {
        return Response.ok().encoding(DEFAULT_CHARSET).build();
    }

    /**
     * Returns a HTTP 500 Response object and serializes the bean as message body.
     *
     * @param bean
     * @return the created Response
     */
    protected static Response error(Object entity) {
        return Response.serverError().entity(entity).build();
    }

    /**
     * Callback method that is executed if an exception occurs in the service.
     *
     * @param e
     * @return the created Response
     */
    protected static Response processException(Exception e) {
        ErrorMessageDTO errorMessage = new ErrorMessageDTO();
        errorMessage.setError(true);
        errorMessage.setMessage(e.getMessage());
        return error(errorMessage);
    }

}
