package controller;
import java.util.Scanner;
import dao.AdminDao;
import model.AdminModel;
import model.Exams;
import service.AdminDetails;
public class MainController {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
	   AdminDetails ad = new AdminDetails();
	   AdminDao adminDao = new AdminDao();
	   System.out.println("ONLINE EXAM SYSTEM");
	   System.out.println("User / Admin");
	   System.out.println("If you are an examinee Enter S");
	   System.out.println("If you are an Admin Enter A");
	   System.out.println();
	   char ch=sc.next().charAt(0);
	   sc.nextLine();
	   if(ch=='S'  || ch=='s')
	   {
		   Exams.takeExam();
	   }
	   else if(ch=='A' || ch=='a')
	   {
        boolean Login = true;
        while(Login) {
        	
        	System.out.println("\n1)Enter \n2)Exit");
//        	System.out.println("Enter S to take exam");
        	int option = Integer.parseInt(sc.nextLine());
        	switch(option) 
        	{
        	case 1:{
        		System.out.println("\n Admin Name: ");
        		String Name= sc.nextLine();
        		System.out.println("Passsword:");
        		String pwd = sc.nextLine();
        		if(Name.equals("vishnusankar")&&pwd.equals("7992"));{
        			System.out.println("Sucessfully Logged In");
        			 boolean temp = true;
        			 while(temp) {
        				 System.out.println("Choose the action to be performed");
        				 System.out.println("\n 1 Add Student Id  \n 2) view Student \n 3)Update  \n 4)Delete \n 5)Exit");
        				 boolean flag = true;
        				 int operation = 0;
        				 while(flag) {
        					 try {
        						 operation = Integer.parseInt(sc.nextLine());
        						 flag = false;
        					 }catch (Exception e) {
        						 System.out.println("Enter correct Number");
        						 flag = true;
        					 }
        				 }
        				 switch(operation) {
        				      ///ADD Student///
        				 case 1:{
        					 System.out.println("How Many Student want to add");
        					 int AdminAdd = Integer.parseInt(sc.nextLine());
        					   int StudentId = 0;
        					   String StudentName;
        					   int Marks;
        					   for(int i=0; i<AdminAdd;i++) {
        						   boolean id = true;
        						   while(id) {
        							   try {
        								  System.out.println("StudentId:"); 
        								  StudentId = Integer.parseInt(sc.nextLine());
        								  id= false;
        							   }catch(NumberFormatException e) {
        								   System.out.println("Enter Integer Type only");
        								   id= true;
        							   }
        						   }
        						   System.out.println("Student Name:");
        						   StudentName = sc.nextLine();
        						   System.out.println("Marks:");
        						   Marks = Integer.parseInt(sc.nextLine());
        						  
        						   
                            AdminModel admin = new AdminModel(StudentId,StudentName,Marks);
                              ad.AddAdminModel(admin);
                                 
        					   }
        				   break;
        				 }
        				 ////view///
        				 case 2:{
        	                adminDao.ViewAdminModel();
        	                 break;
        				 }
        				 //////////update/////
        				 case 3:{
        					 System.out.println("\n Enter the Id  to Upadte:");
        					 int UpdateStudentId = Integer.parseInt(sc.nextLine());
        					 boolean flag1= true;
        					 System.out.println("\n select any one of them to update");
        					 try {
        						 while(flag1) {
        							 System.out.println("\n 1)StudentName  \n7)Exit" );
        							 int Update = Integer.parseInt(sc.nextLine());
        							 switch(Update) {
        							 case 1:{
        								 System.out.println("\nEnter Student Name to update");
        								 String newStringName = sc.nextLine();
        						 adminDao.UpdateAdminModel(Update,UpdateStudentId,newStringName);
        								 break;
        							 }
        							 case 2:{
        								 System.out.println("\nEnter  Marks to update");
        								 String newMarksStudentName = sc.nextLine();
//        								 adminDao.UpdateAdminModel(Update,UpdateStudentId,newActorStudentName);
        								 break;

        							 }
     							

        							 case 7:{
        								 flag1= false;
        								 break;
        							 }
        							 }
        							
        						 }
        					 }catch(NumberFormatException e){
        						 System.out.println("\nEnter the correct number");
        						 flag1 = true;
        					 }
        					 break;
        				 }
        				 ////////////////Delete/////////
        				 case 4:{
        					 System.out.println("\n Enter the StudentId to be delete the record");
        					 int DeleteStudentId = 0;
        					 boolean flag2= true;
        					 while(flag2) {
        						 try {
        							 DeleteStudentId = Integer.parseInt(sc.nextLine());
        							
        							 flag2 =false;
        						 }catch(NumberFormatException e) {
        							 System.out.println("Enter the correctNumber");
        							 flag2= true;
        							 adminDao.DeleteAdminModel("delete");     
        						 }
        						 adminDao.DeleteAdminModel(DeleteStudentId);
        						 
        					 }
        					 break;
        				 }
        				 /////////////Exit////////
        				 case 5:{
        					 temp = false;
        					 break;
        				     }
        				 }
        				 
        			 }
        			
        		  }
      
             	}
        	}
        }
        }
	}

}
