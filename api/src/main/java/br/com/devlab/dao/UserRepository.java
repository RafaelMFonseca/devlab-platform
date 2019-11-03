package br.com.devlab.dao;

import br.com.devlab.model.User;
import br.com.devlab.shared.RepositoryImplTemplate;

/**
 *
 * @author rafael.fonseca
 */
public class UserRepository extends RepositoryImplTemplate<User> {

    public UserRepository() {
        super(User.class);
    }

}
