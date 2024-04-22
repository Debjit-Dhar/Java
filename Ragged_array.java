public class Ragged_array {
    public static void main(String[] args) {
        int a[][]=new int[4][];
        a[0]=new int[1];
        a[1]=new int[2];
        a[2]=new int[3];
        a[3]=new int[4];
        int i,j;
        for(i=0;i<a.length;i++)
        {
            for(j=0;j<a[i].length;j++)
            {
                a[i][j]=0;
                System.out.print(a[i][j]);
            }    
            System.out.println();
        }
    }    
}
