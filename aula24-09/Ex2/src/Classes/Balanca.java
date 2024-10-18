package Classes;

public class Balanca
{
    private double pesoPrato1 = 0;
    private double pesoPrato2 = 0;

    public double DiferencaPesos()
    {
        return Math.abs(pesoPrato1 - pesoPrato2);
    }
    public double PercentualPesoPrato1() {
        return pesoPrato1 / (pesoPrato1 + pesoPrato2);
    }
    public double PercentualPesoPrato2()
    {
        return pesoPrato2 / (pesoPrato1 + pesoPrato2);
    }
    public double ObtemTotal()
    {
        return pesoPrato1 + pesoPrato2;
    }
    public void SetPesoPrato1(double pesoPrato1)
    {
        this.pesoPrato1 = pesoPrato1;
    }
    public double SetPesoPrato1()
    {
        return this.pesoPrato1;
    }
    public void SetPesoPrato2(double pesoPrato2)
    {
        this.pesoPrato2 = pesoPrato2;
    }
    public double SetPesoPrato2()
    {
        return this.pesoPrato2;
    }
}
