#include<iostream>
using namespace std;
int votes1=0, votes2=0, votes3=0,votes4=0,votes5=0,votes6=0,votes7=0,votes8=0,spoiltvotes=0;
int vote;

int main()

{
   int i,n,age;
   cout<<"Enter the number of voters"<<endl;
   cin>>n;
   for (i=1;i<=n ;i++ )
   {
       cout<<"enter your age"<<endl;
       cin>>age;
       if(age>=18)
       {
           cout<<"you are eligible for voting"<<endl;
        cout<<"list of political parties in Maharashtra"<<endl;
        cout<<"1.BMK"<<endl;
        cout<<"2.IAADMK"<<endl;
        cout<<"3.CMK"<<endl;
        cout<<"4.DAMK"<<endl;
        cout<<"5.DKDK"<<endl;
        cout<<"6.AMKM"<<endl;
        cout<<"7.NSK"<<endl;
        cout<<"8.Others"<<endl;
        cout<<"select your political party"<<endl;
       }
       else
       {
           cout<<"your not eligible for voting"<<endl;
       }
    if(age>18)
    {
    cout<<"\n Enter your vote:\t";
      cin>>vote;
      switch(vote)
      {
         case 1: votes1++;
         break;

         case 2:votes2++;
         break;

         case 3:votes3++;
         break;

         case 4:votes4++;
         break;

         case 5:votes5++;
         break;

         case 6:votes6++;
         break;

         case 7:votes7++;
         break;

         case 8:votes8++;
         break;

         default:spoiltvotes++;
      }
    }

    }
cout<<"Number of votes for BMK:"<<votes1<<endl;
cout<<"Number of votes for IAADMK:"<<votes2<<endl;
cout<<"Number of votes for CMK:"<<votes3<<endl;
cout<<"Number of votes for DAMK:"<<votes4<<endl;
cout<<"Number of votes for DKDK:"<<votes5<<endl;
cout<<"Number of votes for AMKM:"<<votes6<<endl;
cout<<"Number of votes for NSK:"<<votes7<<endl;
cout<<"Number of votes for Others:"<<votes8<<endl;
cout<<"Number of spoilt votes"<< spoiltvotes;
return 0;
}
