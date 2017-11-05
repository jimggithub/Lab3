package jimlab3;


/****************************************************************************
 * Queue Interface
 *
 * 
 * @author Jim Griffin
 * @version 1.0
 * @date 11-2-2017
 * @course MCIS-0503 Fall 2017 Data Structures and Algorithms
 * @instructor Dr. Jeremy Lanman
 *****************************************************************************/
public interface Queue < T >{
    // Transformers/Mutators
    public void enqueue(T o);

    //void enqueue(Camper o);

    public T dequeue();

    public void makeEmpty();

    // Observers/Accessors
    public T getFront();

    public int size();

    public boolean isEmpty();

    public boolean isFull();
}
