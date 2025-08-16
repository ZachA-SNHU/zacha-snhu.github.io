#include "Task.h"
#include <stdexcept>

using namespace std;

const int idLength = 10;
const int namelength = 20;
const int descripLength = 50;
Task::Task(const string& id, const string& name, const string& desc)
{
	setID(id);
	setFullName(name);
	setDesc(desc);
}

void Task::setID(const string& id)
{
	if (id.empty() || id.length() > idLength)
	{
		throw invalid_argument("Invalid ID");
	}
	this->uniqId = id;
}

void Task::setFullName(const string& name) 
{
	if (name.empty() || name.length() > namelength) 
	{
		throw invalid_argument("Invalid name");
	}
	this->fullName = name;
}

void Task::setDesc(const string& desc) 
{
	if (desc.empty() || desc.length() > descripLength) 
	{
		throw invalid_argument("Invalid desc");
	}
	this->desc = desc;
}


string Task::getUniqId() const 
{
	return uniqId;
}

string Task::getFullName() const 
{
	return fullName;
}

string Task::getDesc() const 
{
	return desc;
}