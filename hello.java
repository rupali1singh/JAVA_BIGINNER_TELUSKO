
class Demo
{
    public static void main(String args[])
    {
        int num=2;
        double d=9.6;
       //print hello 
        System.out.println("Hello World");
       //concatenation
       
       System.out.println(num + " " +d);
        show();
    }

    public static void show() 
    {
        System.out.println("showing result for add operator" + add(10,20));

    }
    
    static int add(int a,int b) {
        int c;
        c=a+b;
        return c;
    }
}
