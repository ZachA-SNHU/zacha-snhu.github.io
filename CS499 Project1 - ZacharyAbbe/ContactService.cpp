#include "ContactService.h"
#include <stdexcept>
#include <algorithm>

using namespace std;

bool ContactService::addContact(const Contact& contact)
{
	//for (auto& c : contacts)
	//{
	//	if (c.getId() == contact.getId())
	//	{
	//		throw invalid_argument("Duplicate ID");
	//	}
	//}
	//contacts.push_back(contact);
	//return true;
	if (contacts.count(contact.getId()))
	{
		throw invalid_argument("Duplicate ID");
	}
	contacts.insert({ contact.getId(), contact });
	return true;
}
void ContactService::deleteContact(const string& id)
{	// we won't need to use a complicated lambda functiion to delete a contact.
	//contacts.erase(remove_if(contacts.begin(), contacts.end(),[&](const Contact& c) { return c.getId() == id;}), contacts.end());
	contacts.erase(id);
}

Contact* ContactService::findContactById(const string& id)
{
	//for (auto& c : contacts)
	//{
	//	if (c.getId() == id)
	//	{
	//		return &c;
	//	}
	//}
	// we will use the maps method to find the contact
	auto it = contacts.find(id);
		if (it != contacts.end())
		{
			//it is the iterator and it->second gives us the value of the and we can return its address
			return &it->second;
		}
	return nullptr; //return null if not found
}

void ContactService::updateFirstName(const string& id, const string& firstName) 
{
	Contact* contact = findContactById(id);
	if (contact) 
		{
			contact->setFirstName(firstName);
		}
	else 
		{
			throw invalid_argument("Contact not found");
		}
}
void ContactService::updateLastName(const string& id, const string& lastName) 
{
	Contact* contact = findContactById(id);
	if (contact) 
		{
			contact->setLastName(lastName);
		}
	else 
		{	
			throw invalid_argument("Contact not found");
		}
}

void ContactService::updatePhoneNumber(const string& id, const string& phoneNumber) 
{
	Contact* contact = findContactById(id);
	if (contact) 
		{
			contact->setPhoneNumber(phoneNumber);
		}
	else 
		{
			throw invalid_argument("Contact not found");
		}
}

void ContactService::updateAddress(const string& id, const string& address)	
{
	Contact* contact = findContactById(id);
	if (contact) 
		{
			contact->setAddress(address);
		}
	else 
		{
			throw invalid_argument("Contact not found");
		}
}

vector<Contact> ContactService::getContacts() const {
	vector<Contact> contactList;
	for (const auto& pair : contacts) {
		contactList.push_back(pair.second);
	}
	return contactList;  //  return by value 
}