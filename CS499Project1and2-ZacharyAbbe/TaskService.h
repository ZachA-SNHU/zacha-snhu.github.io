#ifndef TASKSERVICE_H
#define TASKSERVICE_H

#include "Task.h"
#include <vector>
#include <string>
#include <iostream>
#include <unordered_map>
using namespace std;

class TaskService {

private:
	unordered_map<string, Task> taskList;
public:
	//vector<Task> tasklist;

	bool addTask(const Task& task);
	Task* findTaskbyId(const string& id);
	void deleteTask(const string& id);
	void updateName(const string& id, const string& name);
	void updateDesc(const string& id, const string& desc);

	 vector<Task> getTaskList() const;

};
#endif // !TASKSERVICE_H

