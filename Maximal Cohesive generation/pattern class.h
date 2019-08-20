#include<vector>
#include <iterator>

using namespace std;
class Pattern {
	public:
		vector<int> ids;     //it must be vector like transaction 
		vector<int> trans;
	
		getids()
		{
			for (std::vector<int>::iterator itv = ids.begin() ; itv != ids.end(); ++itv)
			{
				std::cout <<*itv;
		
			}
			std::cout <<' ';
		}
		getTrans()
		{
			for (std::vector<int>::iterator itv = trans.begin() ; itv != trans.end(); ++itv)
			{
				std::cout << ' ' << *itv;
			}
			std::cout << '\n';
		}
};

