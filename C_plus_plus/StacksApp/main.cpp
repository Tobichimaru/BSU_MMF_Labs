#include <cstdlib>
#include <string>
#include <iostream>

using namespace std;
 
class Stack {
 private:
      int top;
      int capacity;
      int *storage;
      
 public:
      Stack(int capacity) {
            if (capacity <= 0)
                  throw string("Stack's capacity must be positive");
            storage = new int[capacity];
            this->capacity = capacity;
            top = -1;
      }
 
      void push(int value) {
            if (top == capacity)
                  throw string("Stack's underlying storage is overflow");
            top++;
            storage[top] = value;
      }
 
      int peek() {
            if (top == -1)
                  throw string("Stack is empty");
            return storage[top];
      }
 
      void pop() {
            if (top == -1)
                  throw string("Stack is empty");
            top--;
      }
 
      bool isEmpty() {
            return (top == -1);
      }
 
      ~Stack() {
            delete[] storage;
      }
};


int main(int argc, char** argv) {
    int n;
    cout << "Print the number of elements: " << endl;
    cin >> n;
    if (n <= 0) {
        cout << "N should be positive!" << endl;
        return 0;
    }
    
    cout << "Print elements x1 x2 ... xN: " << endl;
    int* x = new int[n];
    for (int i = 0; i < n; i++) {
        cin >> x[i];
    }
    
    Stack first(n);
    Stack second(n);
    for (int i = 0; i < n; i++) {
        first.push(x[i]);
        second.push(x[n-i-1]);
    }
    
    long result = 0;
    while (!first.isEmpty()) {
        result += first.peek()*second.peek();
        first.pop();
        second.pop();
    }
    cout << "Result: " << result << endl;
    
    return 0;
}

