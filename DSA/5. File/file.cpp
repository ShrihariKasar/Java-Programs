#include <iostream>
#include <fstream>
#include <string>

using namespace std;

struct Student {
    int rollNumber;
    string name;
    string division;
    string address;
};

// Function prototypes
void addStudent();
void deleteStudent(int rollNumber);
void displayStudent(int rollNumber);
void searchStudent(int rollNumber);

int main() {
    char choice;
    do {
        cout << "\nStudent Information System\n";
        cout << "1. Add Student\n";
        cout << "2. Delete Student\n";
        cout << "3. Display Student Information\n";
        cout << "4. Search Student\n";
        cout << "5. Exit\n";
        cout << "Enter your choice: ";
        cin >> choice;

        switch(choice) {
            case '1':
                addStudent();
                break;
            case '2': {
                int rollNum;
                cout << "Enter the roll number of the student to delete: ";
                cin >> rollNum;
                deleteStudent(rollNum);
                break;
            }
            case '3': {
                int rollNum;
                cout << "Enter the roll number of the student to display: ";
                cin >> rollNum;
                displayStudent(rollNum);
                break;
            }
            case '4': {
                int rollNum;
                cout << "Enter the roll number of the student to search: ";
                cin >> rollNum;
                searchStudent(rollNum);
                break;
            }
            case '5':
                cout << "Exiting...\n";
                break;
            default:
                cout << "Invalid choice. Please enter again.\n";
        }
    } while(choice != '5');

    return 0;
}

void addStudent() {
    ofstream outFile("student_info.txt", ios::app);
    if (!outFile) {
        cerr << "Error opening file." << endl;
        return;
    }

    Student newStudent;
    cout << "Enter Roll Number: ";
    cin >> newStudent.rollNumber;
    cout << "Enter Name: ";
    cin.ignore(); // to clear the newline character from the input buffer
    getline(cin, newStudent.name);
    cout << "Enter Division: ";
    getline(cin, newStudent.division);
    cout << "Enter Address: ";
    getline(cin, newStudent.address);

    // Write student information to file
    outFile << newStudent.rollNumber << " " << newStudent.name << " " << newStudent.division << " " << newStudent.address << endl;

    cout << "Student added successfully.\n";
    outFile.close();
}

void deleteStudent(int rollNumber) {
    ifstream inFile("student_info.txt");
    if (!inFile) {
        cerr << "Error opening file." << endl;
        return;
    }

    ofstream tempFile("temp.txt");
    if (!tempFile) {
        cerr << "Error creating temp file." << endl;
        return;
    }

    Student student;
    bool found = false;

    while (inFile >> student.rollNumber >> student.name >> student.division >> student.address) {
        if (student.rollNumber != rollNumber) {
            tempFile << student.rollNumber << " " << student.name << " " << student.division << " " << student.address << endl;
        } else {
            found = true;
        }
    }

    inFile.close();
    tempFile.close();

    if (found) {
        remove("student_info.txt");
        rename("temp.txt", "student_info.txt");
        cout << "Student with roll number " << rollNumber << " deleted successfully.\n";
    } else {
        cout << "Student with roll number " << rollNumber << " not found.\n";
        remove("temp.txt"); // remove temp file if no deletion occurred
    }
}

void displayStudent(int rollNumber) {
    ifstream inFile("student_info.txt");
    if (!inFile) {
        cerr << "Error opening file." << endl;
        return;
    }

    Student student;
    bool found = false;

    while (inFile >> student.rollNumber >> student.name >> student.division >> student.address) {
        if (student.rollNumber == rollNumber) {
            found = true;
            cout << "Roll Number: " << student.rollNumber << endl;
            cout << "Name: " << student.name << endl;
            cout << "Division: " << student.division << endl;
            cout << "Address: " << student.address << endl;
            break;
        }
    }

    inFile.close();

    if (!found) {
        cout << "Student with roll number " << rollNumber << " not found.\n";
    }
}

void searchStudent(int rollNumber) {
    ifstream inFile("student_info.txt");
    if (!inFile) {
        cerr << "Error opening file." << endl;
        return;
    }

    Student student;
    bool found = false;

    while (inFile >> student.rollNumber >> student.name >> student.division >> student.address) {
        if (student.rollNumber == rollNumber) {
            found = true;
            cout << "Student found!\n";
            cout << "Roll Number: " << student.rollNumber << endl;
            cout << "Name: " << student.name << endl;
            cout << "Division: " << student.division << endl;
            cout << "Address: " << student.address << endl;
            break;
        }
    }

    inFile.close();

    if (!found) {
        cout << "Student with roll number " << rollNumber << " not found.\n";
    }
}
