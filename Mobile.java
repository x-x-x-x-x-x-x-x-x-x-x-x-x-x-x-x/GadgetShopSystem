public class Mobile extends Gadget
{
private int credit;

public Mobile(String model, double price, int weight, String size, int credit)
{
    super(model, price, weight, size);
    this.credit = credit;
}

public int getCredit()
{
    return credit;
}

public void addCredit(int amount)
{
    if(amount > 0)
    {
        credit = credit + amount;
    }
    else
    {
        System.out.println("Enter positive credit");
    }
}

public void makeCall(String phoneNumber, int duration)
{
    if(credit >= duration)
    {
        System.out.println("Calling " + phoneNumber + " for " + duration + " minutes");
        credit = credit - duration;
    }
    else
    {
        System.out.println("Not enough credit");
    }
}

public void display()
{
    super.display();
    System.out.println("Credit minutes: " + credit);
}

}