//*************************************************************************************************************************
// 
// CS499 Project1 - ZacharyAbbe.cpp : This file contains the 'main' function. Program execution begins and ends there.
//
//
//*************************************************************************************************************************
#include <iostream>
#include <string>
#include <limits>
#include <stdexcept>
#include "ContactService.h"
#include "AppointmentService.h"
#include "TaskService.h"

using namespace std;

// this will be  replaced with the next project implementing a hashmap
void loadInitialData(ContactService& contactService, AppointmentService& appointmentService, TaskService& taskService) {
    // === Load 50 Contacts ===
    for (int i = 1; i <= 50; ++i) {
        try {
            // Create unique data for each contact
            string id = "C" + to_string(i);
            string firstName = "FName" + to_string(i);
            string lastName = "LName" + to_string(i);
            // Ensure phone number is exactly 10 digits by padding with leading zeros
            string phone = to_string(1000000000 + i);
            string address = to_string(i) + " Programming Lane";

            contactService.addContact(Contact(id, firstName, lastName, phone, address));
        }
        catch (const invalid_argument& e) {
            cerr << "Error loading initial contact: " << e.what() << endl;
        }
    }

    // === Load 50 Appointments ===
    for (int i = 1; i <= 50; ++i) {
        try {
            // Create unique data for each appointment
            string id = "A" + to_string(i);
            string description = "System checkup #" + to_string(i);
            // Set appointments for future dates, staggered by hours
            auto future_date = chrono::system_clock::now() + chrono::hours(24 * i);

            appointmentService.addAppointment(Appointment(id, future_date, description));
        }
        catch (const invalid_argument& e) {
            cerr << "Error loading initial appointment: " << e.what() << endl;
        }
    }

    // === Load 50 Tasks ===
    for (int i = 1; i <= 50; ++i) {
        try {
            // Create unique data for each task
            string id = "T" + to_string(i);
            string name = "TaskName " + to_string(i);
            string desc = "Complete requirement " + to_string(i) + " for the project.";

            taskService.addTask(Task(id, name, desc));
        }
        catch (const invalid_argument& e) {
            cerr << "Error loading initial task: " << e.what() << endl;
        }
    }

    cout << "Initial data loaded: 50 contacts, 50 appointments, and 50 tasks." << endl;
}
// Function to display the main menu
void displayMainMenu() {
    cout << "\n--- Main Menu ---\n";
    cout << "1. Manage Contacts\n";
    cout << "2. Manage Appointments\n";
    cout << "3. Manage Tasks\n";
    cout << "4. Exit\n";
    cout << "Enter your choice: ";
}

// Function to manage contacts
void manageContacts(ContactService& service) {
    int choice;
    
    do {
        cout << "\n--- Contact Management ---\n";
        cout << "1. Add Contact\n";
        cout << "2. Delete Contact\n";
        cout << "3. Update Contact\n";
        cout << "4. View All Contacts\n";
        cout << "5. Back to Main Menu\n";
        cout << "Enter your choice: ";
        cin >> choice;

        if (cin.fail()) {
            cin.clear();
            cin.ignore(numeric_limits<streamsize>::max(), '\n');
            choice = 0; // Invalid choice
        }

        string id, firstName, lastName, phone, address;
        
        switch (choice) {
        case 1: // Add Contact
            cout << "Enter ID (max 10 chars): ";
            cin >> id;
            cout << "Enter First Name (max 10 chars): ";
            cin >> firstName;
            cout << "Enter Last Name (max 10 chars): ";
            cin >> lastName;
            cout << "Enter Phone Number (10 digits): ";
            cin >> phone;
            cout << "Enter Address (max 30 chars): ";
            cin.ignore(); // To consume the newline character
            getline(cin, address);
            try {
                service.addContact(Contact(id, firstName, lastName, phone, address));
                cout << "Contact added successfully.\n";
            }
            catch (const invalid_argument& e) {
                cerr << "Error: " << e.what() << endl;
            }
            break;
        case 2: // Delete Contact
            cout << "Enter ID of contact to delete: ";
            cin >> id;
            service.deleteContact(id);
            cout << "Contact deleted if it existed.\n";
            break;
        case 3: // Update Contact
            cout << "Enter ID of contact to update: ";
            cin >> id;
            cout << "Enter new First Name: ";
            cin >> firstName;
            try {
                service.updateFirstName(id, firstName);
                cout << "Contact updated successfully.\n";
            }
            catch (const invalid_argument& e) {
                cerr << "Error: " << e.what() << endl;
            }
            break;
        case 4: // View All Contacts
        {
            cout << "\n--- All Contacts ---\n";
            
            for (const auto& contact : service.getContacts()) {
                cout << "ID: " << contact.getId() << ", Name: " << contact.getFirstName() << " " << contact.getLastName() << endl;
            }
            break;
        }
        case 5:
            cout << "Returning to main menu.\n";
            system("cls");
            break;
        default:
            cout << "Invalid choice. Please try again.\n";
        }
    } while (choice != 5);
}

// Function to manage appointments
void manageAppointments(AppointmentService& service) {
    int choice;
    do {
        cout << "\n--- Appointment Management ---\n";
        cout << "1. Add Appointment\n";
        cout << "2. Delete Appointment\n";
        cout << "3. View All Appointments\n";
        cout << "4. Back to Main Menu\n";
        cout << "Enter your choice: ";
        cin >> choice;

        if (cin.fail()) {
            cin.clear();
            cin.ignore(numeric_limits<streamsize>::max(), '\n');
            choice = 0;
        }

        string id, description;

        switch (choice) {
        case 1: // Add Appointment
            cout << "Enter Unique ID (max 10 chars): ";
            cin >> id;
            cout << "Enter Description (max 50 chars): ";
            cin.ignore();
            getline(cin, description);
            try {
                // For simplicity, this CLI sets the appointment for 24 hours in the future.
                // A real application would need to parse a date/time string from the user.
                auto future_date = chrono::system_clock::now() + chrono::hours(24);
                service.addAppointment(Appointment(id, future_date, description));
                cout << "Appointment added successfully.\n";
            }
            catch (const invalid_argument& e) {
                cerr << "Error: " << e.what() << endl;
            }
            break;
        case 2: // Delete Appointment
            cout << "Enter ID of appointment to delete: ";
            cin >> id;
            service.deleteAppt(id);
            cout << "Appointment deleted if it existed.\n";
            break;
        case 3: // View All Appointments
            cout << "\n--- All Appointments ---\n";
            if (service.getApptList().empty()) {
                cout << "No appointments to display.\n";
            }
            else {
                for (const auto& appt : service.getApptList()) {
                    // Note: Printing time_point directly is not readable.
                    // We are displaying the readily available info.
                    cout << "ID: " << appt.getUniqueID() << ", Description: " << appt.getDescription() << endl;
                }
            }
            break;
        case 4:
            cout << "Returning to main menu.\n";
            system("cls");
            break;
        default:
            cout << "Invalid choice. Please try again.\n";
        }
    } while (choice != 4);
}


// Function to manage tasks
void manageTasks(TaskService& service) {
    int choice;
    do {
        cout << "\n--- Task Management ---\n";
        cout << "1. Add Task\n";
        cout << "2. Delete Task\n";
        cout << "3. Update Task\n";
        cout << "4. View All Tasks\n";
        cout << "5. Back to Main Menu\n";
        cout << "Enter your choice: ";
        cin >> choice;

        if (cin.fail()) {
            cin.clear();
            cin.ignore(numeric_limits<streamsize>::max(), '\n');
            choice = 0;
        }

        string id, name, desc;

        switch (choice) {
        case 1: // Add Task
            cout << "Enter ID (max 10 chars): ";
            cin >> id;
            cout << "Enter Name (max 20 chars): ";
            cin.ignore();
            getline(cin, name);
            cout << "Enter Description (max 50 chars): ";
            getline(cin, desc);
            try {
                if (service.addTask(Task(id, name, desc))) {
                    cout << "Task added successfully.\n";
                }
            }
            catch (const invalid_argument& e) {
                cerr << "Error: " << e.what() << endl;
            }
            break;
        case 2: // Delete Task
            cout << "Enter ID of task to delete: ";
            cin >> id;
            service.deleteTask(id);
            cout << "Task deleted if it existed.\n";
            break;
        case 3: // Update Task
            cout << "Enter ID of task to update: ";
            cin >> id;
            cout << "Enter new Name (max 20 chars): ";
            cin.ignore();
            getline(cin, name);
            cout << "Enter new Description (max 50 chars): ";
            getline(cin, desc);
            try {
                service.updateName(id, name);
                service.updateDesc(id, desc);
                cout << "Task updated successfully.\n";
            }
            catch (const invalid_argument& e) {
                cerr << "Error: " << e.what() << endl;
            }
            break;
        case 4: // View All Tasks
            cout << "\n--- All Tasks ---\n";
            if (service.getTaskList().empty()) {
                cout << "No tasks to display.\n";
            }
            else {
                for (const auto& task : service.getTaskList()) {
                    cout << "ID: " << task.getUniqId() << ", Name: " << task.getFullName() << ", Desc: " << task.getDesc() << endl;
                }
            }
            break;
        case 5:
            cout << "Returning to main menu.\n";
            system("cls");
            break;
        default:
            cout << "Invalid choice. Please try again.\n";
        }
    } while (choice != 5);
}

int main() {
    ContactService contactService;
    AppointmentService appointmentService;
    TaskService taskService;
    int choice;
    loadInitialData(contactService, appointmentService, taskService);
    do {
        displayMainMenu();
        cin >> choice;

        if (cin.fail()) {
            cin.clear();
            cin.ignore(numeric_limits<streamsize>::max(), '\n');
            choice = 0; // Invalid choice
        }

        switch (choice) {
        case 1:
            manageContacts(contactService);
            break;
        case 2:
            
            manageAppointments(appointmentService);
            break;
        case 3:
            
            manageTasks(taskService);
            break;
        case 4:
            cout << "Exiting program.\n";
            break;
        default:
            cout << "Invalid choice. Please try again.\n";
        }
    } while (choice != 4);

    return 0;
}