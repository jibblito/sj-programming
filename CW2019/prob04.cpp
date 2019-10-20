#include <iostream>
#include <string>
#include <fstream>

using namespace std;

int main()
{
	bool cont;

	do {
		cont = false;
		// cont loop
		
		int runs;
		cin >> runs;

		for (int i = 0; i < runs; i++) {
			float tax, price;
			cin >> tax;
			cin >> price;

			tax /= 100;

			float pretax_price = price / (1 + tax);
			float taxorig = pretax_price * tax;

			cout << "On your $" << roundf(price*100)/100 << " purchase, the tax amount was " << roundf(taxorig*100)/100 << endl;

		}






		// cont loop
		cout << endl << endl << "Continue?: ";
		char c;
		cin >> c;
		if (c == 'y' || c == 'Y') cont = true;
	} while (cont);

}
