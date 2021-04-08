package service;

import model.Carer;
import model.CarerFakeDB;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;

@Service
public class CarerService {

    CarerFakeDB carerFakeDB;

    public void createCarer(String aboutMe, long serviceCounter, long rating, String name, long age, String phone, String email){
        Carer carer = new Carer();
        carer.setName(name);
        carer.setAge(age);
        carer.setPhone(phone);
        carer.setEmail(email);
        carer.setRating(rating);
        carer.setServiceCounter(serviceCounter);
        carer.setAboutMe(aboutMe);
        carerFakeDB.getCarerList().add(carer);
    }

    public void deleteCarer(Carer carer){
        carerFakeDB.getCarerList().remove(carer);
    }

    public void listCarers(){
        carerFakeDB.getCarerList();
    }

    @Autowired
    public void setCarerFakeDB(CarerFakeDB carerFakeDB) {
        this.carerFakeDB = carerFakeDB;
    }
}
