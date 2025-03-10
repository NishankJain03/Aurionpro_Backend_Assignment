package com.aurionpro.test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.aurionpro.model.Country;
import com.aurionpro.model.Region;

public class RegionTest {

	public static void main(String[] args) {
		List<Region> regions = Arrays.asList(
				new Region(1, "Europe"),
				new Region(2, "America"),
				new Region(3, "Asia"),
				new Region(4, "Middle East and Africa")
				);
		List<Country> countries = Arrays.asList(
			new Country("IT", "Italy", regions.get(0)),
			new Country("JP", "Japan", regions.get(2)),
			new Country("US", "United States of America", regions.get(1)),
			new Country("CA", "Canada", regions.get(1)),
			new Country("CN", "China", regions.get(2)),
			new Country("IN", "India", regions.get(2)),
			new Country("AU", "Australia", regions.get(2)),
            new Country("ZW", "Zimbabwe", regions.get(3)),
            new Country("SG", "Singapore", regions.get(2)),
            new Country("UK", "United Kingdom", regions.get(0)),
            new Country("FR", "France", regions.get(0)),
            new Country("DE", "Germany", regions.get(0)),
            new Country("ZM", "Zambia", regions.get(3)),
            new Country("EG", "Egypt", regions.get(3)),
            new Country("BR", "Brazil", regions.get(1)),
            new Country("CH", "Switzerland", regions.get(0)),
            new Country("NL", "Netherlands", regions.get(0)),
            new Country("MX", "Mexico", regions.get(1)),
            new Country("KW", "Kuwait", regions.get(3)),
            new Country("IL", "Israel", regions.get(3)),
            new Country("DK", "Denmark", regions.get(0)),
            new Country("HK", "HongKong", regions.get(2)),
            new Country("NG", "Nigeria", regions.get(3)),
            new Country("AR", "Argentina", regions.get(1)),
            new Country("BE", "Belgium", regions.get(0))
		);
		
		//get name of country from country code
		String countryCode = "BA";
		Optional<String> countryName = countries.stream()
												.filter((cName) -> cName.getCountryCode().equals(countryCode))
												.map(Country::getCountryName)
												.findFirst();
		countryName.ifPresent(name -> System.out.println(name));
		
		//get all the countries in region using regionid
		int regionId = 2;
		List<String> countriesInRegion = countries.stream()
												  .filter((region) -> region.getRegion().getRegionId() == regionId)
												  .map(Country::getCountryName)
												  .collect(Collectors.toList());
		countriesInRegion.forEach(name -> System.out.println(name));
		
		//count of countries in each region
		Map<Object, Long> countryCountbyRegion = countries.stream()
														   .collect(Collectors.groupingBy(country->country.getRegion().getRegionId(), Collectors.counting()));
		
		System.out.println("Country count by region");
		countryCountbyRegion.forEach((rId,count)-> System.out.println(rId + " " + count));
		
		
	}

}
