package model;

import java.util.LinkedList;
import java.util.List;

public class CarerFakeDB {

    private List<Carer> carerList = new LinkedList<>();

    public List<Carer> getCarerList() {
        return carerList;
    }

    public CarerFakeDB(){
        Carer carer = new Carer();
        carer.setName("Julia");
        carer.setAge(23);
        carer.setPhone("91234678");
        carer.setEmail("julia@gmail.com");
        carer.setRating(5);
        carer.setServiceCounter(34);
        carer.setAboutMe("Hi, I'm very good with little humans!");
        carerList.add(carer);

        Carer carer1 = new Carer();
        carer.setName("Julia");
        carer.setAge(23);
        carer.setPhone("91234678");
        carer.setEmail("julia@gmail.com");
        carer.setRating(5);
        carer.setServiceCounter(34);
        carer.setAboutMe("Hi, I'm very good with little humans!");
        carerList.add(carer1);

        Carer carer2 = new Carer();
        carer.setName("Jorge");
        carer.setAge(35);
        carer.setPhone("91234677");
        carer.setEmail("jorge@gmail.com");
        carer.setRating(5);
        carer.setServiceCounter(4567);
        carer.setAboutMe("Hi, I'm a kindergarten caregiver, and looking for some money on the side!");
        carerList.add(carer2);

        Carer carer3 = new Carer();
        carer.setName("Julieta");
        carer.setAge(96);
        carer.setPhone("9123");
        carer.setEmail("email? o que é isso?");
        carer.setRating(5);
        carer.setServiceCounter(93457);
        carer.setAboutMe("Ai deles que não me respeitem! Faço-lhes como faziam no meu tempo: dou-lhe com o chinelo!");
        carerList.add(carer3);

        Carer carer4 = new Carer();
        carer.setName("Juliano");
        carer.setAge(45);
        carer.setPhone("91666666");
        carer.setEmail("juliano@christ.com");
        carer.setRating(0);
        carer.setServiceCounter(0);
        carer.setAboutMe("Hi, I'm an irish catholic priest, and I like children!");
        carerList.add(carer4);

        Carer carer5 = new Carer();
        carer.setName("Juliana");
        carer.setAge(14);
        carer.setPhone("91234678");
        carer.setEmail("juliana@outlook.com");
        carer.setRating(4);
        carer.setServiceCounter(4);
        carer.setAboutMe("Hi, my parents didn't give me a key to my home, so I have much freetime to kill! Also, I'd like to have some little brothers ou sisters, so I like to be a carer. Check out my tiktok #julianaCarer");
        carerList.add(carer5);

        Carer carer6 = new Carer();
        carer.setName("Josefino");
        carer.setAge(37);
        carer.setPhone("918765432");
        carer.setEmail("josefino@hotmail.com");
        carer.setRating(3);
        carer.setServiceCounter(12);
        carer.setAboutMe("Hi, I have 8 kids of mine, so what difference makes another one or two!?");
        carerList.add(carer6);
    }
}
