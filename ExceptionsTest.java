class InvalidAgeException extends Throwable
{
    public String toString() { return "Invalid age."; }
}
class A 
{
    static void printAge(int age)throws InvalidAgeException
    {
        if(age<0)
            throw new InvalidAgeException();
        System.out.println("You are "+age+" years old.");
    }
    public static void main(String[] args)
    {
        int age=-2;
        try{
            
            printAge(age);
        }
        catch(InvalidAgeException e){
            System.out.print(e);
        }
        
    }
}