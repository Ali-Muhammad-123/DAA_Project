package Classes;

public class Salary implements Finance {

    private float Gross_amount;
    private float Net_amount;


    public float getGross_amount(int courses) {
        Gross_amount = (courses * fee_per_course) * (100 - University_percentage)/100;
        return Gross_amount;
    }


    public float getNet_amount(int courses) {
        Net_amount =  getGross_amount(courses) - (getGross_amount() * income_tax/100);
        return Net_amount;
    }


    @Override
    public float getNet_amount() {
        return 0;
    }

    @Override
    public float getGross_amount() {
        return 0;
    }
}
