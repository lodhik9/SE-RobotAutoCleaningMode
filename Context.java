
/**
 * Write a description of class Context here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Context {
   private Strategy strategy;

   public Context(Strategy strategy){
      this.strategy = strategy;
   }

   public String executeStrategy(){
      return strategy.AlgorithmInterface();
   }
}