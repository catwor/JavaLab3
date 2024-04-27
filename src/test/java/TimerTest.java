import org.example.TimerForListFunctions;
import org.junit.jupiter.api.Test;

public class TimerTest {
  @Test
  public void ListFunctionsTest(){
    double[] add = TimerForListFunctions.timeAdd();
    double[] get = TimerForListFunctions.timeGet();
    double[] remove = TimerForListFunctions.timeRemove();

    System.out.println("    \t\tArray List\t\tLinked List");
    System.out.println("Add:\t\t\t"+add[0]+"\t\t\t\t\t\t"+add[1]);
    System.out.println("Get:\t\t\t"+get[0]+"\t\t\t\t\t"+get[1]);
    System.out.println("Remove:\t\t"+remove[0]+"\t\t\t\t\t\t"+remove[1]);
  }
}
