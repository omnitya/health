package jha.abhishek.healthrestendpoints;

public class Health {

    private String disease;
    private String symptoms;
    private String illness;
    private int id;
    private String date;

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public String getIllness() {
        return illness;
    }

    public void setIllness(String illness) {
        this.illness = illness;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Health{" +
                "disease='" + disease + '\'' +
                ", symptoms='" + symptoms + '\'' +
                ", illness='" + illness + '\'' +
                ", id=" + id +
                ", date='" + date + '\'' +
                '}';
    }
}
