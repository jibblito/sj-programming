#include <iostream>
#include <string>
#include <fstream>
#include <cmath>
#include <stack>
#include <vector>

#define COUNT 6

using namespace std;

struct TreeNode {

	int item;
	TreeNode* left;
	TreeNode* right;

	TreeNode(int item) {
		this->item = item;
		this->left = NULL;
		this->right = NULL;
	}
};

int countLevels(TreeNode* root) {
	if (root == NULL) return 0;
	int left = 1 + countLevels(root->left);
	int right = 1 + countLevels(root->right);
	return (right > left) ? right : left;
}

void treeInsert(TreeNode *&root, int item) {
	if (root == NULL) {
		root = new TreeNode(item);
		cout << item << " reached leaf, inserting" << endl;
		return;
	}
	else if (item < root->item) {
		treeInsert(root->left, item);
	}
	else {
		treeInsert(root->right, item);
	}
}

int countNodes(TreeNode* root) {
	if (root == NULL)
		return 0;
	else {
		int count = 1;
		count += countNodes(root->left);
		count += countNodes(root->right);
		return count;
	}
}

string binatize(int inp) {
	string s = "" + to_string(inp);
	for (int i = s.size(); i < 4; i++) {
		s = "0" + s;
	}
	return s;
}

string displayNodes(TreeNode* root) {
	string s = "";
	if (root == NULL) {
		s += "NULL";
	}
	else {
		s += binatize(root->item) + " " + displayNodes(root->left) + " " + displayNodes(root->right);
	}
	return s;
}

void print2DUtil(TreeNode* root, int space)
{
	// Base case  
	if (root == NULL)
		return;

	// Increase distance between levels  
	space += COUNT;

	// Process right child first  
	print2DUtil(root->right, space);

	// Print current node after space  
	// count  
	cout << endl;
	for (int i = COUNT; i < space; i++)
		cout << " ";
	cout << root->item << "\n";

	// Process left child
	print2DUtil(root->left, space);
}

int main()
{
	bool cont;
	string words[13] = { "ZERO", "ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX",
"SEVEN", "EIGHT", "NINE", "TEN", "ELEVEN", "TWELVE" };

	do {
		cont = false;
		// continue loop begin

		TreeNode* spaghetti = new TreeNode(7);

		while (true) {
			int inp;
			cout << "add node with value: ";
			cin >> inp;
			treeInsert(spaghetti, inp);
			cout << endl << inp << " Added" << endl << endl;

			print2DUtil(spaghetti, 0);
			cout << endl << endl << "Levels: " << countLevels(spaghetti);
			cout << endl << endl;


		}

		cout << "# of nodes in tree: "<< countNodes(spaghetti) << endl;

		cout << endl <<  displayNodes(spaghetti) << endl << "end count." << endl;

		print2DUtil(spaghetti, 0);


		/*vector<int> inputs;
		bool found = false;
		while (!found) {
			int num;
			cin >> s;
			if (s == 999) found = true;
			else inputs.push_back(s);
		}*/




		// continue loop end
		cout << endl << endl << "y to continue: ";
		char c;
		cin >> c;
		if (c == 'y' || c == 'Y') cont = true;
	} while (cont);
}
