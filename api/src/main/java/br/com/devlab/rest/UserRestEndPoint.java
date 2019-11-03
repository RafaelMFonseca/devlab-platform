package br.com.devlab.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.devlab.model.User;
import br.com.devlab.service.UserService;
import br.com.devlab.shared.AbstractRestEndPoint;

/**
 *
 * @author rafael.fonseca
 */
@Path("/users")
public class UserRestEndPoint extends AbstractRestEndPoint {

    protected static final Logger logger = LoggerFactory.getLogger(UserRestEndPoint.class);

    // Don't put @Inject in here!
    private final UserService userService;

    /**
     * This is probably the preferred way to go as opposed to field injection, as it
     * makes the resource easier to unit test. Constructor injection doesn't require
     * any different configuration.
     *
     * https://riptutorial.com/jersey/example/23632/basic-dependency-injection-using-jersey-s-hk2
     * http://www.appsdeveloperblog.com/dependency-injection-hk2-jersey-jax-rs/
     * https://www.programcreek.com/java-api-examples/?code=Fatlonder/E-Clinic/E-Clinic-master/src/main/java/com/jfc/eclinic/services/impl/AdminClinicServiceImpl.java
     */
    @Inject
    public UserRestEndPoint(UserService userService) {
        this.userService = userService;
    }

    @GET
    public Response getAllUsers() {
        try {
            return ok(this.userService.getAllUsers());
        } catch (Exception e) {
            return processException(e);
        }
    }

    @GET
    @Path("{id}")
    public Response getUser(@PathParam("id") Long idUser) {
        try {
            return ok(this.userService.getUser(idUser));
        } catch (Exception e) {
            return processException(e);
        }
    }

    @POST
    public Response createUser(User value) {
        try {
            return ok(this.userService.createUser(value));
        } catch (Exception e) {
            return processException(e);
        }
    }

    @PUT
    public Response updateUser(User value) {
        try {
            return ok(this.userService.updateUser(value));
        } catch (Exception e) {
            return processException(e);
        }
    }

    @DELETE
    public Response deleteUser(User value) {
        try {
            this.userService.deleteUser(value);
            return ok();
        } catch (Exception e) {
            return processException(e);
        }
    }

}
