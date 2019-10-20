#include <iostream>
#include <string>
#include <fstream>

using namespace std;

int recur(int n) {
	if (n > 1) return 4*(n-1) + recur(n - 1);
	else return 0;
}

int main()
{
	bool cont;

	do {
		cont = false;
		// continue loop begin

		int num;
		cin >> num;

		cout << recur(num);

		// continue loop end
		cout << endl << endl << "y to continue: ";
		char c;
		cin >> c;
		if (c == 'y' || c == 'Y') cont = true;
	} while (cont);

}
