import java.io.*;
class Main
{
	public static void main(String args[])throws Exception
	{  
	
	   // FileReader FP=new FileReader(args[0]);
	FileReader FP=new FileReader("Input.txt");
	BufferedReader bufferedReader = new BufferedReader(FP);		
	
	String line=null;
	String line2=null;
	
	int line_count=0,LC=0,LC1=0,symTabLine=0,opTabLine=0,litTabLine=0,poolTabLine=0,MachineTabLine=0;
		  
		 //Data Structures
		 final int MAX=100;
		 String SymbolTab[][]=new String[MAX][3];
		 String OpTab[][]=new String[MAX][3];
		 String LitTab[][]=new String[MAX][2];
		 int PoolTab[]=new int[MAX];
		 String Machine[][] = new String[MAX][4];
		 int litTabAddress=0;
/*---------------------------------------------------------------------------------------------------*/
		 
		 System.out.println("___________________________________________________");
		 while((line = bufferedReader.readLine()) != null)
		 {
		 //   String[] tokens = line.split("\t");
		 String tokens[] = line.split("[\t ]+");
		 if(line_count==0)
		 {
		 LC=Integer.parseInt(tokens[2]);	
		 LC=LC-1;
                //set LC to operand of START
		 for(int i=0;i<tokens.length;i++)		//for printing the input program
		 System.out.print(tokens[i]+"\t");
		 System.out.println("");
		 }
		 else
		 {
if(tokens[1].equalsIgnoreCase("START")||tokens[1].equalsIgnoreCase("END")||tokens[1].equalsIgnoreCase("ORIGIN")||tokens[1].equalsIgnoreCase("EQU")||tokens[1].equalsIgnoreCase("LTORG"))		//if Assembler Directive
		{     
		 
					  LC = LC-1;
					  //Because we don't count assembler directives
					}
			     	 for(int i=0;i<tokens.length;i++) //for printing the input program
			     	 System.out.print(tokens[i]+"\t");
			     	 System.out.println("");
			     	if(!tokens[0].equals(""))
			     	{
			 
			     		//Inserting into Symbol Table
			     		SymbolTab[symTabLine][0]=tokens[0];
			     		SymbolTab[symTabLine][1]=Integer.toString(LC);
			     		SymbolTab[symTabLine][2]=Integer.toString(1);
			     		symTabLine++;
			     	}
				else if(tokens[1].equalsIgnoreCase("DS")||tokens[1].equalsIgnoreCase("DC"))
				{
					//Entry into symbol table for declarative statements
				SymbolTab[symTabLine][0]=tokens[0];
			     	SymbolTab[symTabLine][1]=Integer.toString(LC);
			     	SymbolTab[symTabLine][2]=Integer.toString(1);
			     	symTabLine++;
				}
				
				//Entry of literals into literal table
                if(tokens.length>=2 && tokens[1].charAt(0)=='=')
				{
					
					LitTab[litTabLine][0]=tokens[1];
			     		LitTab[litTabLine][1]=Integer.toString(LC);
			     		litTabLine++;
			     
			     	
				}
				
				
				else if(tokens[1]!=null)
				{   
				    
				    
						//Entry of Mnemonic in opcode table
					OpTab[opTabLine][0]=tokens[1];
					
if(tokens[1].equalsIgnoreCase("START")||tokens[1].equalsIgnoreCase("END")||tokens[1].equalsIgnoreCase("ORIGIN")||tokens[1].equalsIgnoreCase("EQU")||tokens[1].equalsIgnoreCase("LTORG"))		//if Assembler Directive
					{      
					        //Opems Opcode File
			FileReader FP2=new FileReader("opcode.txt");
			BufferedReader bufferedReader1 = new BufferedReader(FP2);
			OpTab[opTabLine][1]="AD";
			while((line2 = bufferedReader1.readLine()) != null)
		                    {  
		                      String a = tokens[1];
		     	              String OPS[] = line2.split("[\t ]+");
		     	              String b=OPS[0];
		     	     
		     	              if(b.equalsIgnoreCase(a))
		     	              {
		     	                   
		     	                   OpTab[opTabLine][2]=OPS[1];	
		     	                   break;
		     	              }
		     	             
		                    }
		     bufferedReader1.close();
						  		
					}			     	
		else if(tokens[1].equalsIgnoreCase("DS")||tokens[1].equalsIgnoreCase("DC"))
					{
				OpTab[opTabLine][1]="DL";
				OpTab[opTabLine][2]="R#7";					
					}
					else
					{   
					     //Opens Opcode File
			        FileReader FP2=new FileReader("opcode.txt");
	                        BufferedReader bufferedReader1 = new BufferedReader(FP2);
	     			OpTab[opTabLine][1]="IS";
	     			while((line2 = bufferedReader1.readLine()) != null)
		                   {  
	                      String a = tokens[1];
	     	              String OPS[] = line2.split("[\t ]+");
	     	              String b=OPS[0];
	     	     
	     	              if(b.equalsIgnoreCase(a))
		     	              {
		     	                   
	    	               
	     	                   OpTab[opTabLine][2]="("+OPS[1]+",1)";	
	     	                   break;
		     	              }
		     	             
		                   }  
				   bufferedReader1.close();
						
						
					}
		     	opTabLine++;
				}
		        }
	        line_count++;
	        LC++;
		    }   

		System.out.println("___________________________________________________");  
		//print symbol table
		System.out.println("\n\n	SYMBOL TABLE		");
		System.out.println("--------------------------");			
		System.out.println("SYMBOL\tADDRESS\tLENGTH");
		System.out.println("--------------------------");			
		for(int i=0;i<symTabLine;i++)
		System.out.println(SymbolTab[i][0]+"\t"+SymbolTab[i][1]+"\t"+SymbolTab[i][2]);
		System.out.println("--------------------------");

			//print opcode table
		System.out.println("\n\n	OPCODE TABLE		");
		System.out.println("----------------------------");			
		System.out.println("MNEMONIC\tCLASS\tINFO");
		System.out.println("----------------------------");			
		for(int i=0;i<opTabLine;i++)
		System.out.println(OpTab[i][0]+"\t\t"+OpTab[i][1]+"\t"+OpTab[i][2]);
		System.out.println("----------------------------");

			//print literal table
		System.out.println("\n\n   LITERAL TABLE		");
		System.out.println("-----------------");			
		System.out.println("LITERAL\tADDRESS");
		System.out.println("-----------------");			
		for(int i=0;i<litTabLine;i++)
		System.out.println(LitTab[i][0]+"\t"+LitTab[i][1]);
		System.out.println("------------------");
	

			//intialization of POOLTAB
		for(int i=0;i<litTabLine;i++)
		{
		if(LitTab[i][0]!=null && LitTab[i+1][0]!=null ) //if literals are present
		{
		if(i==0)
					{
						PoolTab[poolTabLine]=i;
						poolTabLine++;
					}
		else if(Integer.parseInt(LitTab[i][1])<(Integer.parseInt(LitTab[i+1][1]))-1)
					{	
						PoolTab[poolTabLine]=i+1;
						poolTabLine++;
					}
				}
			}
			//print pool table
		System.out.println("\n\n   POOL TABLE		");
		System.out.println("-----------------");			
		System.out.println("LITERAL NUMBER");
		System.out.println("-----------------");			
		for(int i=0;i<poolTabLine;i++)
		System.out.println(PoolTab[i]);
		System.out.println("------------------");
			
		
		    
		    // Always close files.
		    bufferedReader.close();
		    
		    //Machine CODE Generation Pass2
		    System.out.println("___________________________________________________");
		    line_count=0;
		    FileReader FP6=new FileReader("Input.txt");
		    BufferedReader bufferedReader3 = new BufferedReader(FP6);
		    while((line = bufferedReader3.readLine()) != null)
		     {
		     	 String tokens1[] = line.split("[\t ]+");
		     	if(line_count==0)
		     	{
	     		LC1=Integer.parseInt(tokens1[2]);	
	     		LC1=LC1-1;
		     	}
		     	else if(tokens1[1]!=null)
		     	{
   	if(tokens1[1].equalsIgnoreCase("END")||tokens1[1].equalsIgnoreCase("ORIGIN")||tokens1[1].equalsIgnoreCase("EQU")||tokens1[1].equalsIgnoreCase("LTORG")||tokens1[1].equalsIgnoreCase("DS")||tokens1[1].equalsIgnoreCase("DC"))		//if Assembler Directive
					{
 			    Machine[MachineTabLine][0]=Integer.toString(LC1);
			    Machine[MachineTabLine][1]=" ";
			    Machine[MachineTabLine][2]=" ";
			    Machine[MachineTabLine][3]=" ";
					}
			else if(!tokens1[1].equalsIgnoreCase("START"))
			      	{
			      	
		           FileReader FP7=new FileReader("opcode.txt");
		           BufferedReader bufferedReader4 = new BufferedReader(FP7);
			   Machine[MachineTabLine][0]=Integer.toString(LC1);
			   while((line2 = bufferedReader4.readLine()) != null)
		                    {  
		                      String a = tokens1[1];
		     	              String OPS[] = line2.split("[\t ]+");
		     	              String b=OPS[0];
		     	     
		     	              if(b.equalsIgnoreCase(a))
		     	              {
		     	                   Machine[MachineTabLine][1]=OPS[1];	
		     	                   break;
		     	              }
		             }
		             bufferedReader4.close();//Closing File
		             if(tokens1.length>2)
		     	     {
		              FileReader FP11=new FileReader("opcode.txt");
		              BufferedReader bufferedReader5 = new BufferedReader(FP11);
				      Machine[MachineTabLine][0]=Integer.toString(LC1);
				      while((line2 = bufferedReader5.readLine()) != null)
                      {         
                              //For Registers
		     	              String OPS[] = line2.split("[\t ]+");
		     	              String e=OPS[0];
		     	              String c= tokens1[2];
		     	            if(c.length()>1)
		     	            {
		     	                    String d = c.substring(0,4);         if(e.equalsIgnoreCase(d)||tokens1[2].equalsIgnoreCase(d)||tokens1[2].equalsIgnoreCase("CREG,"))
		                           {
		                             Machine[MachineTabLine][2]=OPS[1];
		                           }    
		     	            }
		     	                //For symbols
	     	                char f = c.charAt(0);
	                        String j =Character.toString(f);
	                        for(int i=0;i<symTabLine;i++)
	                        {
	     	                 if((j.equalsIgnoreCase(SymbolTab[i][0])))
	     	                 {   
     	                      if(tokens1.length==3)
     	                      {
     	                          Machine[MachineTabLine][2]="0";
     	                          Machine[MachineTabLine][3]=SymbolTab[i][1];
     	                      }   
		     	                 }
		     	            }    
		     	        }      
		     	     bufferedReader5.close();         
                    }
		            if(tokens1.length>3)
		              {
		                    String d =tokens1[3];
		     	            for(int i=0;i<symTabLine;i++)
		                    {
		     	                 if((d.equalsIgnoreCase(SymbolTab[i][0])))
		     	                 {
		     	                      Machine[MachineTabLine][3]=SymbolTab[i][1];
		     	                 }
		     	            }
		               }
		                    
		    
				    }
				 
				     if(tokens1.length>=2 && tokens1[1].charAt(0)=='=')
				    {
				    char lits =tokens1[1].charAt(2);
		  	            Machine[MachineTabLine][0]=Integer.toString(LC1);
				    Machine[MachineTabLine][1]="00";
				    Machine[MachineTabLine][2]="0";
				    Machine[MachineTabLine][3]="00"+lits;
				    }
			     	    MachineTabLine++;
				}
				line_count+=1;
		     	LC1+=1;
		     	}
	  	     System.out.println("\n\n   MACHINE CODE 		");
		     System.out.println("-----------------");			
		       			
			for(int i=0;i<MachineTabLine;i++)
System.out.println(Machine[i][0]+"\t"+Machine[i][1]+"\t"+Machine[i][2]+"\t"+Machine[i][3]);
			System.out.println("------------------");
		     	bufferedReader3.close();
		     }
	}
