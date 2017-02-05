package com.vimal.ws;

import net.webservicex.GeoIP;
import net.webservicex.GeoIPService;
import net.webservicex.GeoIPServiceSoap;

public class IPLocationFinder {

	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("Please provide one IP Address");
		} else {
			final String ipAddress = args[0];
			GeoIPService service = new GeoIPService();
			GeoIPServiceSoap geoIPServiceSoap = service.getGeoIPServiceSoap();
			GeoIP geoIP = geoIPServiceSoap.getGeoIP(ipAddress);
			System.out.println(geoIP.getCountryName());

		}

	}

}
