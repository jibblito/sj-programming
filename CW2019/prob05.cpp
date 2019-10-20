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
		
		int height;
		cin >> height;

		int sum = 0;

		for (int i = height; i > 0; i--) {
			sum += i * i;
		}

		cout << sum;

		// cont loop
		cout << endl << endl << "y to continue: ";
		char c;
		cin >> c;
		if (c == 'y' || c == 'Y') cont = true;
	} while (cont);

}
