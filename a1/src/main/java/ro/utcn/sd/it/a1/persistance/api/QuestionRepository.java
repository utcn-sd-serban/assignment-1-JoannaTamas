package ro.utcn.sd.it.a1.persistance.api;

import ro.utcn.sd.it.a1.model.Question;

import java.util.List;
import java.util.Optional;

public interface QuestionRepository {

    Question save (Question question);

    //Optional is a wrapper that has two states: empty or full(one element in it)
    //to avoid null pointer exceptions
    Optional<Question>findById(int id);//should never return null
    List<Question>findByTitle(String title);

    void remove(Question question);

    List<Question> findAll();

    List<Question>findByTag(String tag);

    List<Question> listByDate();
}
