package ro.utcn.sd.it.a1.persistance.jpa;

import ro.utcn.sd.it.a1.model.User;
import ro.utcn.sd.it.a1.persistance.api.QuestionRepository;
import ro.utcn.sd.it.a1.persistance.api.UserRepository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class HibernateUserRepository implements UserRepository {
    public HibernateUserRepository(EntityManager entityManager) {
    }

    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public void remove(User user) {

    }

    @Override
    public Optional<User> findById(int id) {

        return Optional.empty();
    }

    @Override
    public Optional<User> findUserInfo(String username, String password) {
        return Optional.empty();
    }


}
