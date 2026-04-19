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
}

public String makeCall(String phoneNumber, int duration)
{
    if(!phoneNumber.matches("07\\d{9}"))
    {
        return "Invalid UK phone number";
    }

    if(duration <= 0)
    {
        return "Enter valid duration";
    }

    if(credit >= duration)
    {
        credit = credit - duration;
        return "Calling " + phoneNumber + " for " + duration + " minutes";
    }
    else
    {
        return "Not enough credit";
    }
}

public String display()
{
    return super.display() +
           "Credit minutes: " + credit + "\n";
}

}