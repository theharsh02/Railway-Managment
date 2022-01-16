package newpackage;
import java.sql.*;
import java.util.*;
 abstract class railwaymenu
{
 abstract void Menu();
}
interface  displayde
{
    public void display() throws  SQLException;
}
  class f1 extends railwaymenu implements displayde
{ 
  int ch1,ch2;//place choice,train choice,tickets 
  int  b=0,tickets=0;
  int ch3[]=new int[100];
  String name[][]=new String[100][100];
   int age[][]=new int[100][100];
  String ph[][]=new String[100][100];
  String searchph=new String();
  String tl[]=new String[100];
  String t2[]=new String[100];
  String to1[]=new String[100];
  String from1[]=new String[100];
  int i,charge=0,t,j;
  int charge2[][]=new int[100][100];
    int max1=3;
  //creating a object of scanner
   Scanner sc=new Scanner(System.in);
   //read a strings
   Scanner st=new Scanner(System.in);
Connection con;
PreparedStatement  datab,CreateTable;
  private void Bticket() throws SQLException,ClassNotFoundException
  { 
try
{    
Class.forName("com.mysql.jdbc.Driver");
con = DriverManager.getConnection("jdbc:mysql://localhost:3306/","root","harsh123");
  datab = con.prepareStatement("CREATE DATABASE IF NOT EXISTS java;");
  datab.execute();
  datab.close();
String driver = "jdbc:mysql://localhost:3306/java";
  con = DriverManager.getConnection(driver,"root","harsh123");
CreateTable =con.prepareStatement("CREATE TABLE IF NOT EXISTS ticket(id INT NOT NULL AUTO_INCREMENT,name varchar(10),ph varchar(11),age int(2),to1 varchar(15),from1 varchar(20),train varchar(20),charge int(9),PRIMARY KEY(id))"); 
 CreateTable.execute();
        CreateTable.close();
 
 PreparedStatement InsertData = con.prepareStatement("INSERT INTO ticket(name,ph,age,to1,from1,train,charge) VALUES(?,?,?,?,?,?,?)");

    System.out.println("------BOOK TICKETS------");
    System.out.println("\n   FROM     -       TO");
    System.out.println("1.ASAUDAH   -  BHUBANESWAR");
    System.out.println("2.AMRITSAR  -  AHMEDABAD");
    System.out.println("3.MUBAI     -  DELHI \n");
    System.out.print("Enter a place choice:");
    ch1=sc.nextInt();
    if(ch1>0 && ch1<4)
    {
    System.out.println("------TRAINS AND TIMINGS------"+"\n"); 
    System.out.println("        TRAIN           -  TIMINGS  -  CHARGE");    
    System.out.println("1.Vande Bharat express  -  10:00am  -  3000rs"); 
    System.out.println("2.Nanda Devi express    -  01:00pm  -  2500rs");
    System.out.println("3.Humsafar express      -  11:00pm  -  2000rs"+"\n");
    System.out.print("Enter a train choice:");
    ch2=sc.nextInt();
     if(ch2>0 && ch2<4)
     {
         System.out.print("Enter a no of tickes:");
         t=sc.nextInt();
         ch3[b]=t;
       if(t<=0 || t>max1||max1<=0)
         {
     System.out.println("ticket is maximum 100 available"); 
             System.exit(0);
         } 
        else {
            tickets=1;
            max1=max1-t;  
       } 
         if(tickets==1&&max1>0)
         {
         for(i=0;i<t;i++)
         {
     System.out.print("\n");
     System.out.println("Enter a name of passanger-"+(i+1)+":");
     name[i][b]=st.nextLine();
     ph[i][b]="091929394";
     String strPattern = "^[0-9]{10}$";
    while(!(ph[i][b].matches(strPattern)))
    {
        System.out.println("Enter a "+name[i][b]+"'s phone no:");
        ph[i][b]=st.nextLine();
        if(!(ph[i][b].matches(strPattern)))
        {
        System.out.println("Write 10 digit no");
        }
        
    }
    age[i][b]=3;
    while(!(age[i][b]>=5&&age[i][b]<=60))
    {
     System.out.println("Enter a "+name[i][b]+"'s age:");
     age[i][b]=sc.nextInt();
     if(!(age[i][b]>=5&&age[i][b]<=60))
     {
         System.out.println("age should be between 5 to 60 year");
     }
    }
         }
   for(i=0;i<t;i++)
   {
        switch (ch1) 
             {
                 case 1:
                     tl[b]="ASAUDAH-BHUBANESWAR";
                     to1[b]="BHUBANESWAR";
                     from1[b]="ASAUDAH";
                     break;
                 case 2:
                     tl[b]="AMRITSAR-AHMEDABAD";
                     to1[b]="AHMEDABAD";
                     from1[b]="AMRITSAR";
                     break;
                 case 3:
                     tl[b]="MUBAI-DELHI";
                     to1[b]="DELHI";
                     from1[b]="MUBAI";
                     break;
                 default:
                     break;
             }     
       switch (ch2) 
             {
                 case 1:
                     t2[b]="Vande Bharat express"; 
                     break;
                 case 2:
                     t2[b]="Nanda Devi express"; 
                     break;
                 case 3:
                     t2[b]="Humsafar express"; 
                     break;
                 default:
                     break;
             }
  System.out.println("passenger-"+(i+1)+" selected place"+"="+tl[b]);
  System.out.println("passenger-"+(i+1)+" selected train"+"="+t2[b]);
  
  switch (ch2) 
             {
                 case 1:
                      charge2[i][b]=3000;
                     break;
                 case 2:
                      charge2[i][b]=2500;
                     break;
                 case 3:
                     charge2[i][b]=2000;
                     break;
                 default:
                     break;
             }
   
    InsertData.setString(1,name[i][b]);
     InsertData.setString(2,ph[i][b]);
     InsertData.setInt(3,age[i][b]);
    InsertData.setString(4,to1[b]);
    InsertData.setString(5,from1[b]);       
    InsertData.setString(6,t2[b]);
     InsertData.setInt(7,charge2[i][b]);
    InsertData.executeUpdate();
   }
    InsertData.close();
    switch (ch2) 
             {
                 case 1:
                      charge= t*3000;
                     break;
                 case 2:
                      charge= ch3[b]*2500;
                     break;
                 case 3:
                      charge= ch3[b]*2000;
                     break;
                 default:
                     break;
             }
   System.out.println("Total "+t+" tickets charge:"+charge);

   
    System.out.println("\nTicket successfully booked\n");
  b++;
    }
      
     }
     else
     {
         System.out.println("Invalid choice of trains");
     }
    }
    else
    {
        System.out.println("Invalid choice of place");
    }
    
    }catch(ClassNotFoundException | SQLException e)
{
    System.out.println(e);
}
  }

  private  void Serch_p() throws SQLException
  {
      System.out.println("Enter a passanger phone which you want to search:");
         searchph=st.nextLine();
       Connection con;
     con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java","root","harsh123");
 Statement state = con.createStatement();
 ResultSet rs =state.executeQuery("select * from  ticket where ph="+searchph+";");
 CreateTable =con.prepareStatement("CREATE TABLE IF NOT EXISTS ticket(id INT NOT NULL AUTO_INCREMENT,name varchar(10),ph varchar(11),age int(2),to1 varchar(15),from1 varchar(20),train varchar(20),charge int(9),PRIMARY KEY(id))"); 
 System.out.println("\n\t\t railway-reserve \n"+"id  "+"Name  "+"  Phone-no    "+"Age"+"     "+"To"+"          "+"From  "+"\t"+"Train"+"		     "+"charge"); 
while(rs.next()){
  System.out.println(rs.getString("id")+"   "+rs.getString("name")+"   "+rs.getString("ph")+"  "+rs.getInt("age")+"    "+rs.getString("to1")+"   "+rs.getString("from1")+"   "+rs.getString("train")+"   "+rs.getInt("charge")+".RS");
              }
	con.close();
                 rs.close();  
  }
  @Override
   public  void display() throws  SQLException
  {
      Connection con;
     con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java","root","harsh123");
 Statement state = con.createStatement();
 ResultSet rs =state.executeQuery("select * from  ticket;");
 CreateTable =con.prepareStatement("CREATE TABLE IF NOT EXISTS ticket(id INT NOT NULL AUTO_INCREMENT,name varchar(10),ph varchar(11),age int(2),to1 varchar(15),from1 varchar(20),train varchar(20),charge int(9),PRIMARY KEY(id))"); 
 System.out.println("\n\t\t railway-reserve \n"+"id  "+"Name  "+"  Phone-no    "+"Age"+"     "+"To"+"          "+"From  "+"\t"+"Train"+"		     "+"charge"); 
while(rs.next()){
  System.out.println(rs.getString("id")+"   "+rs.getString("name")+"   "+rs.getString("ph")+"  "+rs.getInt("age")+"    "+rs.getString("to1")+"   "+rs.getString("from1")+"   "+rs.getString("train")+"   "+rs.getInt("charge")+".RS");
              }
	con.close();
                 rs.close();
  }
  private void unbooked()
  {
     System.out.println("No. of booked tickets status");
     System.out.println("  "+max1);
  }
  private  void cancelt() throws SQLException
  {
      String harsh="SELECT name,ph,age,to1,from1,train,charge from ticket";
      System.out.println("Enter a passanger phone which you want to search:");
         searchph=st.nextLine();
       Connection con;
     con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java","root","harsh123");
 Statement state = con.createStatement();
 state.executeUpdate("delete from ticket where ph="+searchph+";");
 con.close();       
 max1++;
  }
  @Override
     void Menu() 
   {  int ch=1;
  while(ch!=6)
  {
  System.out.println("-------RAILWAY RESERVATION MENU------");
  System.out.println("1.Book Ticket"); 
  System.out.println("2.Display ");
  System.out.println("3.Search Passenger");
  System.out.println("4.Display Available Tickets");
  System.out.println("5.Cancel ticket");
  System.out.println("6.Exit");
  System.out.print("Enter your choice : ");
  ch=sc.nextInt();
       switch (ch) {
           case 1:
      {
          try {
              Bticket();
          } catch (SQLException | ClassNotFoundException ex) {
               System.out.println(ex);
          }
      }
               break;

           case 2:   
      {
          try {
              display();
          } catch (SQLException ex)
          {
               System.out.println(ex);
          }
      }
               break;

           case 3:
      {
          try {
              Serch_p();
          } catch (SQLException ex) {
            System.out.println(ex); 
          }
      }
               break;

           case 4:
               unbooked();
               break;
           case 5:
      {
          try {
              cancelt();
          } catch (SQLException ex) {
               System.out.println(ex); 
          }
      }
               break;

                  case 6:
               System.exit(0);
               break;
           default:
               System.out.println("Invalid choice");
               break;
       }
   }
   }
}
class f2 extends f1
{
    public static void main(String args[])
    {
           railwaymenu obj=new f2();
	   obj.Menu(); 
    }
}