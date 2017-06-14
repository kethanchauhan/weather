package pojo;

public class Rain
{
    private String abc;

    public String get3h ()
    {
        return abc;
    }

    public void set3h (String abc)
    {
        this.abc = abc;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [3h = "+abc+"]";
    }
}
