package designe.patterns;

import java.util.ArrayList;
import java.util.List;

interface Suscriber{
    public void update(String msg);
}

interface youtube {
    public void subscribe(User user);
    public void unsubscribe(User user);
    public void NotifyAll(String videoTitle);
}

class User implements  Suscriber{
    public String name;

    public String getName() {
        return name;
    }

    public User(String name){
        this.name = name;
    }

    @Override
    public void update(String msg) {
        System.out.println(msg);
    }
}


class YoutubeCon implements youtube{

    List<User> subscribers = new ArrayList<>();

    @Override
    public void subscribe(User user) {
        if(user != null){
            subscribers.add(user);
        }
    }

    @Override
    public void unsubscribe(User user) {
        if(user != null){
            subscribers.remove(user);
        }
    }

    @Override
    public void NotifyAll(String videoTitle) {
        for(User u : subscribers){
            u.update("hey "+ u.getName()+ "    I have uploded a video for you "+videoTitle);
        }
    }

    public void uploadVideo(String videoTitle){
        System.out.println("upload done "+ videoTitle);
        NotifyAll(videoTitle);
    }
}




public class YoutubeChannel {
    public static void main(String[] args) {

        User u1 = new User("Subham");
        User u2 = new User("Utsav");
        User u3 = new User("pallavi");

        YoutubeCon youtubeCh = new YoutubeCon();

        youtubeCh.subscribe(u1);
        youtubeCh.subscribe(u2);
        youtubeCh.subscribe(u3);

        youtubeCh.uploadVideo("New java video");

        youtubeCh.unsubscribe(u1);

        youtubeCh.uploadVideo("new Python Video");


    }
}