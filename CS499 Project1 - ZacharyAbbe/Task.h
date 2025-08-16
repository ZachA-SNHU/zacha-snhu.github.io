#ifndef TASK_H
#define TASK_H

#include <string>

using namespace std;

class Task 
{
private:
	string uniqId;
	string fullName;
	string desc;

	void setID(const string& id);

public:
	Task(const string& id, const string& name, const string& desc);

	void setFullName(const string& name);
	void setDesc(const string& description);

	string getUniqId() const;
	string getFullName() const;
	string getDesc() const;
};
#endif //TASK_H
