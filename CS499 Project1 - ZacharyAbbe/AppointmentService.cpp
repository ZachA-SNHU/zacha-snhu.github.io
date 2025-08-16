#include "AppointmentService.h"
#include <algorithm>
#include <stdexcept>

using namespace std;

void AppointmentService::addAppointment(const Appointment& appointment)
{
	//apptList.push_back(appointment);
	if (apptList.count(appointment.getUniqueID())) 
	{
		throw invalid_argument("Appointment with this ID already exists.");
	}
	apptList.insert({ appointment.getUniqueID(), appointment });

}

Appointment* AppointmentService::findApptbyId(const string& id)
{
	/*for (auto& a : apptList)
	{
		if (a.getUniqueID() == id)
		{
			return &a;
		}
	}*/
	auto it = apptList.find(id);
	if (it != apptList.end())
	{
		return &it->second;
	}
	return nullptr;
}

void AppointmentService::deleteAppt(const string& id)
{
	//apptList.erase(remove_if(apptList.begin(), apptList.end(), [&](Appointment& a ){ return a.getUniqueID() == id; }), apptList.end());
	apptList.erase(id);
}

vector<Appointment> AppointmentService::getApptList() const 
{
	vector<Appointment> appointments;
	for (const auto& pair : apptList) 
	{
		appointments.push_back(pair.second);
	}
	return appointments;
}