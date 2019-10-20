#include <iostream>
#include <string>
#include <fstream>
#include <cmath>
#include <stack>
#include <vector>

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

		while (true) {
			int test;
			char choice;
			cin >> test;
			cin >> choice;

			if (test == 0 && choice == '0') break;

			switch (choice) {
				case '0': {
					if (test % 2 == 0) test += 1;
					cout << test + 1 << endl;
					break;
				}
				case '1': {
					vector<int> primes;
					primes.push_back(3);
					primes.push_back(2);
					for (int i = 5; i < (int)sqrt(test); i += 2) {
						bool broken = false;
						for (int j : primes) {
							broken = true;
							if (i % j == 0) break;
							broken = false;
						}
						if (!broken) {
							primes.push_back(i);
						}
					}

					bool looking = true;
					while (looking) {
						test += 1;
						bool broken = false;
						for (int i : primes) {
							broken = true;
							if ((test % i) == 0) break;
							broken = false;
						}
						if (!broken) break;
					}
					cout << endl << endl << "result: " << test << endl << endl;
					break;
				}
				case '2': {
					bool looking = true;
					test++;
					while (looking) {
						if (fmod(sqrt(test),1) == 0) {
							looking = false;
							break;
						}
						test++;
					}
					cout << test << endl;
					break;
				}

				case '3': {
					bool looking = true;
					test++;
					while (looking) {
						if (fmod(cbrt(test),1) == 0) {
							looking = false;
							break;
						}
						test++;
					}
					cout << test << endl;
					break;
				}
			}

		}
		int num;
		cin >> num;

		cout << pow(num,1.0f/3.0f);

		// continue loop end
		cout << endl << endl << "y to continue: ";
		char c;
		cin >> c;
		if (c == 'y' || c == 'Y') cont = true;
	} while (cont);

}
