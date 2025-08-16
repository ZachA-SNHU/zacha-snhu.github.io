#ifndef CONTACT_H
#define CONTACT_h

#include <string>

using namespace std;

class Contact {
private:
	string id;
	string firstName;
	string lastName;
	string phoneNumber;
	string address;

public:
	Contact(const string& id, const string& firstName, const string& lastName, const string& phoneNumber, const string& address);

	string getId() const;
	string getFirstName() const;
	string getLastName() const;
	string getPhoneNumber() const;
	string getAddress() const;

	void setId(const string& id);
	void setFirstName(const string& firstName);
	void setLastName(const string& lastName);
	void setPhoneNumber(const string& phoneNumber);
	void setAddress(const string& address);

};



#endif // !CONTACT_H

