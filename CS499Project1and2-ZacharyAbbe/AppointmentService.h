#ifndef APPOINTMENTSERVICE_H
#define APPOINTMENTSERVICE_H

#include "Appointment.h"
#include<vector>
#include<string>
#include <unordered_map>

using namespace std;

class AppointmentService {
private:
	unordered_map<string, Appointment> apptList;
public:
	//vector<Appointment> apptList;

	void addAppointment(const Appointment& appointment);
		Appointment* findApptbyId(const string& id);
	void deleteAppt(const string& id);
	vector<Appointment> getApptList() const;
};




#endif 
