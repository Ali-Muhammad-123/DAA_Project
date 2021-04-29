package Classes;

public class Fees implements Finance {
    Person student1;
    private float Gross_amount;
    private float Net_amount;

    public Fees(){ }

    public float getGross_amount(int Courses) {
        Gross_amount = (Courses * fee_per_course);
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
