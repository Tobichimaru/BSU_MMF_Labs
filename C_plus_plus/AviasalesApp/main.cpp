#include <iostream>
#include <cstdlib>
#include <string>
#include <sstream>
#include <cstddef>

using namespace std;

struct date 
{
    int day;
    int month;
    int year;
    
    date() {}
    date(int d, int m, int y) : day(d), month(m), year(y) {}
};

struct Ticket {
    int flight_number;
    std::string destination;
    std::string passenger_name;
    date departure_time;

    Ticket() {}
    
    Ticket(int flight, std::string dest, std::string name, date time) :
        flight_number(flight), destination(dest), passenger_name(name), 
        departure_time(time) {}    
        
    std::string to_string() 
    {
        std::ostringstream temp;
        temp << " Flight number: " << flight_number 
            << "\n Destination: " << destination
            << "\n Passenger: " << passenger_name
            << "\n Depature time: " << departure_time.day << " " 
            << departure_time.month << " " << departure_time.year<< "\n";
        return temp.str();
    }    
};

struct node
{
  Ticket key_value;
  node* left;
  node* right;
};

class BinaryTree
{
    public:
        BinaryTree() 
        {
            root=NULL;
        }
        
        ~BinaryTree() 
        {
            root=NULL;
        }

        void insert(Ticket key_value) 
        {
            if(root!=NULL)
                insert(key_value, root);
            else
            {
                root=new node;
                root->key_value=key_value;
                root->left=NULL;
                root->right=NULL;
            }
        }
        
        Ticket search(int flight) 
        {
            return search(flight, root)->key_value;
        }
        
        void print_all() 
        {
            print(root);
        }
        
        void print_date(date time) 
        {
            print_date(root, time);
        }
        
        bool deleteElem(int flight) 
        {
            return (deleteElem(root, flight) != NULL);
        }
        
        void destroy_tree() 
        {
            destroy_tree(root);
        }

    private:
        void print(node *leaf) 
        {
            if(leaf!=NULL)
            {
              print(leaf->left);
              print(leaf->right);
              cout << leaf->key_value.to_string() << endl;
            }
        }
        
        void print_date(node *leaf, date time) 
        {
            if(leaf!=NULL)
            {
              print_date(leaf->left, time);
              print_date(leaf->right, time);
              if (leaf->key_value.departure_time.day == time.day &&
                  leaf->key_value.departure_time.month == time.month &&
                  leaf->key_value.departure_time.year == time.year)
                cout << leaf->key_value.to_string() << endl;
            }
        }
        
        
        void destroy_tree(node *leaf)
        {
            if(leaf!=NULL)
            {
              destroy_tree(leaf->left);
              destroy_tree(leaf->right);
              delete leaf;
            }
        }
        
        void insert(Ticket key_value, node *leaf)
        {
            if (key_value.flight_number < leaf->key_value.flight_number)
            {
                if(leaf->left!=NULL)
                    insert(key_value, leaf->left);
                else
                {
                    leaf->left=new node;
                    leaf->left->key_value=key_value;
                    leaf->left->left=NULL;    //Sets the left child of the child node to null
                    leaf->left->right=NULL;   //Sets the right child of the child node to null
                }  
            }
            else if (key_value.flight_number >= leaf->key_value.flight_number)
            { 
                if(leaf->right!=NULL)
                    insert(key_value, leaf->right);
                else
                {
                    leaf->right=new node;
                    leaf->right->key_value=key_value;
                    leaf->right->left=NULL;  //Sets the left child of the child node to null
                    leaf->right->right=NULL; //Sets the right child of the child node to null
                }
            }
        }
        node* search(int key_value, node *leaf) 
        {
            if(leaf!=NULL)
            {
              if (key_value == leaf->key_value.flight_number)
                return leaf;
              if (key_value < leaf->key_value.flight_number)
                return search(key_value, leaf->left);
              else
                return search(key_value, leaf->right);
            }
            else return NULL;
        }
        
        node* deleteElem(node* root, int flight) {
            node* save;
            if(root == NULL) {
                cout << "element not in the tree!" << endl;
                return NULL;
            }
            if(root->key_value.flight_number == flight) {
                if(root->right == NULL && root->left == NULL) {                  // no child
                    free(root);
                    return NULL;
                }
                else if(root->right == NULL || root->left == NULL) {             // one child
                    if(root->right == NULL) {
                        save = root->left;
                        free(root);
                        return save;
                    }
                    else {
                        save = root->right;
                        free(root);
                        return save;
                    }
                }
                else {                                                             // two children
                    save = findPred(root->left);
                    root->key_value.flight_number = save->key_value.flight_number;
                    root->left = deleteElem(root->left, root->key_value.flight_number);
                    return root;
                }
            }
            else if(root->key_value.flight_number < flight) {
                root->right = deleteElem(root->right, flight);
            }
            else if(root->key_value.flight_number > flight) {
                root->left = deleteElem(root->left, flight);
            }
            return root;
        }
        
        node* findPred(node* root) {
            static node* pred;
            if(root == NULL) {
                return pred;
            }
            else {
                pred = root;
                return findPred(root->right);
            }
        }
        
        node *root;
};


int main(int argc, char** argv) {
    BinaryTree tree;
    tree.insert(Ticket(3, "Boston", "Mr.Smith", date(2, 5, 2016)));
    tree.insert(Ticket(1, "London", "Mr.Black", date(8, 5, 2016)));
    tree.insert(Ticket(5, "Moscow", "Mrs.White", date(2, 5, 2016)));
    tree.insert(Ticket(2, "Riga", "Mr.Kormen", date(8, 5, 2016)));
    tree.insert(Ticket(4, "Minsk", "Mrs.Johnson", date(2, 5, 2016)));
    
    cout << "All tickets: " << endl;
    tree.print_all();
    cout << "-----------------------------------------------------" << endl;
    
    cout << "Tickets on date 2.05.2016: " << endl;
    tree.print_date(date(2, 5, 2016));
    cout << "-----------------------------------------------------" << endl;
    
    cout << "Ticket with flight number 4: " << endl;
    Ticket ticket = tree.search(4);
    cout << ticket.to_string() << endl;
    cout << "-----------------------------------------------------" << endl;
    
    cout << "Deleted tickets with flight number 4 and 3: " << endl;
    tree.deleteElem(4);
    tree.deleteElem(3);
    tree.print_all();
    cout << "-----------------------------------------------------" << endl;
    
    cout << "Tree destroyed: " << endl;
    tree.destroy_tree();
    tree.print_all();
    return 0;
}

