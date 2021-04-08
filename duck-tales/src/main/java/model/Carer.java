package model;

public class Carer {
    private String aboutMe;
    private long serviceCounter;
    private long rating;
    private String name;
    private long age;
    private String phone;
    private String email;

    public String getAboutMe() {
        return aboutMe;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

    public long getServiceCounter() {
        return serviceCounter;
    }

    public void setServiceCounter(long serviceCounter) {
        this.serviceCounter = serviceCounter;
    }

    public long getRating() {
        return rating;
    }

    public void setRating(long rating) {
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getAge() {
        return age;
    }

    public void setAge(long age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Carer{" +
                "aboutMe='" + aboutMe + '\'' +
                ", serviceCounter=" + serviceCounter +
                ", rating=" + rating +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}