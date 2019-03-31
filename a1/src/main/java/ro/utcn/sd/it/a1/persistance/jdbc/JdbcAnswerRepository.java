package ro.utcn.sd.it.a1.persistance.jdbc;

import ro.utcn.sd.it.a1.model.Answer;
import ro.utcn.sd.it.a1.persistance.api.AnswerRepository;

import java.util.List;
import java.util.Optional;

public class JdbcAnswerRepository implements AnswerRepository {


    @Override
    public List<Answer> findAll() {
        return null;
    }

    @Override
    public Answer save(Answer ans) {
        return null;
    }

    @Override
    public void remove(Answer answer) {

    }

    @Override
    public Optional<Answer> findById(int id) {
        return Optional.empty();
    }
}
