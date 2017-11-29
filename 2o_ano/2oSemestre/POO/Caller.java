import java.util.Scanner;
import java.util.*;
import java.io.Serializable;
import java.awt.geom.Point2D;
import java.io.*;
import java.time.LocalDateTime;
import java.awt.Point;
/**
 * Escreva a descrição da classe Caller aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Caller 
{
    private UMeR u;
    
    public static void main (){
        int op;
        boolean logOut = false;
        
        /*
        try{
            this.u=new UMeR();
            //u.deserialize("projetoPOO.obj");
            this.run();
            for(Client c : u.getClients().values())
                System.out.println(c.toString() + "\n");
                System.out.println("cenas\n");
        }
        catch(IOException e){
            System.out.println("Couldn't load the file\n");
            //umer=new UMeR();
        }
        catch(ClassNotFoundException e){
            System.out.println("Couldn't load the file\n");
            //umer=new UMeR();
        }
        */
        
        UMeR u = (new Caller()).u;
        Client c=new Client("a","a","a","a","a",34);
        
        Client c1=new Client("b","b","b","b","b",12);
        
        Client c2=new Client("pat3","pat3","pat3","pat3","pat3",9);
        Client c3=new Client("pat4","pat4","pat4","pat4","pat4",50);
        Client c4=new Client("pat5","pat5","pat5","pat5","pat5",35);
        Client c5=new Client("pat6","pat6","pat6","pat6","pat6",12);
        Client c6=new Client("pat7","pat7","pat7","pat7","pat7",5);
        Client c7=new Client("pat8","pat8","pat8","pat8","pat8",6);
        Client c8=new Client("pat9","pat9","pat9","pat9","pat9",25);
        Client c9=new Client("pat10","pat10","pat10","pat10","pat10",22);
        Client c10=new Client("pat11","pat11","pat11","pat11","pat11",1);
        Client c11=new Client("pat12","pat12","pat12","pat12","pat12",56);
        Client c12=new Client("pat13","pat13","pat13","pat13","pat13",3);
        
        Manager m= new Manager("eu","eu","eu","eu","eu");
        
        Driver d=new Driver("driver1","d1","d1","d1","driver1",true);//ocupado
        Driver d1=new Driver("driver2","d2","d2","d2","driver2",true);//livre
        Driver d3=new Driver("driver3","d3","d3","d3","driver3",true);//livre
        Car car1=new Car("13-12-12",34,12,true,u.getnVehicles(),true,12);//disponivel para trabalho
        u.setnVehicles();
        Car car2=new Car("12-12-12",34,12,true,u.getnVehicles(),true,24);//disponivel para trabalho
        u.setnVehicles();
        Taxi t1=new Taxi(d,car1,false);
        Taxi t2=new Taxi(d1,car2,false);
        
                car1.setFiability(100);
        System.out.println("Fiabilidade: " + car1.getFiability());

        Trip trip = new Trip(c2, t1, new Point(0,0), new Point(0,5), 100, LocalDateTime.now());
       
        
        System.out.println("TEMPO DE VIAGEM: "+ trip.getTimeTripCD());

        try{
            u.addManager(m);
            u.addClient(c);
            
            u.addClient(c1);
            u.addClient(c2);
            u.addClient(c3);
            u.addClient(c4);
            u.addClient(c5);
            u.addClient(c6);
            u.addClient(c7);
            u.addClient(c8);
            u.addClient(c9);
            u.addClient(c10);
            u.addClient(c11);
            u.addClient(c12);
           
            u.addVehicle(car1.getId(),car1);
            u.addVehicle(car2.getId(),car2);
            u.addDriver(d.getName(),d);
            u.addDriver(d1.getName(),d1);
            u.addDriver(d3.getName(),d3);
            u.addTaxi(t1);
            u.addTaxi(t2);

           
        }
        
        catch( VehicleExistentException e){
            System.out.println("nhanhas\n");
        }
        catch(UtilizadorExistenteException e){
            System.out.println("Esta a criar um utilizador que já existe:" + e.getMessage() +"\n");
        }
        
    }
    
    public Caller(){
    this.u=new UMeR(); 
    }
    
    private void run(){
        int op;
        boolean logOut = false;
        
        logOut = LoginMenu();
        while(true)
            if(logOut == true){
                 logOut = LoginMenu(); /*para a aplicação nunca parar de correr*/
            }
            else{
                do{
                    if (u.getInstanceOfUser().equals("Client")){
                        logOut = ClientMenu(this.u);
                    }
                    else if(u.getInstanceOfUser().equals("Driver")){
                        logOut = DriverMenu(this.u);
                    }
                    else
                        logOut= ManagerMenu(this.u);
                }while(logOut == false);
            }   
    }
    
    
    public boolean LoginMenu(){
        int op;
        MenuLogin menLog;
        menLog = new MenuLogin();
        menLog.executa("login");
        op=menLog.getOp();
        Boolean controlo = false;
        ArrayList<String> dadosLogin = new ArrayList<String>();
        ArrayList<String> dadosReg = new ArrayList<String>();
        Vehicle v;
        int id=-1;

        switch (op){
            case 0: try{
                        this.u.serialize("projetoPOO.obj");/*sair*/
                    }
                    catch(FileNotFoundException e){
                        System.out.println("Couldn't save the status\n");
                    
                    }
                    catch(IOException e){
                        System.out.println("Couldn't save the status\n");
                    }
                    
                    return true;
                    
            case 1: 
                    do{
                        try{
                            menLog.executa("register");
                            dadosReg = menLog.showMenuRegister();
                            if (dadosReg.get(0).equals("Client")){ 
                                Client c = new Client(dadosReg.get(1),dadosReg.get(2),dadosReg.get(3),
                                                        dadosReg.get(4),dadosReg.get(5),0);
                                u.addClient(c);
                                u.setUser(c);
                                controlo=true;
                            }
                            else if(dadosReg.get(0).equals("Driver")){
                                Driver d = new Driver(dadosReg.get(1),dadosReg.get(2),dadosReg.get(3),
                                                            dadosReg.get(4),dadosReg.get(5),true);
                                u.setUser(d);
                                if(dadosReg.get(6).equals("true")){ /*Significa que tenho motorista privado*/
                                    if(dadosReg.get(10).equals("car"))
                                        v = new Car(dadosReg.get(7),Integer.parseInt(dadosReg.get(8)),Integer.parseInt(dadosReg.get(9)),false,u.getnVehicles(), false,0);
                                    else if(dadosReg.get(10).equals("bike"))
                                        v = new Bike(dadosReg.get(7),Integer.parseInt(dadosReg.get(8)),Integer.parseInt(dadosReg.get(9)),false,u.getnVehicles(), false);
                                    else
                                        v= new Van(dadosReg.get(7),Integer.parseInt(dadosReg.get(8)),Integer.parseInt(dadosReg.get(9)),false,u.getnVehicles(), false);
                                    
                                u.setnVehicles();
                                u.addTaxi(d,v,true);
                                controlo=true;
                                }
                            }
                            else if((dadosReg.get(0).equals("Manager"))){
                                Manager m= new Manager(dadosReg.get(1),dadosReg.get(2),dadosReg.get(3),
                                                            dadosReg.get(4),dadosReg.get(5));
                                u.setUser(m);
                                u.addManager(m);
                                controlo=true;
                            }
                            else
                                return true;
                        }
                        catch (UtilizadorExistenteException i){
                            System.out.println("\nUser already exists, try again");
                        }
                    }
                    while(controlo==false);

                    break;
            case 2: 
                    do{
                        try{
                            dadosLogin = menLog.showMenuLogin();
                            u.existUser(dadosLogin.get(0),dadosLogin.get(1));
                            System.out.println("Login with sucess\n");
                            controlo = true;
                        }
                        catch (SemAutorizacaoException i){
                            System.out.println("\nLogin invalid");
                        }
                    }while(controlo == false);
                    break;
      
            case 3: 
                    try{
                        u.serialize("projetoPOO.obj");/*sair*/
                    }
                    catch(FileNotFoundException e){
                        System.out.println("Couldn't save the status\n");
                    
                    }
                    catch(IOException e){
                        System.out.println("Couldn't save the status\n");
                    }
                   
                    u.setUser(null);
                    return true;
        }
        return false;
        
    }
    
    public boolean ClientMenu(UMeR u){
        int op;
        MenuClient MenLogClient;
        MenLogClient = new MenuClient();
        while(MenLogClient.getOp() != 0){
            MenLogClient.executa();
            op=MenLogClient.getOp();
            switch (op){
                case 0:
                    return true;/*Se quiser sair*/
                case 1:
                     MenLogClient.menuAcessListTrip(u);/*consultar lista de viagens*/
                case 2:
                    MenLogClient.menuTripSpecific(u);
                    break;
                case 3:
                    MenLogClient.menuTripCloser(u);
                    break;
                case 4:
                    //imo.fechaSessao();
                    //imo.guardaApp();
                    return true;
            }
        }
        return false;
    }
    
    public boolean DriverMenu(UMeR u){
        
        int op;
        
        MenuDriver MenLogDriver;
        MenLogDriver = new MenuDriver();
        while(MenLogDriver.getOp() != 0){
            MenLogDriver.executa();
            op=MenLogDriver.getOp();
            switch (op){
                case 0:
                    return true;
                case 1:
                    MenLogDriver.menuAcessListTrip(u);
                    break;
                case 2:
                    MenLogDriver.menuWorkDayIndi(u);
                    break;
                case 3:
                    MenLogDriver.menuWorkDayUMeR(u);
                    break;
                case 4:
                    MenLogDriver.menuFinishDayUMeR(u);
                case 5:
                    //imo.fechaSessao();
                    //imo.guardaApp();
                    return true;
            }
        }
        
        return true;
    }
    
    public boolean ManagerMenu(UMeR u){
        
        int op;
        
        MenuManager MenLogManager;
        MenLogManager = new MenuManager();
        while(MenLogManager.getOp() != 0){
            MenLogManager.executa();
            op=MenLogManager.getOp();
            switch (op){
                case 0:
                    return true;
                case 1:
                    MenLogManager.menuTotalVehicle(u);
                case 2:
                    MenLogManager.menuTotalCompany(u);
                    break;
                case 3:
                    MenLogManager.menuSpendingsClients(u);
                    break;
                case 4:
                    MenLogManager.menuDesviationDrivers(u);
                case 5:
                    //imo.fechaSessao();
                    //imo.guardaApp();
                    return true;
            }
        }
        
        return true;
    }
    
}
