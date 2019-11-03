package br.com.devlab.service;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.devlab.dao.UserRepository;
import br.com.devlab.model.User;

/**
 *
 * From:
 * https://www.programcreek.com/java-api-examples/?code=Fatlonder/E-Clinic/E-Clinic-master/src/main/java/com/jfc/eclinic/services/impl/AdminClinicServiceImpl.java
 * http://www.appsdeveloperblog.com/dependency-injection-hk2-jersey-jax-rs/
 *
 * @author rafael.fonseca
 */
public class UserService {

    protected static final Logger logger = LoggerFactory.getLogger(UserService.class);

    private final UserRepository userRepository;

    @Inject
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    public User getUser(Long idUser) {
        return this.userRepository.findById(idUser);
    }

    public User createUser(User user) {
        return this.userRepository.create(user);
    }

    public User updateUser(User user) {
        return this.userRepository.save(user);
    }

    public void deleteUser(User user) {
        this.userRepository.delete(user.getId());
    }

}
