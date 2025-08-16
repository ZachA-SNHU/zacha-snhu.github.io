#ifndef CONTACTSERVICE_H
#define CONTACTSERVICE_H

#include "Contact.h"
#include <vector>
#include <string>
//this is the header needed for implementing a hash map
#include <unordered_map>

using namespace std;

class ContactService {
private:
	//getting rid of the Vector, and using a Hashmap instead
	//vector<Contact> contacts;
	unordered_map<string, Contact> contacts;
	// this will be changed to work with the hashmap.
	Contact* findContactById(const string& id);

public:
	bool addContact(const Contact& contact);
	void deleteContact(const string& id);
	void updateFirstName(const string& id, const string& firstName);
	void updateLastName(const string& id, const string& lastName);
	void updatePhoneNumber(const string& id, const string& phoneNumber);
	void updateAddress(const string& id, const string& address);
	vector<Contact> getContacts() const;
};
#endif // !CONTACTSERVICE_H
