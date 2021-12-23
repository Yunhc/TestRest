package com.example.TestRest.info.repository

class CitySql {
	public static final String SELECT = """
		SELECT ID, Name, CountryCode, District, Population FROM city LIMIT 10;
	""";
}
