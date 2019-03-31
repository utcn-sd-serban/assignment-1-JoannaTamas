package ro.utcn.sd.it.a1.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ro.utcn.sd.it.a1.exception.QuestionNotFoundException;
import ro.utcn.sd.it.a1.exception.UserNotFoundException;
import ro.utcn.sd.it.a1.model.Question;
import ro.utcn.sd.it.a1.model.Tag;
import ro.utcn.sd.it.a1.model.User;
import ro.utcn.sd.it.a1.service.QuestionManagementSystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import java.util.Scanner;
@Component
@RequiredArgsConstructor
public class ConsoleController implements CommandLineRunner {
    private final Scanner scanner=new Scanner(System.in);
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
   private User user = null;
   private Tag tag=null;

    private final QuestionManagementSystem qms;


    @Override
    public void run(String... args)  {
        print("Welcome!");
        boolean done=false;
        while(!done){
            print("Enter a command: ");
            String command=scanner.next().trim();
            try{
                done=handleCommand(command);
            }catch (QuestionNotFoundException | IOException questionNotFoundEx){
                print("Error! ");
            }

        }


    }
    private boolean handleCommand(String command) throws IOException {
        switch(command){
            case "login":
                loginuser();
                return false;
            case "ask_question":
                askQ();
                return false;
            case "display_questions":
                displayQ();
                return false;
            case "filter_question":
                filterQ();
                return false;
            default:
                print("Unknown command! ");
                return false;
        }
    }

    private void displayQ(){

        qms.listQuestionByDate().forEach(s->print(s.toString()));
    }

    private void loginuser(){

        print("Enter username: ");
        String username=scanner.next().trim();

        print("Enter password: ");
        String password=scanner.next().trim();
        Optional<User> user =qms.login(username,password) ;
        if(user.isPresent()) {
            this.user=user.get();
            print("YOu are logged in! ");
        }else
            print("Wrong username or password");



    }
    private void askQ() throws IOException {
        if(user == null){
           print("You need to be logged in!");
        }else {
            print("Title: ");
            String title = br.readLine();
            print("Text: ");
            String text = br.readLine();
            //print("Author: ");
            //  String author =scanner.next().trim();
             print("Tag: ");
             String t=scanner.next().trim();
            // print("Date: ");
            Timestamp date_time = new Timestamp(System.currentTimeMillis());
            // String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date())
            // String date=scanner.next().trim();
            //Tag tag= qms.addTag(new Tag(t));
           // print("Your tag is :"+tag);
            Tag tag=new Tag(t);
            qms.addTag(tag);
            print("Your tag is: "+ tag);

            Question q = qms.addQuestion(new Question(title,this.user,text,tag,date_time));
            print("\nQuestion is: " + q);
       }
    }
    private void filterQ(){
        print("Enter title: ");
        String title=scanner.next().trim();

        qms.listQuestionByTitle(title).forEach(s->print(s.toString()));

    }



    private void print(String value){

        System.out.println(value);
    }
}
