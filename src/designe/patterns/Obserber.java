package designe.patterns;

import java.util.ArrayList;
import java.util.List;

interface Subscriber{
    public void update(String msg);
}

interface Youtube {
    public void subscriber(Users user);
    public void unSubscriber(Users user);
    public void notifyAllUsers(String msg);
}



class Users implements Subscriber{

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Users(String name) {
        this.name = name;
    }

    @Override
    public void update(String msg) {
        System.out.println(msg);
    }
}

class Youtubes implements Youtube{

    List<Users> users = new ArrayList<>();

    @Override
    public void subscriber(Users user) {
        if(user != null){
            users.add(user);
        }
    }

    @Override
    public void unSubscriber(Users user) {
        if(user!=null){
            users.remove(user);
        }
    }

    @Override
    public void notifyAllUsers(String msg) {
        for(Users u : users){
            u.update(msg+" sucessfully uploaded for "+ u.getName());
        }
    }

    public void uploadVideo(String msg){
        System.out.println(" Video tittle is    "+ msg+"   upladed");
        notifyAllUsers(msg);
    }

}
public class Obserber {
    public static void main(String[] args) {

        Youtubes youtubes = new Youtubes();

        Users u1 = new Users("subham");
        Users u2 = new Users("Akshay");
        youtubes.subscriber(u1);
        youtubes.subscriber(u2);
        youtubes.uploadVideo("java");



    }
}
