/******************************************************************************
*Name: Zachary Abbe
*Date: 07/16/2025
*Desc: This is the Appointment.cpp that will be called by main to perform our functions
******************************************************************************/

#include "Appointment.h"
#include <stdexcept>

using namespace std;

const int IDlength = 10;
const int descLength = 50;

// this uses the Appointment class function validateID and provides the code that is ran when this is called
bool Appointment::validateID(const string& uniqueID) 
{
	return !uniqueID.empty() && uniqueID.length() <= IDlength;
}

bool Appointment::validateDate(const chrono::system_clock::time_point& _date) 
{
	return _date > chrono::system_clock::now();
}

bool Appointment::validateDescription(const string& description) 
{
	return !description.empty() && description.length() <= descLength;
}
Appointment::Appointment(const string& uniqueID, const chrono::system_clock::time_point& date, const string& description)
{
	if (!validateID(uniqueID))
	{
		throw invalid_argument("Invalid ID");
	}

	if (!validateDate(date))
	{
		throw invalid_argument("Invalid Date");
	}

	if (!validateDescription(description))
	{
		throw invalid_argument("Invalid Description");
	}

	this->uniqId = uniqueID;
	this->date = date;
	this->description = description;
 }

//getters for the object
string Appointment::getUniqueID() const 
{
	return uniqId;
}

chrono::system_clock::time_point Appointment::getDate() const 
{
	return date;
}

string Appointment::getDescription() const 
{
	return description;
}

//setters for the object

void Appointment::setDate(const chrono::system_clock::time_point& date) 
{
	if (!validateDate(date))
	{
		throw invalid_argument("Invalid Date");
	}
	this->date = date;
}

void Appointment::setUniqueID(const string& uniqueID) 
{
	if (!validateID(uniqueID))
	{
		throw invalid_argument("Invalid ID");
	}
	this->uniqId = uniqueID;
}
void Appointment::setDescription(const string& description)
{
	if (!validateDescription(description))
	{
		throw invalid_argument("Invalid Description");
	}
	this->description = description;
}