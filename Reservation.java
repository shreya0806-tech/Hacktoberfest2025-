import java.lang.*;
import java.util.*;
import java.util.ArrayList;
class Seat{
    boolean status=false;
    int seat_no;
    String name=null;
    String gender=null;
}
class Boogie extends Seat{
    int boogie_no;
    Seat seats[] = new Seat[8];
    Boogie(){
        for(int i=0;i<8;i++){
            seats[i] = new Seat();
        }
    }

}
class Train extends Boogie{
    int train_no;
    String train_name;
    Train(){

    }
    Train(int train_no,String train_name){
        this.train_no=train_no;
        this.train_name = train_name;
        System.out.println("Train added successfull : ");
    }
    ArrayList<Boogie> boogies = new ArrayList<>();
    void addBoogie(){
        boogies.add(new Boogie());
        boogie_no = boogies.size()-1;
        System.out.println("Boogied added");
    }
    void reserve(){
        Scanner sc = new Scanner(System.in);
    outer : for(int i=0;i<boogies.size();i++){
            for(int j=0;j<seats.length;j++){
                if(boogies.get(i).seats[j].status=false){
                    boogies.get(i).seats[j].status=true;
                    System.out.print("Enter name : ");
                    boogies.get(i).seats[j].name = sc.nextLine();
                    System.out.print("Enter gender : ");
                    boogies.get(i).seats[j].gender = sc.nextLine();
                    System.out.println("Reserved success : ");
                    break outer;

                }
            }
        }
    }
    public String toString(){
        
        int booked=0;
        int free=0;
        for(int i=0;i<boogies.size();i++){
            for(int j=0;j<boogies.get(i).seats.length;j++){
                if(boogies.get(i).seats[j].status == true){
                    booked++;
                }
                else{
                    free++;
                }
            }
        }
        String msg = "\nTrain no : "+train_no+"\nTrain Name : "+train_name+"\nNo of boogies : "+boogies.size()+"\nAvailable seats : "+free;
        return msg;
        
    }
}
class Admin{
    ArrayList<Train> trains = new ArrayList<>();
    void addTrain(int train_no,String train_name){
        trains.add(new Train(train_no,train_name));
    }
    void addBoogie(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter train no : ");
        int train_no = sc.nextInt();
    }
    
}
class Reservation{
    public static void main(String s[]){
        ArrayList<Train> trains = new ArrayList<>();
        Scanner sc=new Scanner(System.in);
        
        
        while(true){
            System.out.println("1 for add train\n2 for add boogie\n3 for reservation\n4 for check seats\n5 for check train\n6 for check PNR status\n7 for exit");
            System.out.print("Enter your choice : ");
            int choice=sc.nextInt();
            switch(choice){
                case 1:
                    int train_no;
                    String train_name;
                    System.out.print("Enter train no : ");
                    train_no=sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter train name : ");
                    train_name = sc.nextLine();
                    trains.add(new Train(train_no,train_name));
                    break;
                case 2:
                    System.out.print("Enter train no : ");
                    int tno = sc.nextInt();
                    for(int i=0;i<trains.size();i++){
                        if(trains.get(i).train_no == tno){
                            trains.get(i).addBoogie();
                            break;
                        }
                    }
                    break;
                case 3:
                    
                    System.out.print("Enter train no : ");
                    tno = sc.nextInt();
                    for(int i=0;i<trains.size();i++){
                        if(trains.get(i).train_no == tno){
                            trains.get(i).reserve();
                        }
                    }
                    break;
                case 7:
                    System.exit(0);
                    break;
            }
        }


    }
}
