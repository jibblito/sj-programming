#include <iostream>
#include <string>
#include <fstream>

using namespace std;

int main()
{
	bool cont;

	do {
		cont = false;
		float hour, miles, speed;
		cin >> hour;
		cin >> miles;
		cin >> speed;

		cout << hour << " " << miles << " " << speed << " ";

		if ((miles / speed) <= (float)hour) cout << "I will make it.";
		else cout << "I will be late.";



		cout << endl << endl << "Continue?: ";

		char c;
		cin >> c;
		if (c == 'y' || c == 'Y') cont = true;

	} while (cont);

}
