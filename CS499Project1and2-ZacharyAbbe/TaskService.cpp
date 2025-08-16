#include "TaskService.h"
#include <algorithm>
#include <stdexcept>

using namespace std;

bool TaskService::addTask(const Task& task) 
{
    /*for (const auto& t : tasklist) {
        if (t.getUniqId() == task.getUniqId()) 
        {
            cout << "Task with ID " << task.getUniqId() << " already exists." << endl;
            return false;
        }
    }
    tasklist.push_back(task);
    return true;*/
    if (taskList.count(task.getUniqId())) {
        cout << "Task with ID " << task.getUniqId() << " already exists." << endl;
        return false;
    }
    taskList.insert({ task.getUniqId(), task });
    return true;
}

Task* TaskService::findTaskbyId(const string& id)
{
    //for (auto& t : tasklist) 
    //{
      //  if (t.getUniqId() == id) 
       // {
         //   return &t;
        //}
    //}
    // we will use the new method for finding the ID using our O(1) method
    auto it = taskList.find(id);
    if (it != taskList.end())
    {
        return &it->second;
    }
    return nullptr;
}

void TaskService::deleteTask(const string& id) 
{// again we have no need for the complicated lambda function to delete
    //tasklist.erase(remove_if(tasklist.begin(), tasklist.end(),[&](const Task& t) { return t.getUniqId() == id;}), tasklist.end());
    taskList.erase(id);
}

void TaskService::updateName(const string& id, const string& name) 
{
    Task* task = findTaskbyId(id);
    if (task) 
    {
        task->setFullName(name);
    }
    else 
    {
        throw invalid_argument("Task not found - can't update name");
    }
}

void TaskService::updateDesc(const string& id, const string& desc) 
{
    Task* task = findTaskbyId(id);
    if (task) 
    {
        task->setDesc(desc);
    }
    else 
    {
        throw invalid_argument("Task not found - can't update the description");
    }
}

vector<Task> TaskService::getTaskList() const 
{
    vector<Task> tasks;
    for (const auto& pair : taskList)
    {
        tasks.push_back(pair.second);
    }
    return tasks;
}