#include<iostream>
#include<list >
#include<vector>
#include<string>
#include<queue>
#include<stack>
#include<set>
#include <algorithm>
#include<map>
using namespace std;

class node{
	public:
	vector<int> nodeNum;
	vector<bool> content;
	list<int> adj;
	vector<bool> common;
	
};
int thresHold=2;
vector<node> Nodes;
vector<vector<int> > maximalCohesive;

std::map<string, vector<int> > visitedSubgraph;

int  isPresent(int nodeNo){
    bool flag=false;
 	int index;
 	for(int i=0;i<Nodes.size();i++){
 		if(Nodes[i].nodeNum[0]==nodeNo){
 			flag=true;
 			index=i;
 			break;
		 }
 		
	}
	if(flag==true){
		return index;
	}
	else{
		return -1;
	}
	
	
}
void addEdge(int src,int dest){
 	
 
	if(isPresent(src)!=-1){
		Nodes[isPresent(src)].adj.push_back(dest);
		
		if(isPresent(dest)!=-1){
				Nodes[isPresent(dest)].adj.push_back(src);
			
		}
		else{
				node Node;
				Node.nodeNum.push_back(dest);
				Node.adj.push_back(src);
				Nodes.push_back(Node);
		}
	}
	else{
		node Node;
		Node.nodeNum.push_back(src);
		Node.adj.push_back(dest);
		Nodes.push_back(Node);
		
		if(isPresent(dest)!=-1){
				Nodes[isPresent(dest)].adj.push_back(src);
			
		}
		else{
				node Node;
				Node.nodeNum.push_back(dest);
				Node.adj.push_back(src);
				Nodes.push_back(Node);
		}
		
		
	}
		
	
	
	
};
void addProfile(int index,string pro){
	vector<bool> temp;
	for(int i=0;i<pro.length();i++){
		if(pro[i]=='1'){
			temp.push_back(1);
		}
		else{
			temp.push_back(0);
		}
	}
	Nodes[index].content=temp;
	Nodes[index].common=temp;
}
bool isCohesive(node a, node b){
 	
 	int count =0;
	
		
	int limit;
		
	if(a.common.size()>b.common.size()){
			limit=b.common.size();
	}
	else{
		limit=a.common.size();
	}
	for(int i=0;i<limit;i++){
		if(a.common[i]&&b.common[i]){
			count++;
			
		}
		else{
			
		}
			
	}
	if(count >=thresHold){
			
		return true;
	}
	else{
		return false;
	}
		
}
bool contained(node a,node b ){
	for(int i=0;i<b.nodeNum.size();i++){
		if(b.nodeNum[i]==a.nodeNum[0]){
			return true;
		}
	}
	return false;
	
}


std::string getStringId(vector<int> a ){
	std::string Id;
	char ch;
	for (int i = 0; i < a.size(); i++) {

    	ch = a[i];

    	Id += ch;

	}
	return Id;
}
vector<int> generateNeighbour( node a){
	std::set<int> neighboursId;
	
	for(int i=0;i<a.nodeNum.size();++i)
	{
		 
		
		for (std::list<int>::iterator itv = Nodes[a.nodeNum[i]].adj.begin() ; itv != Nodes[a.nodeNum[i]].adj.end(); ++itv){
			neighboursId.insert(*itv);
		}
	
	
	}
	vector<int> neighbour(neighboursId.begin(),neighboursId.end());
	return neighbour;
	
}
node createNew(node a,node b){
	vector<bool> temp;
	int limit;
		
	if(a.common.size()>b.common.size()){
			limit=b.common.size();
	}
	else{
		limit=a.common.size();
	}
	for(int i=0;i<limit;i++){
		if(a.common[i]&&b.common[i]){
			temp.push_back(1);
			
		}
		else{
			temp.push_back(0);
		}
			
	}
	node c;
	c.nodeNum.insert(c.nodeNum.begin(),b.nodeNum.begin(),b.nodeNum.end());
	c.nodeNum.push_back(a.nodeNum[0]);
	c.common=temp;
	return c;
}
void genMCS(node first){

	std::sort(first.nodeNum.begin(), first.nodeNum.end());
	
	std::string idString = getStringId(first.nodeNum);
	if(visitedSubgraph[idString]==first.nodeNum){
		return;
	}
	visitedSubgraph[idString]=first.nodeNum;	
	
	
	bool maxFlag;
	maxFlag=true;
	

	vector<int> neighbour;
	neighbour=generateNeighbour(first);
	
   for(int i=0;i<neighbour.size();i++)
	{		
		if(!contained(Nodes[neighbour[i]],first)){
			if(isCohesive(Nodes[neighbour[i]],first)){
				maxFlag=false;
				node temp=createNew(Nodes[neighbour[i]],first);
				genMCS(temp);
			
			}
	
	
	
	
		}
			
				
	}
	
	  
	

	if(maxFlag==true){
		maximalCohesive.push_back(first.nodeNum);
	}
}
	

int main(){
	addEdge(0,1);
	addEdge(0,2);
	addEdge(2,3);
	addEdge(1,4);
	addEdge(4,5);
	addEdge(3,6);
	
	
	addProfile(0,"1011");
	addProfile(1,"1111");
	addProfile(2,"1010");
	addProfile(3,"1111");
	addProfile(4,"1100");
	addProfile(5,"1110");
	addProfile(6,"0001");
	
	
	for(int i=0;i<Nodes.size();i++){
			for(std::vector<int>::iterator itv=Nodes[i].nodeNum.begin();itv!=Nodes[i].nodeNum.end();++itv)
			{
				std::cout<<*itv;
				
			}
			for (std::list<int>::iterator itv = Nodes[i].adj.begin() ; itv != Nodes[i].adj.end(); ++itv)
			{
				std::cout << ' ' << *itv;
			}
			
			cout<<"Binary :";
		/*	for (std::vector<bool>::iterator itv = Nodes[i].content.begin() ; itv != Nodes[i].content.end(); ++itv)
			{
				
				std::cout << *itv;
			}*/
			for(int j=0;j<Nodes[i].content.size();j++){
				cout<<Nodes[i].content[j];
			}
			cout<<endl;
			
			
   	}
   	for(int i=0;i<Nodes.size();i++){
   		genMCS(Nodes[i]);
   		
	}

   for(int i=0;i<maximalCohesive.size();i++){
			for(std::vector<int>::iterator itv=maximalCohesive[i].begin();itv!=maximalCohesive[i].end();++itv)
			{
				std::cout<<*itv;
				
			}
			cout<<endl;
		}

	return 0;

	
}
