package org.example.mock.timezones.service;


import org.example.mock.timezones.client.WorldTimeApiClient;

public class TimeZoneService {
	private final WorldTimeApiClient worldTimeApiRestClient;

	public TimeZoneService(WorldTimeApiClient worldTimeApiRestClient) {
		this.worldTimeApiRestClient = worldTimeApiRestClient;
	}

	public String getAvailableTimezoneText(String area) {
		return String.format(
			"Available timezones in %s are %s.",
			area,
			String.join(", ", worldTimeApiRestClient.getValidTimeZones(area))
		);
	}
}
