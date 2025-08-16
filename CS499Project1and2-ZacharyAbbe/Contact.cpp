#include "Contact.h"
#include <stdexcept>
#include <regex>

using namespace std;

const int idlength = 10;
const int addressLength = 30;
Contact::Contact(const string & id, const string & firstName, const string & lastName, const string & phoneNumber, const string & address)
{
	setId(id);
	setFirstName(firstName);
	setLastName(lastName);
	setPhoneNumber(phoneNumber);
	setAddress(address);
}

//getters for the contact object
string Contact::getId() const
{
	return id;
}

string Contact::getFirstName() const
{
	return firstName;
}

string Contact::getLastName() const
{
	return lastName;
}

string Contact::getPhoneNumber() const
{
	return phoneNumber;
}

string Contact::getAddress() const
{
	return address;
}

//setters for the contact object
void Contact::setId(const string& id)
{
	if(id.empty() || id.length() > idlength)
		{
		throw invalid_argument("Invalid ID");
		}
		this->id = id;
}

void Contact::setFirstName(const string& firstName)
{
	if (firstName.empty() || firstName.length() > idlength)
	{
		throw invalid_argument("Invalid FirstName");
	}

	this->firstName = firstName;

}

void Contact::setLastName(const string& lastName)
{
	if (lastName.empty() || lastName.length() > idlength)
	{
		throw invalid_argument("Invalid LastName");
	}
	this->lastName = lastName;
}

void Contact::setPhoneNumber(const string& phoneNumber)
{
	if (!regex_match(phoneNumber, regex("\\d{10}"))) 
	{
		throw invalid_argument("Invalid Phone Number - must be exactly 10 digits");
	}
	this->phoneNumber = phoneNumber;
}

void Contact::setAddress(const string& address) {
	if (address.empty() || address.length() > addressLength) 
	{
		throw invalid_argument("Invalid Address");
	}
	this->address = address;
}