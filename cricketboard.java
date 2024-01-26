import java.util.*;
class scoreboard{
	static Scanner sc=new Scanner(System.in);
	
	//DECLARING INSTANCE VARIABLES
	String teamA; String teamB; String player_name; String role; int runs; int wickets; boolean status; String coin; 
	String choose; String tosscoin; boolean innings; int scoreA; int scoreB; String tossA; String tossB; int wicket; 
	int balls; int match_ballsA; int match_ballsB; int target;
	public static void main(String args[]){
		
		//PRINTING THE RULES
		System.out.println("----------------------------------");
		System.out.println("----WELCOME TO CRICKET SCORING----");
		System.out.println("--------------RULES---------------");
		System.out.println("1. Enter no of players you want on \n   each side");
		System.out.println("2. Enter no of overs that you want");
		System.out.println("3. Only 1 player will come to bat \n   at a time from batting team");
		System.out.println("4. Only 1, 2, 3, 4, 5, 6 indicates \n   runs");
		System.out.println("5. w or W represents wicket");
		System.out.println("----------------------------------");
		System.out.println();
		
		//MAKE A NEW OBJECT OF CLASS
		scoreboard s=new scoreboard();
		
		//CALLING METHOD
		s.teamName();
		System.out.println();
		
		//TAKING ENTRY OF NO OF PLAYERS
		System.out.println("----------------------------------");
		System.out.print("Enter no of players on each team: ");
		int number=sc.nextInt();
		System.out.println("----------------------------------");
		
		//MAKING ARRAY AS NEW OBJECT FOR BOTH TEAMS
		scoreboard A[]=new scoreboard[number];
		scoreboard B[]=new scoreboard[number];
		System.out.println();
		
		//TAKING DETAILS OF BOTH TEAMS BY CALLING METHOD
		System.out.println("----------------------------------");
		System.out.println("------Enter details of team "+s.teamA+"-----");
		for(int i=0; i<=number-1; i++){
			A[i]=new scoreboard();
			A[i].playerDet(i+1);
		}
		System.out.println("----------------------------------");
		// System.out.println();
		// System.out.println("----------------------------------");
		System.out.println("------Enter details of team "+s.teamB+"-----");	
		for(int i=0; i<=number-1; i++){
			B[i]=new scoreboard();
			B[i].playerDet(i+1);
		}
		System.out.println("----------------------------------");
		System.out.println();
		
		//DISPLAYING DETAILS OF BOTH TEAMS BY CALLING METHOD
		System.out.println("----------------------------------");
		System.out.println("-------------TEAM "+s.teamA+"---------------");
		for(int i=0; i<=number-1; i++){
			A[i].display(i+1);
			System.out.println();
		}
		System.out.println("----------------------------------");
		System.out.println("-------------TEAM "+s.teamB+"---------------");		
		for(int i=0; i<=number-1; i++){
			B[i].display(i+1);
			System.out.println();
		}
		System.out.println("----------------------------------");
		System.out.println();
		
		//CALLING TOSS METHOD FOR TOSS
		s.toss(A,B,number);
		
		//CALLING SHOW METHOD 
		s.show(A,B,number);
	}
	
	//ENTERING NAMES OF BOTH TEAMS
	void teamName(){
		System.out.println("----------------------------------");
		System.out.println("--------ENTER NAME OF TEAMS-------");
		System.out.print("    Enter name of team 1: ");
		teamA=sc.nextLine();
		System.out.print("    Enter name of team 2: ");
		teamB=sc.nextLine();
		System.out.println("----------------------------------");
	}
	
	//ENTERING PLAYER DETAILS
	void playerDet(int i){
		sc.nextLine();
		System.out.println("----------------------------------");
		System.out.print("    Enter name of player "+i+": ");
		player_name=sc.nextLine();
		
		//ASKING FOR PLAYER ROLE
		System.out.println("     -Press 1 for batsman");
		System.out.println("     -Press 2 for bowler");
		System.out.println("     -Press 3 for all-rounder");
		int n=sc.nextInt();
		System.out.println("----------------------------------");
		System.out.println();
		switch(n){
			case 1:role="batsman";break;
			case 2:role="bowler";break;
			case 3:role="all-rounder";break;
		}	
		runs=0;
		balls=0;
		wickets=0;
		status=true;
	}
	
	//DISPLAYING PLAYER DETAILS
	void display(int i){
		System.out.println("     Player "+i+" name: "+player_name);
		System.out.println("     Player "+i+" role: "+role);
	}
	
	//TOSS USING RANDOM METHOD
	void toss(scoreboard A[], scoreboard B[], int number){
		System.out.println("----------------------------------");
		System.out.print("Team "+teamA+" choose heads/tails: ");
		tosscoin=sc.next();
		System.out.println();
		if(tosscoin.equals("heads")){
			System.out.println("Team "+teamA+": Heads");
			System.out.println("Team "+teamB+": Tails");
		}else{
			System.out.println("Team "+teamA+": Tails");
			System.out.println("Team "+teamB+": Heads");
		}
		
		//MATH.RANDOM METHOD USED FOR TOSS
		int tossResult = (int) (Math.random() * 2);
		String result;
		if(tossResult == 0){
			result = "Heads";
		}else{
			result = "Tails";
		}
		System.out.println();
		System.out.println("Coin toss result: " + result);
		
		//TEAMS ASKED WHAT TO CHOOSE AS PER WHO WON
		if(tosscoin.equalsIgnoreCase(result)){
			System.out.println("Team "+teamA+" won the toss."); 
			System.out.println();
			System.out.print(teamA+" choose(bat/bowl): ");
			choose=sc.next();
			System.out.println();
			if(choose.equalsIgnoreCase("bat")){
				System.out.println("Team "+teamA+" chose to bat."); tossA="bat";
				System.out.println("Team "+teamB+" will bowl."); tossB="bowl";System.out.println();
				startmatch(tossA,tossB,A,B,number);
			}else{
				System.out.println("Team "+teamA+" chose to bowl."); tossA="bowl";
				System.out.println("Team "+teamB+" will bat."); tossB="bat";System.out.println();
				startmatch(tossA,tossB,A,B,number);
			}
			
		}else{
			System.out.println("Team "+teamB+" won the toss.");
			System.out.println();
			System.out.print(teamB+" choose(bat/bowl): ");
			choose=sc.next();
			System.out.println();
			
			//STARTMATCH METHOD CALLED ACCORDING TO WHICH TEAM WILL BAT FIRST
			if(choose.equalsIgnoreCase("bat")){
				System.out.println("Team "+teamB+" chose to bat."); tossB="bat";
				System.out.println("Team "+teamA+" will bowl."); 
				System.out.println("----------------------------------");
				tossA="bowl";
				startmatch(tossA,tossB,A,B,number);
			}else{
				System.out.println("Team "+teamB+" chose to bowl."); tossB="bowl";
				System.out.println("Team "+teamA+" will bat."); 
				System.out.println("----------------------------------");
				tossA="bat";
				startmatch(tossA,tossB,A,B,number);
			}
		}
	}
	
	//METHOD TO START MATCH
	void startmatch(String tossA, String tossB, scoreboard A[], scoreboard B[], int number){
		System.out.print("Enter number of overs: ");
		int overs=sc.nextInt();
		if((tossA.equalsIgnoreCase("bat"))&&(tossB.equalsIgnoreCase("bowl"))){
			int a=0; int b=0;
			System.out.println("----------------------------------");
			System.out.println("----------Innings Start-----------");
			System.out.println("----------------------------------");
			System.out.println();
			System.out.println("Batsman on strike: "+A[a].player_name);
			System.out.println("Bowler: "+B[b].player_name);
			System.out.println();
			matchA(a,b,A,B,overs,tossA,tossB,number);
		}else{
			int a=0; int b=0;
			System.out.println("----------------------------------");
			System.out.println("----------Innings Start-----------");
			System.out.println("----------------------------------");
			System.out.println();
			System.out.println("Batsman on strike: "+B[a].player_name);
			System.out.println("Bowler: "+A[b].player_name);
			System.out.println();
			matchB(a,b,A,B,overs,tossA,tossB,number);
		}
	}
	
	//METHOD FOR TEAM A-BAT AND TEAM B-BOWL
	void matchA(int a, int b, scoreboard A[], scoreboard B[],int overs, String tossA, String tossB, int number){
		wicket=0;a=0;b=0;
		for(int i=0; i<=overs-1; i=i+1){
			if(wicket!=number){
				for(double j=i+0.1; j<i+0.7; j=j+0.1){
					if(wicket!=number){
						System.out.print("over "+(float)j+":");
						String run=sc.next();
						if(run.equalsIgnoreCase("w")){
							wicket++; match_ballsA++;
							B[b].wickets=wickets++; A[a].balls++;
							System.out.println();
							System.out.println(A[a].player_name+" out");
							System.out.println("Runs:"+A[a].runs+" Balls:"+A[a].balls);
							System.out.println("Strike Rate:"+(((A[a].runs)*100)/A[a].balls));
							System.out.println();
							if(wicket==number){
								System.out.println("Team all out"); break;
							}else{
								System.out.println("New batsman: "+A[++a].player_name);
								System.out.println();
							}
						}else if(Integer.parseInt(run)>=0&&Integer.parseInt(run)<7){
							A[a].runs=A[a].runs+Integer.parseInt(run);
							A[a].balls++;
							match_ballsA++;
							
							scoreA=Integer.parseInt(run)+scoreA;
						}else{
							scoreA=scoreA; match_ballsA++;
						}
					}
				}
			}
			System.out.println();
			System.out.println("Score: "+scoreA);
			System.out.println("Wickets: "+wicket); 
			System.out.println("Run Rate: "+(double)scoreA/(double)(i+1));
			System.out.println();
			if(match_ballsA==(6*overs)){
				wicket=number;
			}
			if(wicket==number){
				match_ballsA=6*overs;
			}
			if((match_ballsA!=(6*overs))||(wicket!=number)){
				System.out.println("New bowler: "+B[++b].player_name);
			}else{
				System.out.println("Innings over");
				target=scoreA+1;
				
			}
			System.out.println("----------------------------------");
			System.out.println();
		}
		nextInn(a,b,A,B,overs,tossA,tossB,target,number);
			
	}
	
	//METHOD FOR TEAM-B BAT AND TEAM-A BOWL
	void matchB(int a, int b, scoreboard A[], scoreboard B[], int overs,String tossA, String tossB,int number){
		wicket=0;a=0;b=0;
		for(int i=0; i<=overs-1; i=i+1){
			if(wicket!=number){
				for(double j=i+0.1; j<i+0.7; j=j+0.1){
					if(wicket!=number){
						System.out.print("over "+(float)j+":");
						String run=sc.next();
						int RUNS=0;
						if(run.equalsIgnoreCase("w")){
							wicket++; match_ballsB++;
							A[b].wickets=wickets++; B[a].balls++;
							System.out.println(B[a].player_name+" out");
							System.out.println();
							System.out.println("Runs:"+B[a].runs+" Balls:"+B[a].balls);
							System.out.println("Strike Rate:"+(((B[a].runs)*100)/B[a].balls));
							System.out.println();
							if(wicket==number){
								System.out.println("Team all out"); break;
							}else{		
								System.out.println("New batsman: "+B[++a].player_name);
							}
						}else if(Integer.parseInt(run)>=0&&Integer.parseInt(run)<7){
							B[a].runs=B[a].runs+Integer.parseInt(run);
							B[a].balls++; match_ballsB++;
							scoreB=Integer.parseInt(run)+scoreB;
						}else{
							scoreB=scoreB; match_ballsB++;
						}
					}
				}
			}
			System.out.println();
			System.out.println("Score: "+scoreB);
			System.out.println("Wickets: "+wicket);
			System.out.println("Run Rate: "+(double)scoreB/(double)(i+1));		
			System.out.println();
			if(match_ballsB==(6*overs)){
				wicket=number;
			}
			if(wicket==number){
				match_ballsB=6*overs;
			}
			if((match_ballsB!=(6*overs))||((wicket!=number))){
				System.out.println("New bowler: "+A[++b].player_name);
			}else{
				System.out.println("Innings over");
				target=scoreB+1;
				
			}
			System.out.println("----------------------------------");
			System.out.println();
		}
		nextInn(a,b,A,B,overs,tossA,tossB,target,number);
			
	}
	
	//METHOD TO VIEW FULL SCORECARD AND INDIVIDUAL STATS
	void show(scoreboard A[], scoreboard B[], int number){
		boolean b1=true;
		
		//WHILE LOOP UNTIL USER ENTERS 3 TO EXIT
		while(b1){
			System.out.println("Press 1 to view full scorecard");
			System.out.println("Press 2 to search a player's stats");
			System.out.println("Press 3 to exit");
			int z=sc.nextInt();
				switch(z){
					case 1:	System.out.println("--------------TEAM "+teamA+"--------------");
							for(int i=0; i<=number-1; i++){
								System.out.println((i+1)+"."+A[i].player_name+" Runs: "+A[i].runs+"  Balls: "+A[i].balls);
							}
							System.out.println();
							for(int i=0; i<=number-1; i++){
								System.out.println((i+1)+"."+B[i].player_name+" Wickets: "+B[i].wickets);
							}
							System.out.println();
							System.out.println("--------------TEAM "+teamB+"--------------");
							for(int i=0; i<=number-1; i++){
								System.out.println((i+1)+"."+B[i].player_name+" Runs: "+B[i].runs+"  Balls: "+B[i].balls);
							}
							System.out.println();
							for(int i=0; i<=number-1; i++){
								System.out.println((i+1)+"."+A[i].player_name+" Wickets: "+A[i].wickets);
							}
							System.out.println("----------------------------------");
							System.out.println();
							break;
							
							//STATS METHOD TO DISPLAY INDIVIDUAL PLAYER STATS
					case 2: stats(A,B,number); break;
					case 3: b1=false; break;
					default: b1=false;
			}
		}
	}
	
	//METHOD TO SEARCH FOR PLAYER AND DISPLAY STATS
	void stats(scoreboard A[], scoreboard B[],int n){
		System.out.println("Enter name of player: ");
		String p=sc.next();
		System.out.println();
		for(int i=0; i<n; i++){
			if((A[i].player_name).equalsIgnoreCase(p)){
				displayA(A,i);
				System.out.println();
			}
			
			if((B[i].player_name).equalsIgnoreCase(p)){
				displayB(B,i);
				System.out.println();
			}
		}
	}
	
	//METHOD TO DISPLAY STATS OF DESIRED PLAYER
	void displayA(scoreboard A[], int i){
		System.out.println("Player name: "+A[i].player_name);
		System.out.println("Runs scored: "+A[i].runs);
		System.out.println("Wickets taken: "+A[i].wickets);
		if(A[i].balls==0){
			System.out.println("Strike Rate: 0.0");
		}else{		
			System.out.println("Strike Rate: "+((A[i].runs/A[i].balls)*100));
		}
	}
	void displayB(scoreboard B[], int i){
		System.out.println("Player name: "+B[i].player_name);
		System.out.println("Runs scored: "+B[i].runs);
		System.out.println("Wickets taken: "+B[i].wickets);
		if(B[i].balls==0){
			System.out.println("Strike Rate: 0.0");
		}else{		
			System.out.println("Strike Rate: "+((B[i].runs/B[i].balls)*100));
		}
	}
	
	//METHOD FOR GOING FORWARD TO NEXT INNINGS PASSING ON TARGET TO BE CHASED
	void nextInn(int a, int b, scoreboard A[], scoreboard B[], int overs,String tossA, String tossB,int target,int number){
		if((tossA.equalsIgnoreCase("bat"))&&(tossB.equalsIgnoreCase("bowl"))){
			System.out.println("Target for team "+teamB+": "+target);
			System.out.println(); 
			chaseB(a,b,A,B,overs,tossA,tossB,target,number);
		}else{
			System.out.println("Target for team "+teamA+": "+target);
			System.out.println(); 
			chaseA(a,b,A,B,overs,tossA,tossB,target,number);
		}
	}
	
	//METHOD TO CHASE (TEAM-B BAT AND TEAM=A BOWL)
	void chaseB(int a, int b, scoreboard A[], scoreboard B[], int overs,String tossA, String tossB,int target, int number){
		System.out.println("----------------------------------");
		System.out.println("----------Innings Start-----------");
		System.out.println("----------------------------------");
		System.out.println();
		a=0;b=0;wicket=0;match_ballsB=0;
		System.out.println("Batsman on strike: "+B[a].player_name);
		System.out.println("Bowler: "+A[b].player_name);
		System.out.println();
		for(int i=0; i<=overs-1; i=i+1){
			if(wicket!=number){
				if(scoreB<=target){
					for(double j=i+0.1; j<i+0.7; j=j+0.1){
						if(wicket!=number){
							System.out.print("over "+(float)j+":");
							String run=sc.next();
							if(run.equalsIgnoreCase("w")){
								wicket++; match_ballsB++; 
								A[b].wickets=wickets++; B[a].balls++;
								System.out.println(B[a].player_name+" out");
								System.out.println("Runs: "+B[a].runs+" Balls: "+B[a].balls);
								System.out.println("Strike Rate: "+(((B[a].runs)*100)/B[a].balls));
								System.out.println();
								if(wicket==number){
									System.out.println("Team all out");
								}else{
									System.out.println("New batsman: "+B[++a].player_name);
								}
							}else if(Integer.parseInt(run)>=0&&Integer.parseInt(run)<7){
								B[a].runs=B[a].runs+Integer.parseInt(run);
								B[a].balls++;
								match_ballsB++;
								scoreB=Integer.parseInt(run)+scoreB;
								if(scoreB>=target){
									System.out.print("Team "+teamB+" won the match.");break;
								}
							}else{
								scoreB=scoreB; match_ballsB++;
							}
						}
					}
				}else{
					System.out.print("Team "+teamB+" won the match.");
					System.out.println();
					break;
				}
			}
			System.out.println();
			System.out.println("Score: "+scoreB);
			System.out.println("Wickets: "+wicket); 
			System.out.println("Run Rate: "+(double)scoreB/(double)(i+1));
			System.out.println();
			if(scoreB<target){
				if(match_ballsA==(6*overs)){
					wicket=number;
				}
				if(wicket==number){
					match_ballsB=6*overs;
				}
				if((match_ballsB!=(6*overs))||((wicket!=number))){
					System.out.println("New bowler: "+A[++b].player_name);
				}else{
					System.out.println("Team "+teamA+" won the match.");
					System.out.println();
				}
			}
			System.out.println();
		}
		if(scoreB<target){
			System.out.println("Team "+teamA+" won the match.");
			System.out.println();
		}
		System.out.println("----------------------------------");
	}
	
	//METHOD TO CHASE (TEAM A-BAT AND TEAM B-BOWL)
	void chaseA(int a, int b, scoreboard A[], scoreboard B[], int overs,String tossA, String tossB,int target,int number){
		System.out.println("----------------------------------");
		System.out.println("----------Innings Start-----------");
		System.out.println("----------------------------------");
		System.out.println();
		a=0; b=0; wicket=0; match_ballsA=0;
		System.out.println("Batsman on strike: "+A[a].player_name);
		System.out.println("Bowler: "+B[b].player_name);
		System.out.println();
		for(int i=0; i<=overs-1; i=i+1){
			if(wicket!=number){
				if(scoreA<=target){
					for(double j=i+0.1; j<i+0.7; j=j+0.1){
						if(wicket!=number){
							System.out.print("over "+(float)j+":");
							String run=sc.next();
							if(run.equalsIgnoreCase("w")){
								wicket++; match_ballsA++; 
								B[b].wickets=wickets++; A[a].balls++;
								System.out.println(A[a].player_name+" out");
								System.out.println("Runs: "+A[a].runs+" Balls: "+A[a].balls);
								System.out.println("Strike Rate: "+(((A[a].runs)*100)/A[a].balls));
								System.out.println();
								if(wicket==number){
									System.out.println("Team all out");
								}else{
									System.out.println("New batsman: "+A[++a].player_name);
								}
							}else if(Integer.parseInt(run)>=0&&Integer.parseInt(run)<7){
								A[a].runs=A[a].runs+Integer.parseInt(run);
								A[a].balls++;
								match_ballsA++;
								scoreA=Integer.parseInt(run)+scoreA;
								if(scoreA>=target){
									System.out.print("Team "+teamA+" won the match.");
									System.out.println();
									break;
								}
							}else{
								scoreA=scoreA; match_ballsA++;
							}
						}
					}
				}
			}
			System.out.println();
			System.out.println("Score: "+scoreA);
			System.out.println("Wickets: "+wicket); 
			System.out.println("Run Rate: "+(double)scoreA/(double)(i+1));
			System.out.println();
			if(scoreB<target){
				if(match_ballsA==(6*overs)){
					wicket=number;
				}
				if(wicket==number){
					match_ballsA=6*overs;
				}
				if((match_ballsA!=(6*overs))||((wicket!=number))){
					System.out.println("New bowler: "+B[++b].player_name);
				}else{
					System.out.println("Team "+teamB+" won the match.");
					System.out.println();
				}
			}
			System.out.println();
		}
		if(scoreA<target){
			System.out.println("Team "+teamB+" won the match.");
			System.out.println();
		}
		System.out.println("----------------------------------");
	}
}