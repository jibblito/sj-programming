#include <iostream>
#include <string>
#include <fstream>

using namespace std;

int main()
{
	bool cont;

	do {
		cont = false;

		float inp;
		cin >> inp;
		cout << 3.14159 * inp * inp * .75;


		cout << endl << endl << "Continue?: ";
		char c;
		cin >> c;
		if (c == 'y' || c == 'Y') cont = true;

	} while (cont);

}
