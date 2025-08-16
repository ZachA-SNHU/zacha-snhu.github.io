/******************************************************************************
*Name: Zachary Abbe
*Date: 07/16/2025
*Desc: This is the class Appointment.h that houses all the variables for the object
*  and shows the overall functions of the class
******************************************************************************/

#ifndef APPOINTMENT_H 
#define APPOINTMENT_H 

#include <string> 
#include <chrono> 
using namespace std;
class Appointment {
private:
    string uniqId;
    chrono::system_clock::time_point date;
    string description;

    bool validateID(const string& uniqueID);
    bool validateDate(const chrono::system_clock::time_point& _date);
    bool validateDescription(const string& description);

public:
    Appointment(const string& uniqueID, const chrono::system_clock::time_point& date, const string& description);

    string getUniqueID() const;
    chrono::system_clock::time_point getDate() const;
    void setDate(const chrono::system_clock::time_point& date);
    string getDescription() const;
    void setDescription(const string& description);
    void setUniqueID(const string& uniqId);
};

#endif
