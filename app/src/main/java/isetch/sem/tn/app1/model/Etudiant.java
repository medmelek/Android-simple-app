package isetch.sem.tn.app1.model;

/**
 * Created by Med Melek on 24/09/2016.
 */
public class Etudiant {

    private String name ;
    private String age ;
    private String lastname ;

    public Etudiant (String name , String age , String lastname ){
        this.name=name ;
        this.age=age ;
        this.lastname=lastname ;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
