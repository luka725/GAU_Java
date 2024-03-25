public class Task3 {
    public int x;

    public Task3(){

    }
    public Task3(int x){
        this.x = x;
    }

    public void FindoutX(){
        if(this.x > 5 && this.x < 24) {
            System.out.println("X is between 5 and 24");
        }
        else{
            System.out.println("X is out of range 5 and 24");
        }
    }
}
