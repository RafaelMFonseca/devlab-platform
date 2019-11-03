package br.com.devlab;

import org.glassfish.hk2.utilities.binding.AbstractBinder;

import br.com.devlab.dao.UserRepository;
import br.com.devlab.service.UserService;


/**
 *
 * @author rafael.fonseca
 */
public class AppBinder extends AbstractBinder {

    @Override
    protected void configure() {
        /** User */
        bindAsContract(UserService.class);
        bindAsContract(UserRepository.class);
    }

}
