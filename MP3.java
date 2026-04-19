public class MP3 extends Gadget
{
private int memory;

public MP3(String model, double price, int weight, String size, int memory)
{
    super(model, price, weight, size);
    this.memory = memory;
}

public int getMemory()
{
    return memory;
}

public String downloadMusic(int size)
{
    if(size <= 0)
    {
        return "Enter valid download size";
    }

    if(size <= memory)
    {
        memory = memory - size;
        return "Music downloaded successfully";
    }
    else
    {
        return "Not enough memory";
    }
}

public void deleteMusic(int size)
{
    if(size > 0)
    {
        memory = memory + size;
    }
}

public String display()
{
    return super.display() +
           "Available memory: " + memory + "MB\n";
}

}