package jha.abhishek.healthrestendpoints;

import org.springframework.stereotype.Repository;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Repository
public class HealthDAO {

    private static Health list = new Health();

    static {
        list.setDisease("covid19");
        list.setDate(new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime()));
        list.setId(101);
        list.setIllness("corona");
        list.setSymptoms("Cough and cold");
    }

    public Health getHealth(){
        return list;
    }

    public void addHealth(Health h){
        list.setDisease(h.getDisease());
        list.setDate(new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime()));
        list.setId(h.getId());
        list.setIllness(h.getIllness());
        list.setSymptoms(h.getSymptoms());
    }
}
