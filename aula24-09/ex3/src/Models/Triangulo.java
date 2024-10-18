package Models;

public class Triangulo {
    private float a, b, c;
    public Triangulo(float a, float b, float c)
    {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public boolean IsIsosceles()
    {
        var count = 0;
        if (a == b || a == c) {
            count++;
        }
        if (b == a || b == c) {
            count++;
        }
        if (c == a || c == b) {
            count++;
        }
        return count == 2;
    }
    public boolean IsEscaleno()
    {
        return (a != b && b != c && c != a);
    }
    public boolean IsEquilatero()
    {
        return (a == b && b == c);
    }
    public boolean IsValido() {
        return (((b - c) < a && a < b + c) && ((a - c) < b && b < a + c) && ((a - b) < c && c < a + b));
    }
    public String GetTipo()
    {
        if (IsIsosceles()) {
            return "Isosceles";
        } else if (IsEscaleno()) {
            return "Escaleno";
        } else if (IsEquilatero()) {
            return "Equilatero";
        }
        return "Invalido";

    }
    public float CalculaPerimetro()
    {
        return (a+b+c);
    }
    public float GetA()
    {
        return a;
    }
    public void SetA(float a)
    {
        this.a = a;
    }
    public float GetB()
    {
        return b;
    }
    public void SetB(float b)
    {
        this.b = b;
    }
    public float GetC()
    {
        return c;
    }
    public void SetC(float c)
    {
        this.c = c;
    }
}
