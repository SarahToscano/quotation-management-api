Feature: User tries to create stock quotes in a stock

Scenario Outline: Inserting stock quotes with a registered stockId 
	Given a valid stockId '<stockId>' and quotes with date '<date>' and value '<value>'
	When access the /operation route
	Then the quote is created and the response status will be <status>
	
	Examples: 
	| stockId  | 	 date       | value | status |
	| petr4    |   2021-01-11   |  17   |  201   |
	| petr4    |   2021-02-22   |  18   |  201   |
	| petr4    |   04-25        |  20   |  400   |
	| petr4    |   2021-10      |  12   |  400   |
	
	
Scenario Outline: Inserting stock quotes with a unknown stockId  
	Given an invalid stockId '<stockId>' and quotes with date '<date>' and value '<value>'
	When access the /operation route
	Then the quote is not created and the response status will be <status>
	
	Examples: 
	| stockId   | 	 date        | value | status |
	| petr48    |   2021-01-11   |  17   |  404   |
	| petr43    |   2021-02-22   |  18   |  404   |
	| petr47    |   04-25        |  20   |  400   |
	| pet       |   2021-10      |  12   |  400   |
	
	
Scenario Outline: Inserting stock quotes without value 
	Given a valid stockId '<stockId>' and quotes with date '<date>'
	When access the /operation route
	Then the quote is not created and the response status will be <status>
	
	Examples: 
	| stockId  | 	 date        | status |
	| petr4    |   2021-01-11    |  400   |
	| petr4    |   2021-11       |  400   |
	
Scenario Outline: Inserting stock quotes without date 
	Given a valid stockId '<stockId>' and quotes with value '<value>'
	When access the /operation route
	Then the quote is not created and the response status will be <status>
	
	Examples: 
	| stockId  | value   | status |
	| petr4    |   20    |  400   |
	| petr4    |   40    |  400   |
	
Scenario Outline: Inserting stock quotes without date and value
	Given just a valid stockId '<stockId>'
	When access the /operation route
	Then the quote is not created and the response status will be <status>
	
	Examples: 
	| stockId  | status |
	| petr4    |  400   |
	| petr4    |  400   |
