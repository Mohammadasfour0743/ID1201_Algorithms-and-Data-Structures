public class Connection{
    City destination;
    int duration;

    public Connection(City destination, int duration){
        this.destination = destination;
        this.duration = duration;
    }

    public City getDest(){
        return destination;
    }
    public int getDur(){
        return duration;
    }   
    
}
