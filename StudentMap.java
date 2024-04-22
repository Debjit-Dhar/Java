 import java.util.*;
 class StudentMap {
    LinkedHashMap<Long,Double> map;
    public StudentMap() {
        map=new LinkedHashMap<Long,Double>();
    }
    public void add(long  roll,double score){
        map.put(roll,score);
    }
    @SuppressWarnings ("unchecked")
    public void display(){
        Set<Map.Entry<Long,Double>> set=map.entrySet();
        Iterator<Map.Entry<Long,Double>> it=set.iterator();
        while(it.hasNext()){
            Map.Entry<Long,Double> pair=(Map.Entry)it.next();
            System.out.println("Key= "+pair.getKey()+" Value= "+pair.getValue());
        }
    }
}
class TestMap{
    public static void main(String args[])
    {
        StudentMap map=new StudentMap();
        map.add(90901292,21);
        map.add(871728,78);
        map.add(12787812,100);
        map.display();
    }
}
