import java.util.Scanner;
public class Main
{
	 
	static  String userPass[][]=new String[3][2];
	static  String listDish[][]=new String[10][2];
	static int totalDishadded=0;
    	public static void main(String[] args) {
        
	    userPass[0][0]="muthu";
	    userPass[0][1]="sudir";
	    Scanner sc=new Scanner(System.in);
		int Continuerun=0;
		while (Continuerun==0) { 
	    System.out.println("~~~~~~~~~~ Restaurant Management ~~~~~~~~~~");
	    System.out.println("1.Login");
	    System.out.println("2.Signup");
		System.out.println("0.Exit");
	    int choice=sc.nextInt();
		System.out.println();
	    switch (choice){
	        case 1:
			LoginPg();
			break;
			case 2:
			SignupPg();
			break;
			case 0:
			System.out.println();
			System.out.println();
			System.err.println("````` Program is closed `````");
			return;
			default:
			System.out.println();
			System.out.println();
			System.out.println("````` Enter correct memu again `````");
			System.out.println();
			break;
		}
	}
}
	static void LoginPg(){
		Scanner sc=new Scanner(System.in);
		int flag=1;
		while (flag==1) {
		
			System.out.print("USERNAME : ");
			String username=sc.next();
			System.out.print("PASSWORD : ");
			String password=sc.next();
			for(int i=0;i<userPass.length;i++){
				if(username.equals(userPass[i][0]) && password.equals(userPass[i][1])){
					System.out.println();
					System.out.println("`````` LOGIN SUCCESSFULLY ``````");
					System.out.println();
					MainMenu();
					return;
				}
			}
			System.out.println();
			System.out.println("````` Entered wrong username password `````");
			System.out.println();
			System.out.println("1.Re-login");
			System.out.println("2.Home page");
			System.out.println();
			flag=sc.nextInt();
			if (flag==2){
				return;
			}

			
		}
	}
	static void SignupPg(){
		System.out.println();
		System.out.println("~~~~~ Signup account ~~~~~");
		System.out.println();
		Scanner sc=new Scanner(System.in);
		System.out.print("USERNAME : ");
		String username=sc.next();
		System.out.print("PASSWORD : ");
		String password=sc.next();
		for(int i=0;i<userPass.length;i++){
			if(userPass[i][0]==null){
				userPass[i][0]=username;
				userPass[i][1]=password;
				System.out.println();
				System.out.println("````` Account is successfully created `````");
				System.out.println();
				System.out.println("~~~~~ Login into account ~~~~~");
				System.out.println();
				LoginPg();
				return;
			}
		}
		System.out.println("Number of admin account are full");
		System.out.println();
		System.out.println();

	}
	static void MainMenu(){
		Scanner sc=new Scanner(System.in);
		int Continuerun=1;
		while(Continuerun==1){
			System.out.println();
		System.out.println("1.List of dish");
		System.out.println("2.Add dish");
		System.out.println("3.Bill");
		System.out.println("4.Total sells");
		System.out.println("0.Logout");
		int choice=sc.nextInt();
		System.out.println();
		System.out.println();
		switch (choice) {
			case 1:
			System.out.println("~~~~~ Dish in menu ~~~~~");
			System.err.println();
				for(int i=0;i<listDish.length;i++){
					int sno=i+1;
					System.out.print(sno+". ");
					for(int j=0;j<2;j++){
						System.out.print(listDish[i][j]+" ");
					}
					System.out.println();
				}
				System.out.println();
				System.out.println();
				break;
			case 2:
				System.out.println("~~~~~ Add dish to menu ~~~~~");
				System.out.println();
				System.out.print("Number of dish to add : ");
				int Tdish=sc.nextInt();
				System.out.println();
				Tdish+=totalDishadded;
				if(Tdish<=listDish.length){
				for(int i=totalDishadded;i<Tdish;i++){
					for(int j=0;j<2;j++){
						int sno=i+1;
						if(j==0){
							System.out.println("Dish name "+sno+": ");
						}
						else{
							System.out.println("Dish price "+sno+": ");
						}
						listDish[i][j]=sc.next();
					}
				}
				System.out.println();
				System.out.println("`````` Dish are added to menu `````");
				System.out.println();
				totalDishadded+=Tdish;
			}
				else{
					System.err.println();
					System.out.println("````` Entered number is greater than total dish menu `````");
					System.err.println();
				}
				break;
			
				case 0:
			return;
				default:
				System.err.println("````` Enter correct memu again `````");
				System.out.println();
		}
	}
}
}
