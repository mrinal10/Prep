
import java.util.*;

class Program {
  public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
    int startIndex = 0;
    int endIndex = array.size() - 1;
    
    while(startIndex < array.size()) {
      
      int cur = array.get(startIndex);
      
      while(endIndex > 0  && array.get(endIndex)==toMove) {
        endIndex--;
      }
      if(cur == toMove && endIndex >= 0 && startIndex < endIndex) {
        
        int toBeSwapped = array.get(endIndex);
        
        array.add(endIndex, cur);
        array.remove(endIndex + 1);
        
        array.add(startIndex, toBeSwapped);
        array.remove(startIndex + 1);
      }
      startIndex++;
    }
    return array;
  }

    public static void main(String[] args) {
       List<Integer> ll = new ArrayList<>();

       ll.add(4);
       ll.add(1);
       ll.add(3);
       ll.add(2);
       ll.add(2);
       ll.add(2);
       ll.add(2);
       ll.add(2);

       ll= Program.moveElementToEnd(ll, 2);

        for(Integer i : ll) {
            System.out.println(i);
        } 
    }
}
