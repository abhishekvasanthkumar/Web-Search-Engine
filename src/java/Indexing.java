import java.util.*;
public class Indexing {
    static int max=Integer.MIN_VALUE,resultDoc;
    PriorityQueue<Tuple> pq = new PriorityQueue();
    
  public PriorityQueue<Tuple> tfidf(HashMap hm, String word)
  {
      for(Object term:hm.keySet())
      {   
          if(((String)(term)).equals(word))
          {
              Object temp = hm.get(term);
              HashMap t  = (HashMap)temp;
              for(Object doc:t.keySet())
              {
                  pq.add(new Tuple((int)doc,(int)t.get((int)doc)));
              }
          }
      }
      return pq;
  }
 
  class Tuple implements Comparable<Tuple>
  {
      int count, doc;
      public Tuple(int doc,int count)
      {
          this.count=count;
          this.doc=doc;
      }
        @Override
        public int compareTo(Tuple o) {
            return o.count-this.count;
        }
        
        public String toString()
    {
        return ("Doc " + this.doc + " "+ "Count " + " "+ this.count);
    }
      
  }
}
