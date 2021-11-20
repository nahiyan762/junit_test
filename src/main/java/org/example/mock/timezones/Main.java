package org.example.mock.timezones;


import org.example.mock.timezones.client.WorldTimeApiHttpClient;
import org.example.mock.timezones.service.TimeZoneService;

public class Main {
	public static void main(String[] args) {
		TimeZoneService timeZoneService = new TimeZoneService(new WorldTimeApiHttpClient());
		System.out.println(timeZoneService.getAvailableTimezoneText("Europe"));
	}
}
