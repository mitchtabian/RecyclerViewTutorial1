package applications.recyclerview1;

/**
 * Created by Mitch on 2016-05-29.
 */
public class Food {
    private String Meal;
    private String Desert;

    public Food(String mMeal, String mDesert){
        Meal = mMeal;
        Desert = mDesert;
    }
    public String getMeal(){return Meal;}
    public String getDesert(){return Desert;}
}
