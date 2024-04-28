#include<iostream>
#include<fstream>
#include<string>

using namespace std;

// Structure to hold student information
struct Student {
    int rollNumber;
    string name;
    string division;
    string address;
};

// Function to add a new student record to the file
void addStudent() {
    ofstream outfile("student_records.txt", ios::app);
    Student newStudent;
    
    cout << "Enter roll number: ";
    cin >> newStudent.rollNumber;
    cout << "Enter name: ";
    cin.ignore();
    getline(cin, newStudent.name);
    cout << "Enter division: ";
    getline(cin, newStudent.division);
    cout << "Enter address: ";
    getline(cin, newStudent.address);
    
    // Write the student information to the file
    outfile << newStudent.rollNumber << "," << newStudent.name << "," << newStudent.division << "," << newStudent.address << endl;
    
    cout << "Student record added successfully." << endl;
    outfile.close();
}

// Function to delete a student record from the file
void deleteStudent(int rollNumber) {
    ifstream infile("student_records.txt");
    ofstream outfile("temp.txt");
    Student temp;
    bool found = false;
    
    while (infile >> temp.rollNumber >> temp.name >> temp.division >> temp.address) {
        if (temp.rollNumber != rollNumber) {
            outfile << temp.rollNumber << "," << temp.name << "," << temp.division << "," << temp.address << endl;
        } else {
            found = true;
        }
    }
    
    infile.close();
    outfile.close();
    
    remove("student_records.txt");
    rename("temp.txt", "student_records.txt");
    
    if (found) {
        cout << "Student record deleted successfully." << endl;
    } else {
        cout << "Student record not found." << endl;
    }
}

// Function to display information of a particular student
void displayStudent(int rollNumber) {
    ifstream infile("student_records.txt");
    Student temp;
    bool found = false;
    
    while (infile >> temp.rollNumber >> temp.name >> temp.division >> temp.address) {
        if (temp.rollNumber == rollNumber) {
            cout << "Roll Number: " << temp.rollNumber << endl;
            cout << "Name: " << temp.name << endl;
            cout << "Division: " << temp.division << endl;
            cout << "Address: " << temp.address << endl;
            found = true;
            break;
        }
    }
    
    if (!found) {
        cout << "Student record not found." << endl;
    }
    
    infile.close();
}

int main() {
    int choice;
    int rollNumber;
    
    do {
        cout << "\n1. Add student record\n";
        cout << "2. Delete student record\n";
        cout << "3. Display student record\n";
        cout << "4. Exit\n";
        cout << "Enter your choice: ";
        cin >> choice;
        
        switch(choice) {
            case 1:
                addStudent();
                break;
            case 2:
                cout << "Enter roll number of student to delete: ";
                cin >> rollNumber;
                deleteStudent(rollNumber);
                break;
            case 3:
                cout << "Enter roll number of student to display: ";
                cin >> rollNumber;
                displayStudent(rollNumber);
                break;
            case 4:
                cout << "Exiting program.\n";
                break;
            default:
                cout << "Invalid choice. Please try again.\n";
        }
    } while(choice != 4);
    
    return 0;
}