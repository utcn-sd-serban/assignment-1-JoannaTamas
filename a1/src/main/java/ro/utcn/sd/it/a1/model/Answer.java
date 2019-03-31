package ro.utcn.sd.it.a1.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.text.DateFormat;

@Data

@NoArgsConstructor
@AllArgsConstructor
public class Answer {
    private Integer idAns;
    private Question question;
    private User authorAns;
    private String textAns;
    private Timestamp dateAns;


    public Integer getIdAns() {
        return idAns;
    }

    public User getAuthorAns() {
        return authorAns;
    }

    public String getTextAns() {
        return textAns;
    }

    public Timestamp getDateAns() {
        return dateAns;
    }

    public Question getQuestion() {
        return question;
    }
}
