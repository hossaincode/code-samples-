#include<iostream>
#include<map>
#include<vector>
#include<algorithm>
#include<set>
using namespace std;

map<std::string, vector<int> > amap;
map<std::string, vector<int> > globalfreq;
vector<int> intvector;
map<std::string, vector<int> >::iterator it;

void find(std::string str)
{
it = amap.find(str);
vector<int> intvec = it->second;
for(int i = 0; i < intvec.size(); i++)
{
cout << intvec[i] << "\t";
}
cout << endl;
}

void insert(std::string str, int number)
{
vector<int> numvector;
numvector.push_back(number);
amap[str] = numvector;
}
 void eclat( std::map<std::string, vector<int> > &P, int minsup,std::map<std::string, vector<int> > & F )
{
	for(map<std::string, vector<int> >::iterator it=P.begin();   it!=P.end();   ++it)
	{
		
		F[it->first]=it->second;
		map<std::string, vector<int> > temp;
		for(map<std::string, vector<int> >::iterator itse=++it;itse!=P.end(); ++itse)
		{
			std::string strcom = it->first+ itse->first;
			vector<int> v3;
			sort(it->second.begin(), it->second.end());
			sort(itse->second.begin(),itse->second.end());
			set_intersection(it->second.begin(),it->second.end(),itse->second.begin(),itse->second.end(),back_inserter(v3));
			
			if (v3.size()>=minsup)
			{
				temp[strcom]=v3;
				
			}
			
		
		}
		if(temp.size()!=0)
		{
			
		  eclat(temp,minsup,globalfreq);
		
		}
		
		
		
		
	}
	
	
 
 
}	
 

int main ()
{
	int minsup=2;
	insert("a", 1);
	insert("b", 2);
	insert("c", 1);
	insert("d", 1);
	insert("e", 2);
	amap["a"].push_back(3);
	amap["a"].push_back(5);
	amap["a"].push_back(6);
	
	
	amap["b"].push_back(3);
	amap["b"].push_back(4);
	amap["b"].push_back(5);
	amap["b"].push_back(6);
	
	amap["c"].push_back(2);
	amap["c"].push_back(3);
	amap["c"].push_back(5);
	amap["c"].push_back(6);
	
	amap["d"].push_back(4);
	amap["d"].push_back(6);
	
	
	amap["e"].push_back(3);
	amap["e"].push_back(4);
	amap["e"].push_back(5);
	map<std::string, vector<int> >::iterator it;
	for(it=amap.begin(); it != amap.end(); it++)
	{
		std::string str =it->first;
		cout<<str;
		vector<int> intvec = it->second;
		for (std::vector<int>::iterator itv = intvec.begin() ; itv != intvec.end(); ++itv)
		{
			std::cout << ' ' << *itv;
		
	
		}
		std::cout << '\n';
		
	}
    eclat(amap,2,globalfreq);
    map<std::string, vector<int> >::iterator itp;
  	for(itp=globalfreq.begin(); itp != globalfreq.end(); itp++)
	{
		std::string str =itp->first;
		cout<<str;
		vector<int> intvec = itp->second;
		for (std::vector<int>::iterator itn = intvec.begin() ; itn != intvec.end(); ++itn)
		{
			std::cout << ' ' << *itn;
		
	
		}
		std::cout << '\n';
		
	}
	
	


	//find("one");
	//find("two");
	//find("three");


	return 0;
}
