package Classes;

public class TemperaturaCelsius {
    private double valorCelsius;

    public double ObterValorEmFahrenheit()
    {
        return (valorCelsius * (9.0/5.0)) + 32.0;
    }
    public double ObterValorEmKelvin()
    {
        return valorCelsius + 273.15;
    }
    public double GetValorCelsius()
    {
        return valorCelsius;
    }
    public void SetValorCelsius(double valorCelsius)
    {
        this.valorCelsius = valorCelsius;
    }
}
