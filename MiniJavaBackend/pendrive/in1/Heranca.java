class Main
{
    public static void main(String[] args)
    {
        System.out.println(new Classe2().doIt2());
    }
}

class Classe
{
    int i;
    public int doIt()
    {
        return i;
    }
    public int doIt1()
    { 
        return 0;
    }
    public int doIt2()
    { 
        return 0;
    }
}

class Classe1 extends Classe
{
    int i;
    public int doIt1()
    {
        int i;
        int j;

        i = 10;
        
        return i;
    }
    public int doIt2()
    { 
        return 0;
    }
}

class Classe2 extends Classe1
{
    int i;
    public int doIt2()
    { 
        Classe c;
        
        c = new Classe2();
        
        
        i = 64 * c.doIt();
        
        return i * 8 - 1024;
    }
}
